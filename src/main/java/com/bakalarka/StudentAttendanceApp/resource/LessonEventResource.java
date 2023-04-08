package com.bakalarka.StudentAttendanceApp.resource;

import com.bakalarka.StudentAttendanceApp.model.LessonEvent;
import com.bakalarka.StudentAttendanceApp.model.Question;
import com.bakalarka.StudentAttendanceApp.service.LessonEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonEventResource {

    private final LessonEventService lessonEventService;

    @GetMapping("/find/all")
    public ResponseEntity<List<LessonEvent>> getLessons(){
        return new ResponseEntity<>(this.lessonEventService.getLessons(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<LessonEvent> findLesson(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.lessonEventService.getLessonById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<LessonEvent> addLesson(@RequestBody LessonEvent lesson) {
        return new ResponseEntity<>(this.lessonEventService.addLesson(lesson), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<LessonEvent> deleteLesson(@PathVariable("id") Long id) {
        this.lessonEventService.deleteLessonById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/find/{id}/addQuestion")
    public ResponseEntity<LessonEvent> addQuestionToLesson(@PathVariable("id") Long id, @RequestBody Question question) {
        LessonEvent lesson = this.lessonEventService.addQuestionToLesson(id, question);
        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }

    @GetMapping("/find/{id}/question")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Long id) {
        Question question = this.lessonEventService.getQuestionOfLesson(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
}
