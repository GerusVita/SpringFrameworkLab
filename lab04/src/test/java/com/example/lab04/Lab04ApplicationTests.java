package com.example.lab04;

import com.example.lab04.service.AnswerService;
import com.example.lab04.service.MessegeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Lab04Application.class)
@ExtendWith(SpringExtension.class)
class Lab04ApplicationTests {
    @Test
    void contextLoads() {
    }
}
