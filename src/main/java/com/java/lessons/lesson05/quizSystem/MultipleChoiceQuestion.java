package com.java.lessons.lesson05.quizSystem;

import java.util.List;

class MultipleChoiceQuestion extends Question {
    private List<String> options;
    private int correctIndex;

    public MultipleChoiceQuestion(String text, int points, List<String> options, int correctIndex) {
        super(text, points);
        this.options = options;
        this.correctIndex = correctIndex;
    }

    @Override
    public boolean checkAnswer(String answer) {
        try {
            int ans = Integer.parseInt(answer);
            return ans == correctIndex;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void showOptions() {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
    }
}
