package com.example.lab04.service;


import org.springframework.stereotype.Service;

import java.util.List;
public interface AnswerService {
    List<String[]> AllAnswer() throws Exception;
}
