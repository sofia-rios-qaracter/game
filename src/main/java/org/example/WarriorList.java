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
}
