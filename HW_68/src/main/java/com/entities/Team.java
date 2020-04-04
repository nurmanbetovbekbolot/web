package com.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "logo_address")
    private String logo_address;

    @Column(name = "website")
    private String website;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sport_type", referencedColumnName = "id")
    private SportType sportType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_championship",referencedColumnName = "id")
    private List<Championship> championships;


    public Team() {
    }

    public Team(String name, String logo_address, String website, SportType sportType) {

        this.name = name;
        this.logo_address = logo_address;
        this.website = website;
        this.sportType = sportType;
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

    public String getLogo_address() {
        return logo_address;
    }

    public void setLogo_address(String logo_address) {
        this.logo_address = logo_address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public List<Championship> getChampionships() {
        return championships;
    }

    public void setChampionships(List<Championship> championships) {
        this.championships = championships;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +

                ", sportType=" + sportType +
                ", championships=" + championships +
                '}';
    }
}
