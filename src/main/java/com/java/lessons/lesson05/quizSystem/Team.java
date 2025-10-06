package com.java.lessons.lesson05.quizSystem;

class Team {
    private String name;
    private int score = 0;

    public Team(String name) {
        this.name = name;
    }

    public void addScore(int points) {
        score += points;
    }

    public String getName() { return name; }
    public int getScore() { return score; }
}