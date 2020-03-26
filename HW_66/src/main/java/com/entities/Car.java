package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "man_year")
    private Integer man_year;

    public Car() {
    }

    public Car(Integer id, String brand, Integer man_year) {
        this.id = id;
        this.brand = brand;
        this.man_year = man_year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getMan_year() {
        return man_year;
    }

    public void setMan_year(Integer man_year) {
        this.man_year = man_year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", man_year=" + man_year +
                '}';
    }
}
