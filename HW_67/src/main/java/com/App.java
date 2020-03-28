package com;

import com.entities.Championship;
import com.entities.Country;
import com.entities.SportType;
import com.entities.Team;
import com.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        Country c1 = new Country("KG");
//        SportType sportType1 = new SportType("Football");
//        Team t1 = new Team("Ak-Shumkar", "Chuy", "ffkr.kg", sportType1);
//        Championship championship1 = new Championship(c1, "KG Champ", sportType1);
//        create(c1);
//        create(sportType1);
//        create(t1);
//        create(championship1);
    }

    public static <T> void create(T e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created");
    }
}
