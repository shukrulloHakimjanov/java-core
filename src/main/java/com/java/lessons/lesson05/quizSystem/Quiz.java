package com.java.lessons.lesson05.quizSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Quiz {
    private String title;
    private List<Question> questions = new ArrayList<>();

    public Quiz(String title) {
        this.title = title;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void start(Team team) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("\nStarting quiz: " + title);
        for (Question q : questions) {
            System.out.println("\nQuestion: " + q.getText());

            if (q instanceof MultipleChoiceQuestion) {
                ((MultipleChoiceQuestion) q).showOptions();
            }

            System.out.print("Your answer: ");
            String ans = sc.nextLine();

            if (q.checkAnswer(ans)) {
                System.out.println("Correct!");
                score += q.getPoints();
            } else {
                System.out.println("Wrong!");
            }
        }

        team.addScore(score);
        System.out.println("\n Final score for " + team.getName() + ": " + team.getScore());
    }
}
