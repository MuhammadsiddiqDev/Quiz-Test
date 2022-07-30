package uz.isystem.quiztest;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionMenger {

    public ArrayList<QuestionData> data;
    private int totalQuestion = 0;
    private int currentPosition = 0;
    private int totalTrue;
    private int totalFalse;

    public QuestionMenger() {
    }

    public QuestionMenger(ArrayList<QuestionData> data) {
        this.data = data;
        Collections.shuffle(data);
        totalQuestion = data.size();
    }

    public void setData(ArrayList<QuestionData> data) {
        this.data = data;
        Collections.shuffle(data);
        totalQuestion = data.size();
    }

    private QuestionData getCurrentQuestion() {
        return this.data.get(currentPosition);
    }

    public String getQuestion() {
        return getCurrentQuestion().getQuestion();
    }

    public String getVariantA() {
        return getCurrentQuestion().getAnswerA();
    }

    public String getVariantB() {
        return getCurrentQuestion().getAnswerB();
    }

    public String getVariantC() {
        return getCurrentQuestion().getAnswerC();
    }

    public String getVariantD() {
        return getCurrentQuestion().getAnswerD();
    }

    public boolean checkAnswer(String answer) {

        boolean isTrue = false;
        if (answer.equalsIgnoreCase(getCurrentQuestion().getAnswer())) {
            isTrue = true;
            totalTrue++;
        } else {
            isTrue = false;
            totalFalse++;
        }

        if (hasNextQuestion()) {
            currentPosition++;
        }
        return isTrue;
    }

    public int getTotalTrue() {
        return totalTrue;
    }

    public int getTotalFalse() {
        return totalFalse;
    }

    public boolean isFinish() {
        return currentPosition == totalQuestion;
    }

    public boolean hasNextQuestion() {
        return currentPosition < totalQuestion;
    }

    public int getCurrentLevel() {
        return currentPosition + 1;
    }

    public int getTotal() {
        return data.size();
    }
}
