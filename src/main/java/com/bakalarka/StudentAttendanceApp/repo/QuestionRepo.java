package com.bakalarka.StudentAttendanceApp.repo;


import com.bakalarka.StudentAttendanceApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepo extends JpaRepository<Question, Long> {
    Optional<Question> findQuestionById(Long id);

    void deleteQuestionById(Long id);
}
