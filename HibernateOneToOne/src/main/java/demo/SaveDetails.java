package demo;

import domain.Citizen;
import domain.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class SaveDetails {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER CITIZEN_NAME");
        String name=sc.next();

        System.out.println("ENTER CITIZEN_AGE");
        int age= sc.nextInt();

        System.out.println("ENTER PASSPORT_NO");
        String passNo=sc.next();

        System.out.println("ENTER COUNTRY");
        String country=sc.next();

        Configuration cfg;
        Session ses;
        SessionFactory factory;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Passport.class);
        cfg=cfg.addAnnotatedClass(Citizen.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        //CREATE OBJECT OF PASSWORD
        Passport p1=new Passport();
        p1.setPassportNo(passNo);
        p1.setCountry(country);

        //CREATE OBJECT OF CITIZEN
        Citizen c1=new Citizen();
        c1.setCitizenName(name);
        c1.setCitizenAge(age);

        //ASSIGN PASSPORT DETAILS TO CITIZEN OBJECT
        c1.setPassportRef(p1);
        tx= ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        System.out.println("RECORD INSERTED !!");
    }
}

