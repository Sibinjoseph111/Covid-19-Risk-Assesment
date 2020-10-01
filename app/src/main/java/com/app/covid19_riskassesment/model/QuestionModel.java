package com.app.covid19_riskassesment.model;

public class QuestionModel {
    String question;
    Integer  score;

    public QuestionModel(String question, Integer score) {
        this.question = question;
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}


