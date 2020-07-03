package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class AnswerOnTask {
    private List<String[]> Answer;

    public AnswerOnTask() {
        this.Answer = new ArrayList<>();
    }

    public List<String[]> getAnswer() {
        return Answer;
    }

    public void setAnswer(List<String[]> answer) {
        Answer = answer;
    }
}
