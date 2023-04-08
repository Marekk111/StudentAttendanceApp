package com.bakalarka.StudentAttendanceApp.resource;

import com.bakalarka.StudentAttendanceApp.model.Answer;
import com.bakalarka.StudentAttendanceApp.model.LessonEvent;
import com.bakalarka.StudentAttendanceApp.service.AnswerService;
import com.bakalarka.StudentAttendanceApp.service.LessonEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("questionnaire")
@RequiredArgsConstructor
public class QuestionnaireResource {

    private final AnswerService answerService;
    private final LessonEventService lessonEventService;

    @PostMapping("/{id}/answerQuestion")
    public ResponseEntity<?> answerQuestion(@PathVariable("id") Long id, @RequestBody Answer answer){
        LocalDateTime now = LocalDateTime.now();
        LessonEvent lesson = this.lessonEventService.getLessonById(id);
        if (lesson.getTimeStart().isAfter(now) || lesson.getTimeEnd().isBefore(now)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Outside of the allotted time to answer!");
        } else {
            return new ResponseEntity<>(this.answerService.addAnswer(answer), HttpStatus.CREATED);
        }
    }
}
