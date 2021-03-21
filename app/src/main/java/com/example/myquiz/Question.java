package com.example.myquiz;

import java.util.ArrayList;

public class Question {

    private int level;
    private ArrayList<Integer> img;
    private String answer;

    public Question(int level, ArrayList<Integer> img, String answer) {
        this.level = level;
        this.img = img;
        this.answer = answer;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Integer> getImg() {
        return img;
    }

    public void setImg(ArrayList<Integer> img) {
        this.img = img;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
