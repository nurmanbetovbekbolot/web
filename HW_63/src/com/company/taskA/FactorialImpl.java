package com.company.taskA;

public class FactorialImpl {
    public static void main(String[] args) {
        Factorial f = (num) -> {
            System.out.println( getFactorial(num));
        };
        f.findFactorial(5);
    }

    public static Integer getFactorial(Integer num) {
        Integer fact = num;
        for (int i = num - 1; i > 1; i--) {
            fact = fact * i;
        }
        return fact;
    }
}
