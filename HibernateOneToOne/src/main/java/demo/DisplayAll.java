package demo;

import domain.Citizen;
import domain.Passport;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAll {
    public static void main(String[] args) {

        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Passport.class);
        cfg=cfg.addAnnotatedClass(Citizen.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Criteria crt1=ses.createCriteria(Citizen.class);
        List<Citizen> productList =crt1.list();


        for(Citizen p:productList)
        {
            System.out.println(p);
        }

        Criteria crt2=ses.createCriteria(Passport.class);
        List<Passport> productList1 =crt2.list();


        for(Passport p:productList1)
        {
            System.out.println(p);
        }

//        Query q=ses.createQuery("select p from Citizen p");
//        List<Citizen> productList3=q.list();
//
//        System.out.println("ID\t\tNAME\t\tAGE");
//        System.out.println("===========================");
//
//        for(Citizen p:productList3)
//        {
//            System.out.println(p);
//        }
//
//        Query q1=ses.createQuery("select p from Passport p");
//        List<Passport> productList4=q1.list();
//
//        System.out.println("ID\t\tPASS_NO\t\tCOUNTRY");
//        System.out.println("================================");
//
//        for(Passport p:productList4)
//        {
//            System.out.println(p);
//        }


    }
}
