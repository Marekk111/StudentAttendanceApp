package com.bakalarka.StudentAttendanceApp.service;

import com.bakalarka.StudentAttendanceApp.Exception.AnswerOptionNotFoundException;
import com.bakalarka.StudentAttendanceApp.model.AnswerOption;
import com.bakalarka.StudentAttendanceApp.repo.AnswerOptionRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerOptionService {

    private final AnswerOptionRepo answerOptionRepo;

    @Autowired
    public AnswerOptionService(AnswerOptionRepo answerOptionRepo) {
        this.answerOptionRepo = answerOptionRepo;
    }

    public List<AnswerOption> getAnswerOptions() {
        return this.answerOptionRepo.findAll();
    }

    public AnswerOption findAnswerOptionById(Long id) {
        return this.answerOptionRepo.findAnswerOptionById(id).orElseThrow(() -> new AnswerOptionNotFoundException("AnswerOption by id " + id + " was not found"));
    }

    public AnswerOption addAnswerOption(AnswerOption option) {
        return this.answerOptionRepo.save(option);
    }


    @Transactional
    public void deleteAnswerOptionById(Long id) {
        this.answerOptionRepo.deleteAnswerOptionById(id);
    }





}
