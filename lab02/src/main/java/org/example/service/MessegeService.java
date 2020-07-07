package org.example.service;

import org.example.domain.Person;

import java.util.Locale;

public interface MessegeService {
    String getSurnameMessage(Locale locale);
    String getNameMessage(Locale locale);
    String getQuestionMessage(Locale locale,int i);
    String getQuestionsMessage(Locale locale);
    String getResultMessage(Locale locale,Person person);
}
