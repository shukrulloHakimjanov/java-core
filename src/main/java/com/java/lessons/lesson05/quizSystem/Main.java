package com.java.lessons.lesson05.quizSystem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("Java Basics");

        quiz.addQuestion(new TextQuestion("What is JVM?", 10, "Java Virtual Machine"));
        quiz.addQuestion(new MultipleChoiceQuestion(
                "Which keyword is used for inheritance?",
                5,
                Arrays.asList("implement", "extend", "extends", "derive"),
                3
        ));

        Team team = new Team("CodeMasters");
        quiz.start(team);
    }
}
