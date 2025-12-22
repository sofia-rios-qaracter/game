package org.example;

public class Warrior {
    private String name;
    private int healthPoints;
    private int defense;
    private int attack;
    private int speed;
    private diceRoll damage;


    public Warrior(String name, int healthPoints, int defense, int attack, int speed, diceRoll damage){
        this.name = name;
        this.healthPoints = healthPoints;
        this.defense = defense;
        this.attack = attack;
        this.speed = speed;
        this.damage = damage;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public int gettingHited(int damage){
        this.healthPoints -= damage;
        if(this.healthPoints <= 0){
            this.healthPoints = 0;
        }
        return this.healthPoints;
    }

    public boolean isDead(){
        return this.healthPoints <= 0;
    }
}
