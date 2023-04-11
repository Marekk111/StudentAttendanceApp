package com.bakalarka.StudentAttendanceApp.repo;

import com.bakalarka.StudentAttendanceApp.model.LessonEvent;
import com.bakalarka.StudentAttendanceApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface LessonEventRepo extends JpaRepository<LessonEvent, Long> {

    Optional<LessonEvent> findLessonEventById(Long id);
    void deleteLessonEventById(Long id);

}
