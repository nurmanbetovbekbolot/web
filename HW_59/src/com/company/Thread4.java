package com.company;

public class Thread4 extends VarThread implements Runnable {

    @Override
    public void run() {
        setVar(var-2);
        System.out.println("Subtracted :"+getVar());

    }
}
