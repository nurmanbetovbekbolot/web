package com.company;

public class DayOfWeek {
    private int id;
    private String day;

    public DayOfWeek(int id, String day) {
        this.id = id;
        this.day = day;
    }

    public DayOfWeek( String day) {
        this.day = day;
    }

    public DayOfWeek() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

//
//    @Override
//    public int compareTo(Object o) {
//        if (!(o instanceof DayOfWeek))
//            return 0;
//        DayOfWeek temp = (DayOfWeek) o;
//        if (this.id > temp.id) return 1;
//        else if (this.id < temp.id) return -1;
//        return 0;
//    }


    @Override
    public String toString() {
        return "DayOfWeek{" +
                "day='" + day + '\'' +
                '}';
    }


}
