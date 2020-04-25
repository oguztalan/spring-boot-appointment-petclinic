package com.oguztalan.petclinic;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTests {

    @Test
    public void generateEncodedPasswords() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("{bcrypt}" + passwordEncoder.encode("password"));
        System.out.println("{bcrypt}" + passwordEncoder.encode("secret"));
        System.out.println("{bcrypt}" + passwordEncoder.encode("secret"));
    }
}
