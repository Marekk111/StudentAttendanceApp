package com.bakalarka.StudentAttendanceApp.repo;

import com.bakalarka.StudentAttendanceApp.model.Answer;
import com.bakalarka.StudentAttendanceApp.model.LessonEvent;
import com.bakalarka.StudentAttendanceApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepo extends JpaRepository<Answer, Long> {

    Optional<Answer> findAnswerById(Long id);
    void deleteAnswerById(Long id);

    List<Answer> findAnswersByQuestionAndLessonId(Question question, Long lessonId);
}
