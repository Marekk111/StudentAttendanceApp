package com.bakalarka.StudentAttendanceApp.resource;

import com.bakalarka.StudentAttendanceApp.model.Answer;
import com.bakalarka.StudentAttendanceApp.model.LessonEvent;
import com.bakalarka.StudentAttendanceApp.model.Question;
import com.bakalarka.StudentAttendanceApp.service.AnswerService;
import com.bakalarka.StudentAttendanceApp.service.LessonEventService;
import com.bakalarka.StudentAttendanceApp.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerResource {
    private final AnswerService answerService;
    private final LessonEventService lessonEventService;
    private final QuestionService questionService;

    public AnswerResource(AnswerService answerService, QuestionService questionService, LessonEventService lessonEventService) {
        this.answerService = answerService;
        this.questionService = questionService;
        this.lessonEventService = lessonEventService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = this.answerService.getAllAnswers();
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") Long id) {
        Answer answer = this.answerService.getAnswerById(id);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Answer> addAnswer(@RequestBody Answer answer) {
        return new ResponseEntity<>(this.answerService.addAnswer(answer), HttpStatus.CREATED);
    }

    @GetMapping("/find/{lessonId}/{questionId}")
    public ResponseEntity<List<Answer>> getAnswersByQuestionAndGroup(@PathVariable("questionId") Long questionId,@PathVariable("lessonId") Long lessonId) {
        Question question = this.questionService.findQuestionById(questionId);
        return new ResponseEntity<>(this.answerService.getAnswersByQuestionAndGroup(question, lessonId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Answer> deleteAnswer(@PathVariable("id") Long id) {
        this.answerService.deleteAnswerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
