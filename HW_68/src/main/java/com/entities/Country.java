package com.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany
    private List<Championship> championshipList;

    public Country() {
    }

    public Country( String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Championship> getChampionshipList() {
        return championshipList;
    }

    public void setChampionshipList(List<Championship> championshipList) {
        this.championshipList = championshipList;
    }

    @Override
    public String toString() {
        return name;
    }
}
