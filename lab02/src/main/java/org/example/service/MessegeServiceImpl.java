package org.example.service;

import org.example.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessegeServiceImpl implements MessegeService{
    @Autowired
    private MessageSource messageSource;
    //private Locale locale = Locale.ENGLISH;
    //private Locale locale = new Locale("uk", "UA");


    public String getSurnameMessage(Locale locale) {
        return messageSource.getMessage("write.surname", null, locale);
    }

    public String getNameMessage(Locale locale) {
        return messageSource.getMessage("write.name", null, locale);
    }

    public String getQuestionMessage(Locale locale,int i) {
        return messageSource.getMessage("write.question"+(i+1), null, locale);
    }

    public String getQuestionsMessage(Locale locale) {
        return messageSource.getMessage("write.questions", null, locale);
    }

    public String getResultMessage(Locale locale,Person person) {
        return messageSource.getMessage("read.result",new Object[]{person.getName(),person.getSurname(),person.getResult()}, locale);
    }
}
