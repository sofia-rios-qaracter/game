package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class WarriorList {
    private HashMap<String, Warrior> warriors;

    public WarriorList() {
        this.warriors = new HashMap<>();
    }

    public boolean addWarrior(Warrior warrior) {
        if (this.warriors.containsKey(warrior.getName()))
            return false;

        this.warriors.put(warrior.getName(), warrior);
        return true;
    }

    public Warrior getWarrior(String name) {
        return this.warriors.get(name);
    }

    public boolean atLeatTwo() {
        return this.warriors.size() >= 2;
    }

    public boolean canStillFigth() {
        return this.warriors.values().stream().filter(warrior -> !warrior.isDead()).count() >= 2;
    }

    public List<Warrior> battleOrder(Rolls r) {
        return this.warriors.entrySet().stream()
                .filter(entry -> !entry.getValue().isDead())
                .peek(entry -> entry.getValue().rolledForSpeed(r))
                .map(Map.Entry::getValue)
                .sorted(Comparator.comparing(warrior -> warrior.getSpeed() + warrior.getRolledSpeed()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list;
                }));
    }

    public List<Warrior> oponents(Warrior warriorHitting) {
        return this.warriors.values().stream()
                .filter(warrior -> !warrior.isDead())
                .filter(warrior -> !warrior.getName().equalsIgnoreCase(warriorHitting.getName()))
                .toList();
    }

    public Warrior winner() {
        return this.warriors.values().stream()
                .filter(warrior -> !warrior.isDead())
                .toList().get(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.warriors.forEach((name, warrior) -> {
            sb.append("-----------\n").append(warrior).append("\n");
        });

        return sb.toString();
    }
}
