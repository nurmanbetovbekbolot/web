package com.company;

public class Thread1 extends VarThread implements Runnable {

    @Override
    public void run() {
        setVar(var*2);
        System.out.println("Multiplied:"+getVar());
    }
}
