package com.company;

public class Thread2 extends VarThread implements Runnable {

    @Override
    public void run() {
        setVar(var/2);
        System.out.println("Divided:"+getVar());

    }
}
