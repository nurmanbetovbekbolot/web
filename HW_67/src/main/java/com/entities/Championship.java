package com.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "championship")
public class Championship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;
    @Column(name = "name")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private SportType sportType;

    public Championship() {
    }

    public Championship(Country country, String name, SportType sportType) {
        this.country = country;
        this.name = name;
        this.sportType = sportType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }
}
