package org.example.service;

import org.example.domain.AnswerOnTask;
import org.example.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;
@Service
public class MessegeServiceImpl implements MessegeService{
    @Autowired
    private MessageSource messageSource;

    Scanner in = new Scanner(System.in);
    String ans;

    @Override
    public Person MessegeFullName(Person newPerson) {
        System.out.println(messageSource.getMessage("write.name", null, Locale.ENGLISH));
        newPerson.setName(in.next());
        System.out.println( messageSource.getMessage("write.surname", null, Locale.ENGLISH) );
        newPerson.setSurname(in.next());
        return newPerson;
    }

    @Override
    public Person MessegeQuestion(AnswerOnTask answer,Person newPerson) {
        Locale locale = new Locale("ua","UA");
        System.out.println( messageSource.getMessage("write.questions", null, Locale.ENGLISH) );
        for (int i=0;i<5;i++) {
            System.out.println(messageSource.getMessage("write.question"+(i+1), null, locale));
            ans = in.next();
            if(answer.getAnswer().get(i)[0].equals(ans))
                newPerson.setResult(newPerson.getResult()+1);
        }
        return newPerson;
    }

    @Override
    public void MessegeResult(Person person) {
        System.out.println(messageSource.getMessage("read.result",new Object[]{person.getName(),person.getSurname(),person.getResult()}, Locale.ENGLISH));
    }
}
