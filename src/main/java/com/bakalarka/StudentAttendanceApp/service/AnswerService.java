package com.bakalarka.StudentAttendanceApp.service;

import com.bakalarka.StudentAttendanceApp.Exception.AnswerNotFoundException;
import com.bakalarka.StudentAttendanceApp.model.Answer;
import com.bakalarka.StudentAttendanceApp.repo.AnswerRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepo answerRepo;

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

    @Transactional
    public void deleteAnswerById(Long id) {
        answerRepo.deleteAnswerById(id);
    }
}
