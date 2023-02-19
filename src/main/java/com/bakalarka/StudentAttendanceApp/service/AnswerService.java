package com.bakalarka.StudentAttendanceApp.service;

import com.bakalarka.StudentAttendanceApp.Exception.AnswerNotFoundException;
import com.bakalarka.StudentAttendanceApp.Exception.QuestionNotFoundException;
import com.bakalarka.StudentAttendanceApp.model.Answer;
import com.bakalarka.StudentAttendanceApp.model.Question;
import com.bakalarka.StudentAttendanceApp.repo.AnswerRepo;
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

    public Answer updateAnswer(Answer answer) {
        return answerRepo.save(answer);
    }

    public List<Answer> findAllAnswers() {
        return answerRepo.findAll();
    }

    public Answer findAnswerById(Long id) {
        return answerRepo.findAnswerById(id).orElseThrow(() -> new AnswerNotFoundException("Quesiton by id " + " was not found"));
    }

    @Transactional
    public void deleteAnswer(long id) {
        answerRepo.deleteAnswerById(id);
    }

}
