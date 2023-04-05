package com.bakalarka.StudentAttendanceApp.service;

import com.bakalarka.StudentAttendanceApp.model.AppUser;
import com.bakalarka.StudentAttendanceApp.model.AppUserDetails;
import com.bakalarka.StudentAttendanceApp.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepo appUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByUsername(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("Could not find user " + username);
        }
        return new AppUserDetails(appUser);
    }
}
