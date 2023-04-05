package com.bakalarka.StudentAttendanceApp.service;

import com.bakalarka.StudentAttendanceApp.model.AppUser;
import com.bakalarka.StudentAttendanceApp.repo.AppUserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AppUserService{
    private final AppUserRepo appUserRepo;

    private final PasswordEncoder passwordEncoder;

    public AppUser saveUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepo.save(user);
    }

    public AppUser getUser(String username) {
        return appUserRepo.findByUsername(username);
    }

    public List<AppUser> getUsers() {
        return appUserRepo.findAll();
    }


}
