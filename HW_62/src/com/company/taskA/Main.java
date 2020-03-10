package com.company.taskA;

public class Main {

    public static void main(String[] args) {
        GenericClass<String, Integer> a = new GenericClass<>("Key", 15);
        GenericClass<Integer, String> b = new GenericClass<>(12, "Value");
        GenericClass<Double,Float> c = new GenericClass<>(12.4,10f);
        a.print();
        b.print();
        c.print();

    }
}
