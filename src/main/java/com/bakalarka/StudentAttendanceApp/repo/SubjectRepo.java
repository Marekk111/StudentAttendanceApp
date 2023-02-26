package com.bakalarka.StudentAttendanceApp.repo;

import com.bakalarka.StudentAttendanceApp.model.Question;
import com.bakalarka.StudentAttendanceApp.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface SubjectRepo extends JpaRepository<Subject, Long> {
    Optional<Subject> findSubjectById(Long id);
    void deleteSubjectById(Long id);
}
