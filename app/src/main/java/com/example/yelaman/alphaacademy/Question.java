package com.example.yelaman.alphaacademy;

public class Question {
    public int textResId;
    public int answerId;

    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public Question(int textResId, int answerId) {
        this.textResId = textResId;
        this.answerId = answerId;


    }
}
