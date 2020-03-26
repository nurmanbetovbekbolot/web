package com;

import com.entities.Car;
import com.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        int max = 2020;
        int min = 1950;
        String[] brands = {"BMW", "HONDA", "TOYOTA", "MERCEDES", "AUDI", "BENTLEY", "CHEVROLET", "CADILLAC", "LADA", "LEXUS"};
//        for (int i = 0; i < 10; i++) {
//            create(new Car(i+1, brands[i], (int) ((Math.random() * ((max - min) + 1)) + min)));
//        }
        System.out.println( getAll());
        System.out.println(getById(2));

    }
    public static void create(Car c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created");
    }
    public static void delete(Car c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted");
    }
    public static void update(Car c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(c);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }
    public static Car getById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Car car = (Car) session.get(Car.class, id);
        session.close();
        return car;
    }
    public static List<Car> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Car> cars = session.createQuery("FROM Car").list();
        session.close();
        return cars;
    }
}
