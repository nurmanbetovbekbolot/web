package com.company;

public class Team1 extends Team {
    @Override
    public synchronized void run() {
        System.out.println("Statistics of Team 1:");
        System.out.println("Goals : " + super.goal());
        System.out.println("Yellow Cards: " + super.amountOfYellowCards());
        System.out.println("Offsides: " + super.offside());

    }


}
