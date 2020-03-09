package com.company;

public class Thread3 extends VarThread {

    @Override
    public void run() {
        setVar(var + 2);
        System.out.println("Added :" + getVar());

    }
}
