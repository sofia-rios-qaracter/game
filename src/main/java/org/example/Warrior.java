package org.example;

public class Warrior {
    private final String name;
    private int healthPoints;
    private int actualHealthPoints;
    private int defense;
    private int attack;
    private int speed;
    private diceRoll damage;


    public Warrior(String name, int healthPoints, int defense, int attack, int speed, diceRoll damage){
        this.name = name;
        this.healthPoints = healthPoints;
        this.actualHealthPoints = healthPoints;
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

    public int getActualHealthPoints() {
        return actualHealthPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public int gettingHited(int damage){
        this.actualHealthPoints -= damage;
        if(this.actualHealthPoints <= 0){
            this.actualHealthPoints = 0;
        }
        return this.actualHealthPoints;
    }

    public boolean isDead(){
        return this.actualHealthPoints <= 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Name of the warrior: ").append(this.name).append("\n");
        sb.append("Life: ").append(this.actualHealthPoints).append("/").append(this.healthPoints).append("\n");
        sb.append("Attack: ").append(this.attack).append("\n");
        sb.append("Defense: ").append(this.defense).append("\n");
        sb.append("Speed: ").append(this.speed).append("\n");
        sb.append("Dice damage: ").append(this.damage.toString()).append("\n");

        return sb.toString();
    }
}
