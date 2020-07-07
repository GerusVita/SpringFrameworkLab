package com.example.lab04;

import com.example.lab04.domain.AnswerOnTask;
import com.example.lab04.domain.Person;
import com.example.lab04.service.AnswerService;
import com.example.lab04.service.MessegeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Lab04Application {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Lab04Application.class, args);

        AnswerService as = context.getBean(AnswerService.class);
        MessegeService messages = context.getBean(MessegeService.class);

        Person newPerson = new Person();
        AnswerOnTask answer = new AnswerOnTask();

        answer.setAnswer(as.AllAnswer());
        Scanner in = new Scanner(System.in);
        String ans;
        Locale locale = new Locale("uk", "UA");

        System.out.println(messages.getNameMessage(locale));
        newPerson.setName(in.next());
        System.out.println(messages.getSurnameMessage(locale));
        newPerson.setSurname(in.next());

        System.out.println(messages.getQuestionsMessage(locale));
        for (int i=0;i<5;i++) {
            System.out.println(messages.getQuestionMessage(locale,i));
            ans = in.next();
            if(answer.getAnswer().get(i)[0].equals(ans))
                newPerson.setResult(newPerson.getResult()+1);
        }
        System.out.println(messages.getResultMessage(locale,newPerson));
    }

}
