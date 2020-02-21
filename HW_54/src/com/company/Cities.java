package com.company;

public class Cities implements Comparable {
    private Integer code;
    private String title;

    public Cities(Integer code, String title) {
        this.code = code;
        this.title = title;
    }

    public Cities() {

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "code=" + code +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
