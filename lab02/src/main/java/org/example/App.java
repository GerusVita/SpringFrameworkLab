package org.example;

//import org.example.config.DaoConfig;
import org.example.config.AppConfig;
import org.example.domain.AnswerOnTask;
import org.example.domain.Person;
import org.example.service.AnswerService;
import org.example.service.MessegeService;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Locale;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan
public class App
{
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        context.register(AppConfig.class);

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
