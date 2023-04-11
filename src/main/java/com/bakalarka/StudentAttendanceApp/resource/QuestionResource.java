package com.bakalarka.StudentAttendanceApp.resource;

import com.bakalarka.StudentAttendanceApp.model.Answer;
import com.bakalarka.StudentAttendanceApp.model.AnswerOption;
import com.bakalarka.StudentAttendanceApp.model.LessonEvent;
import com.bakalarka.StudentAttendanceApp.model.Question;
import com.bakalarka.StudentAttendanceApp.service.LessonEventService;
import com.bakalarka.StudentAttendanceApp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionResource {
    private final QuestionService questionService;
    private final LessonEventService lessonEventService;

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = this.questionService.findAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}/answers")
    public ResponseEntity<List<Answer>> getAllAnswersForQuestion(@PathVariable("id") Long id) {
        List<Answer> answers = this.questionService.findAllAnswersForQuestion(id);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.questionService.findQuestionById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(this.questionService.addQuestion(question), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        return new ResponseEntity<>(this.questionService.updateQuestion(question), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable("id") Long id) {
        this.questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}/options")
    public ResponseEntity<List<AnswerOption>> getAllOptions(@PathVariable("id") Long id) {
        List<AnswerOption> options = this.questionService.getAnswerOptions(id);
        return new ResponseEntity<>(options, HttpStatus.OK);
    }





}
