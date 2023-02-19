package com.bakalarka.StudentAttendanceApp.resource;

import com.bakalarka.StudentAttendanceApp.model.Question;
import com.bakalarka.StudentAttendanceApp.service.QuestionService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionResource {
    private final QuestionService questionService;

    public QuestionResource(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = this.questionService.findAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.questionService.findQuestionById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(this.questionService.addQuestion(question), HttpStatus.CREATED);
    }

    @PutMapping("/update ")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        return new ResponseEntity<>(this.questionService.updateQuestion(question), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable("id") Long id) {
        this.questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
