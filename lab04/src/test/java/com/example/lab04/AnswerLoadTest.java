package com.example.lab04;

import com.example.lab04.service.AnswerService;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest(classes = Lab04Application.class)
@ExtendWith(SpringExtension.class)
public class AnswerLoadTest {
    @Autowired
    public AnswerService answerService;
    List<String[]> res = new ArrayList<>();

    @Test
    public void answerLoads() throws Exception {
        res.add(new String[]{"2"});
        res.add(new String[]{"3"});
        res.add(new String[]{"4"});
        res.add(new String[]{"2"});
        res.add(new String[]{"3"});
//        Assert.assertEquals("2",(answerService.AllAnswer().get(0)[0]));
//        Assert.assertEquals("3",(answerService.AllAnswer().get(1)[0]));
//        Assert.assertEquals("4",(answerService.AllAnswer().get(2)[0]));
//        Assert.assertEquals("2",(answerService.AllAnswer().get(3)[0]));
//        Assert.assertEquals("3",(answerService.AllAnswer().get(4)[0]));
        Assert.assertArrayEquals(res.toArray(),answerService.AllAnswer().toArray());

    }
}
