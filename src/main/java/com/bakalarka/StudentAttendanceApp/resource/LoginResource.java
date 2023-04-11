package com.bakalarka.StudentAttendanceApp.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class LoginResource {

    @RequestMapping("/login")
    public String login() {
        return "Authenticated successfully!";
    }

    @GetMapping("/getPrincipal")
    public String getUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return username;
    }

    @GetMapping("/getRole")
    public String getUserRole() {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        List<String> authorityStrings = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            authorityStrings.add(authority.getAuthority());
        }
        return authorityStrings.get(0);
    }

}
