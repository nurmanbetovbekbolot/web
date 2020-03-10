package com.company;

import java.util.Random;

public class Team implements Runnable{
    Random random = new Random();

    public synchronized int goal() {
        return random.nextInt(15);
    }

    public synchronized int amountOfYellowCards() {
        return random.nextInt(15);
    }

    public synchronized int offside() {
        return random.nextInt(15);
    }


    @Override
    public void run() {
    }
}

