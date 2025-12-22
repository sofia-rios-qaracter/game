package org.example;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Rolls {
    Random rand;

    public Rolls (Long seed){
        this.rand = new Random();
        rand.setSeed(seed);
    }
    public Rolls(){
        this.rand = new Random(Calendar.getInstance().getTime().getTime());
    }

    private int randomGenerator(int last, int first){
        return (int) (this.rand.nextDouble()*last)+first;
    }

    private int randomGenerator(int last){
        return this.randomGenerator(last, 1);
    }

    public int rollD4(){
        return this.randomGenerator(4);
    }

    public int rollD6(){
        return this.randomGenerator(6);
    }

    public int rollD8(){
        return this.randomGenerator(8);
    }

    public int rollD10(){
        return this.randomGenerator(10);
    }
    public int rollD12(){
        return this.randomGenerator(12);
    }

    public int rollDamage(diceRoll roll){
        int rolled;
        switch (roll){
            case d4 -> rolled = this.rollD4();
            case d6 -> rolled = this.rollD6();
            case d8 -> rolled = this.rollD8();
            case d10 -> rolled = this.rollD10();
            case d12 -> rolled = this.rollD12();
            default -> rolled = 0;
        }

        return rolled;
    }
}
