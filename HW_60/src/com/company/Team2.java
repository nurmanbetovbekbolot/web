package com.company;

import java.awt.*;
import java.util.Random;

public class Team2 extends Team {

    @Override
    public void run() {
        System.out.println("Statistics of Team 2:");
        System.out.println("Goals : " + super.goal());
        System.out.println("Yellow Cards: " + super.amountOfYellowCards());
        System.out.println("Offsides: " + super.offside());

    }


}
