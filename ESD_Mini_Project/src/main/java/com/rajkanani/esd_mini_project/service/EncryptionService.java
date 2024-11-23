package com.rajkanani.esd_mini_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncryptionService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean validates(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }
}
