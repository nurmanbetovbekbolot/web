package com.company;

public class VarThread extends Thread {
    public static int var = 2;

    public static int getVar() {
        return var;
    }

    public static void setVar(int var) {
        VarThread.var = var;
    }
}
