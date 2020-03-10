package com.company.taskB;

import java.util.Collection;

public class Calc {

    public static Number getSum(Collection<? extends Number> numbers) {
        Double sum = 0.0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static <T extends Number> Number getAverage(T[] arr) {
        Double sum = 0.0;
        Double avg = 0.0;
        for (Number t : arr) {
            sum += t.doubleValue();
        }
        return avg = sum / arr.length;
    }
}
