package com.example.lab05.shellCommand;

import com.example.lab05.domain.AnswerOnTask;
import com.example.lab05.domain.Person;
import com.example.lab05.service.AnswerService;
import com.example.lab05.service.MessegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;
import java.util.Locale;

@ShellComponent
public class SellCommand {
    Person person = new Person();
    AnswerOnTask answer = new AnswerOnTask();
    Locale locale = Locale.ENGLISH;
    int ans = 0;

    @Autowired
    MessegeService messegeService;
    final
    AnswerService answerService;
    public SellCommand(AnswerService answerService) throws Exception {
        answer.setAnswer(answerService.AllAnswer());
        this.answerService = answerService;
    }

    @ShellMethod("full name")
    public String fullname(@ShellOption String name,@ShellOption String surname){
        person.setName(name);
        person.setSurname(surname);
        person.setResult(0);
        return name+ " "+surname;
    }
    @ShellMethod("questions")
    public List<String> questions(){
        return messegeService.getAllQuestionsMessage(locale);
    }
    @ShellMethod("change locale")
    public String changelocale(){
        if(locale==Locale.ENGLISH)
        locale = new Locale("uk","UA");
        else locale=Locale.ENGLISH;
        return locale.getDisplayCountry();
    }
    @ShellMethod("Answer to question")
    public String answer(@ShellOption int name,@ShellOption String youranswer){
        if(answer.getAnswer().get(name)[0].equals(youranswer)){
            person.setResult(person.getResult()+1);
            return messegeService.getAnswerCorrect(locale);
        }else return messegeService.getAnswerIncorrect(locale);
    }
    @ShellMethod("My result")
    public String result(){
        return messegeService.getResultMessage(locale,person);
    }
}
