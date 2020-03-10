package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Team1());
        Thread thread2 = new Thread(new Team2());
        thread.start();
        thread.sleep(1000);
        System.out.println();
        thread2.start();
    }
}
