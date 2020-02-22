package com.company;

import java.text.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws ParseException {
        LinkedHashMap<DayOfWeek, Integer> dayOfWeeks = new LinkedHashMap();
        ArrayList<DayOfWeek> arrayList = new ArrayList<>();
        arrayList.add(new DayOfWeek("Mon"));
        arrayList.add(new DayOfWeek("Tu"));
        arrayList.add(new DayOfWeek("Wed"));
        arrayList.add(new DayOfWeek("Thur"));
        arrayList.add(new DayOfWeek("Fri"));
        arrayList.add(new DayOfWeek("Sat"));
        arrayList.add(new DayOfWeek("Sun"));

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date d1 = simpleDateFormat.parse("2020-01-01");
        Date d2 = simpleDateFormat.parse("2020-12-31");

        for (int i = 0; i < 100; i++) {
            Date randomDate = new Date(ThreadLocalRandom.current().nextLong(d1.getTime(), d2.getTime()));
            Calendar c = Calendar.getInstance();
            c.setTime(randomDate);
            int randomDay = c.get(Calendar.DAY_OF_WEEK) - 1;
            int value = dayOfWeeks.getOrDefault(arrayList.get(randomDay), 0);
            dayOfWeeks.put(arrayList.get(randomDay), ++value);
        }
        System.out.println(dayOfWeeks);
    }
}


