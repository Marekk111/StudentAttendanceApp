package com.bakalarka.StudentAttendanceApp.service;

import com.bakalarka.StudentAttendanceApp.Exception.AnswerNotFoundException;
import com.bakalarka.StudentAttendanceApp.model.Answer;
import com.bakalarka.StudentAttendanceApp.model.LessonEvent;
import com.bakalarka.StudentAttendanceApp.model.Question;
import com.bakalarka.StudentAttendanceApp.repo.AnswerRepo;
import com.bakalarka.StudentAttendanceApp.repo.QuestionRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepo answerRepo;

    @Autowired
    public AnswerService(AnswerRepo answerRepo) {
        this.answerRepo = answerRepo;
    }

    public Answer addAnswer(Answer answer) {
        return answerRepo.save(answer);
    }

    public List<Answer> getAllAnswers() { return answerRepo.findAll();}

    public Answer getAnswerById(Long id) {
        return this.answerRepo.findAnswerById(id).orElseThrow(() -> new AnswerNotFoundException("Answer by id " + id + " was not found"));
    }

    public List<Answer> getAnswersByQuestionAndGroup(Question question, Long lessonId) {
        return this.answerRepo.findAnswersByQuestionAndLessonId(question, lessonId);
    }

    @Transactional
    public void deleteAnswerById(Long id) {
        answerRepo.deleteAnswerById(id);
    }
}
