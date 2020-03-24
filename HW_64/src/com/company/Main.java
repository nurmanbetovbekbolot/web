package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Askhat");
        hashMap.put(2, "Bakulya");
        hashMap.put(3, "Cuba");
        hashMap.put(4, "Daniyar");
        hashMap.put(5, "Elmira");
        hashMap.put(6, "Fatih");
        hashMap.put(7, "Garga");
        hashMap.put(8, "Ha4i");
        hashMap.put(9, "Isa");
        hashMap.keySet().stream().filter(x -> x > 5).forEach(x-> System.out.println("Ключ: "+x+" Значение: "+hashMap.get(x)));
        hashMap.keySet().stream().filter(x-> x%3==0).forEach(x -> System.out.print(hashMap.get(x)+","));
        System.out.println();
        Optional<Integer> optional = hashMap.entrySet().stream().filter(x-> x.getValue().length()>5).map(x->x.getKey()).reduce((value,combined)->{
                   return combined*value;
                    });
        System.out.println(optional.get());


    }
}
