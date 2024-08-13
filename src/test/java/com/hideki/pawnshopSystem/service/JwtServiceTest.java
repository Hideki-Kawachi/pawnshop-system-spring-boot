package com.hideki.pawnshopSystem.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.security.Key;

@SpringBootTest
public class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    @Test
    void getSignInKeyTest(){
        Key signInKey = jwtService.getSignInKey();
        System.out.println("signInKey: " + signInKey);
        Assertions.assertThat(signInKey).isNotNull();
    }
}
