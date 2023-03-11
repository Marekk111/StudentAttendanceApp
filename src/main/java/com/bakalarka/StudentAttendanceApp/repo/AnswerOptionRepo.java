package com.bakalarka.StudentAttendanceApp.repo;

import com.bakalarka.StudentAttendanceApp.model.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerOptionRepo extends JpaRepository<AnswerOption, Long> {

    Optional<AnswerOption> findAnswerOptionById(Long id);

    void deleteAnswerOptionById(Long id);
}
