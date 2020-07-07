package com.example.lab04;

import com.example.lab04.domain.Person;
import com.example.lab04.service.MessegeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

@SpringBootTest(classes = Lab04Application.class)
@ExtendWith(SpringExtension.class)
public class MessegeLoadTest {
    @Autowired
    MessegeService messegeService;
    private Locale locale;

    @Test
    void messegeNameLoads(){
        locale = new Locale("uk","UA");
        Assert.assertEquals("Напишіть ваше ім'я",(messegeService.getNameMessage(locale)));
        locale = Locale.ENGLISH;
        Assert.assertEquals("Write your name",(messegeService.getNameMessage(locale)));
    }
    @Test
    void messegeSurnnameLoads(){
        locale = new Locale("uk","UA");
        Assert.assertEquals("Напишіть ваше призвіще",(messegeService.getSurnameMessage(locale)));
        locale = Locale.ENGLISH;
        Assert.assertEquals("Write your surname",(messegeService.getSurnameMessage(locale)));
    }
    @Test
    void messegeQuestionsLoads(){
        locale = new Locale("uk","UA");
        Assert.assertEquals("Дайте відповідь на питання",(messegeService.getQuestionsMessage(locale)));
        locale = Locale.ENGLISH;
        Assert.assertEquals("Answer the questions",(messegeService.getQuestionsMessage(locale)));
    }
    @Test
    void messegeResultLoads(){
        Person person = new Person("test","test");
        person.setResult(90);
        locale = new Locale("uk","UA");
        Assert.assertEquals("test test ваш результат 90",(messegeService.getResultMessage(locale,person)));
        locale = Locale.ENGLISH;
        Assert.assertEquals("test test your result 90",(messegeService.getResultMessage(locale,person)));
    }
    @Test
    void messegeQuestion1Load(){
        locale = new Locale("uk","UA");
        Assert.assertEquals("На другий склад падає наголос у слові:\n1 бешкет;\n2 вимога; \n3 колесо; \n4 донька",(messegeService.getQuestionMessage(locale,0)));
        locale = Locale.ENGLISH;
        Assert.assertEquals("question1 2", (messegeService.getQuestionMessage(locale,0)));
    }
    @Test
    void messegeQuestion2Load(){
        locale = new Locale("uk","UA");
        Assert.assertEquals("Кому перед виділеним словом треба поставити в реченні (розділові знаки пропущено)\n1 Забудькуватість чомусь завжди сприймають як грім з ясного неба\n2 Спогади традиційно трактують як пасивний розпад інформації\n3 Поступово окремі наші спогади справді вигорають як чорнило на сонці\n4 Пам’ять визначають як властивість мозку діяти за певним стереотипом",(messegeService.getQuestionMessage(locale,1)));
        locale = Locale.ENGLISH;
        Assert.assertEquals("question2 3", (messegeService.getQuestionMessage(locale,1)));
    }
    @Test
    void messegeQuestion3Load(){
        locale = new Locale("uk","UA");
        Assert.assertEquals("У прямому значенні вжито всі прикметники в рядку\n1 гострий біль, минулі роки, живильна вода\n2 глибоке озеро, золоте слово, жорсткий матрац\n3 шовкова хустка, теплі спогади, ясне небо\n4 дитячі голоси, свіжий хліб, настільна лампа",(messegeService.getQuestionMessage(locale,2)));
        locale = Locale.ENGLISH;
        Assert.assertEquals("question3 4", (messegeService.getQuestionMessage(locale,2)));
    }
    @Test
    void messegeQuestion4Load(){
        locale = new Locale("uk","UA");
        Assert.assertEquals("Суфікс -ик- має однакове значення в усіх словах, ОКРІМ\n1 вузлик\n2 лірик\n3 коник\n4 столик",(messegeService.getQuestionMessage(locale,3)));
        locale = Locale.ENGLISH;
        Assert.assertEquals("question4 2", (messegeService.getQuestionMessage(locale,3)));
    }
    @Test
    void messegeQuestion5Load(){
        locale = new Locale("uk","UA");
        Assert.assertEquals("Порушено норму узгодження прикметника з іменником у рядку\n1 щаслива путь\n2 струнка фрау\n3 учена ступінь\n4 смачна івасі",(messegeService.getQuestionMessage(locale,4)));
        locale = Locale.ENGLISH;
        Assert.assertEquals("question5 3", (messegeService.getQuestionMessage(locale,4)));
    }
}
