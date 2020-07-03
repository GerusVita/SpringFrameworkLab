package org.example.service;

import org.example.domain.AnswerOnTask;
import org.example.domain.Person;
import org.springframework.stereotype.Service;

@Service
public interface MessegeService {
    Person MessegeFullName(Person newPerson);
    Person MessegeQuestion(AnswerOnTask answer,Person newPerson);
    void MessegeResult(Person person);
}
