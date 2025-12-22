package org.example;

import java.util.HashMap;

public class WarriorList {
    private HashMap<String, Warrior> warriors;

    public WarriorList(){
        this.warriors = new HashMap<>();
    }

    public boolean addWarrior(Warrior warrior){
        if(this.warriors.containsKey(warrior.getName())) return false;

        this.warriors.put(warrior.getName(), warrior);
        return true;
    }

    public Warrior getWarrior(String name){
        return this.warriors.get(name);
    }

    public boolean canBattle(){
        return this.warriors.size() >= 2;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        this.warriors.forEach((name, warrior) ->{
            sb.append("-----------\n").append(warrior).append("\n");
        });

        return sb.toString();
    }
}
