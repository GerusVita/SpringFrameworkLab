package org.example;

import org.example.domain.AnswerOnTask;
import org.example.domain.Person;
import org.example.domain.Task;
import org.example.service.AnswerService;
import org.example.service.TaskService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TaskService s = context.getBean(TaskService.class);
        AnswerService as = context.getBean(AnswerService.class);

        Scanner in = new Scanner(System.in);
        int i=0;
        String ans;

        Person newPerson = new Person();
        Task task = new Task();
        AnswerOnTask answer = new AnswerOnTask();

        task.setTaskForTest(s.AllTask());
        answer.setAnswer(as.AllAnswer());

        System.out.println( "Write your name " );
        newPerson.setName(in.next());
        System.out.println( "Write your surname " );
        newPerson.setSurname(in.next());

        System.out.println( "Answer the questions " );
        for (String[] oneTask: task.getTaskForTest()) {
            System.out.println(String.join(",",oneTask));
            if(oneTask[0].equals("Відповідь")){
                ans = in.next();
                if(answer.getAnswer().get(i)[0].equals(ans))
                    newPerson.setResult(newPerson.getResult()+1);
                i++;
            }
        }
        System.out.println( newPerson.getName()+" "+newPerson.getSurname()+" your result "+newPerson.getResult() );
    }
}
