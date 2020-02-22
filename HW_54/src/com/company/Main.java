package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashSet<Cities> citiesHashSet = new HashSet<>();
        TreeSet<Cities> citiesTreeSet = new TreeSet<>();
        Cities[] cities = new Cities[20];
        for (int i = 0; i < 20; i++) {
            cities[i] = new Cities();
            cities[i].setCode(i);
            cities[i].setTitle(generateCities(i + 1));
        }
        for (Cities city : cities) {
            if (city.getCode() % 2 == 0) {
                citiesHashSet.add(city);
            } else
                citiesTreeSet.add(city);
        }
        System.out.println("Before");
        System.out.println(citiesHashSet);
        System.out.println(citiesTreeSet);
        Iterator it = citiesHashSet.iterator();
//        while (it.hasNext()) {
//            Cities next = (Cities) it.next();
//
//                if (next.getTitle().length() > 5)
//                    it.remove();
//            }
        citiesHashSet.removeIf(c -> c.getTitle().length() > 5);
        citiesTreeSet.removeIf(c -> c.getTitle().length() > 5);
        System.out.println("After");
        TreeSet<Cities> convertedHashSet = new TreeSet<Cities>(citiesHashSet);
        System.out.println(convertedHashSet);
        System.out.println(citiesTreeSet);
    }

    private static String generateCities(int n) {
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (string.length() * Math.random());
            sb.append(string.charAt(index));
        }
        return sb.toString();
    }

}


