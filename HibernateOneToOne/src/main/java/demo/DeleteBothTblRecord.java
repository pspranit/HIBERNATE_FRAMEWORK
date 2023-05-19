package demo;

import domain.Citizen;
import domain.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteBothTblRecord {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER ID");
        int id=sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Passport.class);
        cfg=cfg.addAnnotatedClass(Citizen.class);

        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Citizen c1=ses.load(Citizen.class,id);
        tx= ses.beginTransaction();
        ses.delete(c1);
        tx.commit();
        System.out.println("RECORD DELETED !!");
    }
}
