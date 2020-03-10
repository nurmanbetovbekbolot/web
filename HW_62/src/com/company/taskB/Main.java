package com.company.taskB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        Double[] arr2 = {2.0, 3.0, 4.0, 5.0, 6.0};
        Float[] arr3 = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        System.out.println("Sum");
        System.out.println( Calc.getSum(Arrays.asList(arr)));
        System.out.println(Calc.getSum(Arrays.asList(arr2)));
        System.out.println(Calc.getSum(Arrays.asList(arr3)));

        System.out.println("Average");
        System.out.println( Calc.getAverage(arr));
        System.out.println(Calc.getAverage(arr2));
        System.out.println(Calc.getAverage(arr3));
    }
}
