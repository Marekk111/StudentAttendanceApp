package com.bakalarka.StudentAttendanceApp.resource;

import com.bakalarka.StudentAttendanceApp.model.AnswerOption;
import com.bakalarka.StudentAttendanceApp.service.AnswerOptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/option")
public class AnswerOptionResource {

    private final AnswerOptionService answerOptionService;

    public AnswerOptionResource(AnswerOptionService answerOptionService) {
        this.answerOptionService = answerOptionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AnswerOption>> getAnswerOptions() {
        List<AnswerOption> answerOptions = this.answerOptionService.getAnswerOptions();
        return new ResponseEntity<>(answerOptions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AnswerOption> addAnswerOption(@RequestBody AnswerOption answerOption) {
        return new ResponseEntity<>(this.answerOptionService.addAnswerOption(answerOption), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AnswerOption> findAnswerOption(@PathVariable("id") Long id) {
        AnswerOption answerOption = this.answerOptionService.findAnswerOptionById(id);
        return new ResponseEntity<>(answerOption, HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<AnswerOption> deleteAnswerOption(@PathVariable("id") Long id) {
        this.answerOptionService.deleteAnswerOptionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
