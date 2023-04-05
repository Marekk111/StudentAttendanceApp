package com.bakalarka.StudentAttendanceApp.repo;

import com.bakalarka.StudentAttendanceApp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
