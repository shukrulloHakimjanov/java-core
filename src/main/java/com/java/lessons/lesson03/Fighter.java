package com.java.lessons.lesson03;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Fighter {
    int code;
    String name;
    int health;
    int attack;

    static List<Fighter> fighters = new ArrayList<>();

    public void fight(Fighter opponent) {
        Random r = new Random();
        boolean firstStrike = r.nextBoolean();

        System.out.println("\n Бой: " + name + " vs " + opponent.name);

        while (this.health > 0 && opponent.health > 0) {
            if (firstStrike) {
                opponent.health -= this.attack;
                System.out.println(name + " атакует " + opponent.name + " (-" + attack + " HP). " + opponent.name + " HP = " + opponent.health);
                firstStrike = false;
            } else {
                this.health -= opponent.attack;
                System.out.println(opponent.name + " атакует " + name + " (-" + opponent.attack + " HP). " + name + " HP = " + this.health);
                firstStrike = true;
            }
        }

        if (this.health <= 0) {
            System.out.println(" Победитель: " + opponent.name);
        } else {
            System.out.println(" Победитель: " + name);
        }
    }

    public void getFighterInfo() {
        System.out.println("[" + code + "] " + name + " | HP: " + health + " | ATK: " + attack);
    }

    public static List<Fighter> getFighters() {
        return fighters;
    }
}
