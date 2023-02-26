package com.bakalarka.StudentAttendanceApp.repo;

import com.bakalarka.StudentAttendanceApp.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepo extends JpaRepository<Answer, Long> {

    Optional<Answer> findAnswerById(Long id);
    void deleteAnswerById(Long id);
}
