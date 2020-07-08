package com.example.lab05.service;

import com.example.lab05.domain.Person;

import java.util.List;
import java.util.Locale;

public interface MessegeService {
    String getSurnameMessage(Locale locale);
    String getNameMessage(Locale locale);
    String getQuestionMessage(Locale locale,int i);
    String getQuestionsMessage(Locale locale);
    String getResultMessage(Locale locale,Person person);
    List<String> getAllQuestionsMessage(Locale locale);
    String getAnswerCorrect(Locale locale);
    String getAnswerIncorrect(Locale locale);
}
