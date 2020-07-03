package org.example;

//import org.example.config.DaoConfig;
import org.example.config.AppConfig;
import org.example.domain.AnswerOnTask;
import org.example.domain.Person;
import org.example.service.AnswerService;
import org.example.service.MessegeService;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

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
        MessegeService messege = context.getBean(MessegeService.class);

        Person newPerson = new Person();

        AnswerOnTask answer = new AnswerOnTask();

        answer.setAnswer(as.AllAnswer());

        newPerson = messege.MessegeFullName(newPerson);
        newPerson = messege.MessegeQuestion(answer,newPerson);
        messege.MessegeResult(newPerson);
        System.out.println( "Hello World!" );
    }
}
