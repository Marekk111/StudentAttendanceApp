package com.bakalarka.StudentAttendanceApp.service;

import com.bakalarka.StudentAttendanceApp.Exception.LessonNotFoundException;
import com.bakalarka.StudentAttendanceApp.model.LessonEvent;
import com.bakalarka.StudentAttendanceApp.model.Question;
import com.bakalarka.StudentAttendanceApp.repo.LessonEventRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LessonEventService {

    private final LessonEventRepo lessonEventRepo;

    public List<LessonEvent> getLessons() {
        List<LessonEvent> lessonEvents = lessonEventRepo.findAll();
        return lessonEvents;
    }

    public LessonEvent getLessonById(Long id) {
        return lessonEventRepo.findLessonEventById(id).orElseThrow(() -> new LessonNotFoundException("Lesson by id " + id + " was not found"));
    }

    public LessonEvent addLesson(LessonEvent lessonEvent) {
        return lessonEventRepo.save(lessonEvent);
    }

    public LessonEvent addQuestionToLesson(Long lessonId, Question question) {
        LessonEvent lesson = this.getLessonById(lessonId);
        lesson.setQuestion(question);
        return lessonEventRepo.save(lesson);
    }

    public void deleteLessonById(Long id) {
        lessonEventRepo.deleteLessonEventById(id);
    }

    public Question getQuestionOfLesson(Long id) {
        LessonEvent lesson = this.getLessonById(id);
        return lesson.getQuestion();
    }

}
