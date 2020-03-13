package com.company.taskB;

public class Main {

    public static void main(String[] args) {
        Root r = (a, b) -> {
            return getRoot(a, b);
        };
        System.out.println(r.findRoot(3, 8));
        System.out.println(r.findRoot(4, 81));
    }

    public static Integer getRoot(Integer a, Integer b) {
        Integer temp = 1;
        Integer res = 0;
        for (int i = 1; i < b; i++) {
            if (b % i == 0) {
                for (int j = 0; j < a; j++) {
                    temp = temp * i;
                }
                if (temp == b) {
                    res = i;
                    break;
                }
            }
        }
        return res;
    }
}
