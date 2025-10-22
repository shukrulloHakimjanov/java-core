package com.java.lessons.lesson05.quizSystem;

class TextQuestion extends Question {
    private String correctAnswer;

    public TextQuestion(String text, int points, String correctAnswer) {
        super(text, points);
        this.correctAnswer = correctAnswer.toLowerCase();
    }

    @Override
    public boolean checkAnswer(String answer) {
        return correctAnswer.equals(answer.toLowerCase());
    }
}