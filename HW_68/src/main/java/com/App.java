package com;

import com.entities.Championship;
import com.entities.Country;
import com.entities.SportType;
import com.entities.Team;
import com.models.ChampionshipTeam;
import com.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
        Country c1 = new Country("KG");
        Country c2 = new Country("England");
        Country c3 = new Country("Spain");
        Country c4 = new Country("Germany");
        Country c5 = new Country("Italy");
        SportType sportType1 = new SportType("Football");
        SportType sportType2 = new SportType("Basketball");
        Team t1 = new Team("Ak-Shumkar", "Chuy", "ffkr.kg", sportType1);
        Team t2 = new Team("Milan", "add", "milan.com", sportType1);
        Team t3 = new Team("Napoli", "add2", "napoli.com", sportType1);
        Team t4 = new Team("Barcelona", "add3", "barca.com", sportType1);
        Team t5 = new Team("Real", "add4", "real.com", sportType1);
        Team t6 = new Team("Liverpool", "add5", "live.com", sportType1);
        Team t7 = new Team("Bayern Munchen", "add6", "bm.com", sportType1);
        create(sportType1);
        create(sportType2);
        create(c1);
        create(c2);
        create(c3);
        create(c4);
        create(c5);
        List<Team> teamList = Arrays.asList(t1, t2, t3, t4, t5, t6, t7);
        List<Championship> champItaly = new ArrayList<>();
        List<Championship> champSpain = new ArrayList<>();
        List<Championship> champEngland = new ArrayList<>();
        List<Championship> champGermany = new ArrayList<>();
        List<Championship> champKG = new ArrayList<>();
        Championship championship1 = new Championship(c1, "KG Champ", sportType1);
        Championship championship2 = new Championship(c2, "England Champ", sportType1);
        Championship championship3 = new Championship(c3, "Spain Champ", sportType1);
        Championship championship4 = new Championship(c4, "Germany Champ", sportType1);
        Championship championship5 = new Championship(c5, "Italy Champ", sportType1);
        champKG.add(championship1);
        champEngland.add(championship2);
        champSpain.add(championship3);
        champGermany.add(championship4);
        champItaly.add(championship5);
        t1.setChampionships(champKG);
        t2.setChampionships(champItaly);
        t3.setChampionships(champItaly);
        t4.setChampionships(champSpain);
        t5.setChampionships(champSpain);
        t6.setChampionships(champEngland);
        t7.setChampionships(champGermany);
        create(championship1);
        create(championship2);
        create(championship3);
        create(championship4);
        create(championship5);
        create(t1);
        create(t2);
        create(t3);
        create(t4);
        create(t5);
        create(t6);
        create(t7);
        System.out.println(getAllTeamsByChampionship("Italy"));
    }

    public static List<ChampionshipTeam> getAllTeamsByChampionship(String championship) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> result = session.createQuery("select t.name, c.country.name,t.sportType FROM Team t join  t.championships c where c.country.name = :p_country_name order by t.sportType.name desc ")
                .setParameter("p_country_name", championship)
                .list();
        session.close();
        List<ChampionshipTeam> championshipTeams = result.stream()
                .map(x -> ChampionshipTeam.builder().name(x[0].toString()).country(x[1].toString()).sportType(x[2].toString()).build()).limit(10)
                .collect(Collectors.toList());

        return championshipTeams;
    }

    public static <T> void create(T e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created");
    }

    public static List<Team> getAllTeams() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Team> teams = session.createQuery("FROM Team ").list();
        session.close();
        return teams;
    }
}
