package com.bakalarka.StudentAttendanceApp.service;

import com.bakalarka.StudentAttendanceApp.Exception.QuestionNotFoundException;
import com.bakalarka.StudentAttendanceApp.model.Answer;
import com.bakalarka.StudentAttendanceApp.model.Question;
import com.bakalarka.StudentAttendanceApp.repo.QuestionRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepo questionRepo;

    @Autowired
    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public Question addQuestion(Question question) {
        return questionRepo.save(question);
    }




    public List<Question> findAllQuestions() {
        return questionRepo.findAll();
    }

    public List<Answer> findAllAnswersForQuestion(Long id) {
        return this.findQuestionById(id).getAnswers();
    }

    public Question findQuestionById(Long id) {
        return questionRepo.findQuestionById(id).orElseThrow(() -> new QuestionNotFoundException("Quesiton by id " + id + " was not found"));
    }

    @Transactional
    public void deleteQuestion(long id) {
        questionRepo.deleteQuestionById(id);
    }

    public Question updateQuestion(Question question) {
        return questionRepo.save(question);
    }
}
