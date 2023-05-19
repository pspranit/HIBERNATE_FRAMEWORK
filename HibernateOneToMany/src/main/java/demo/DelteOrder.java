package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DelteOrder {
    public static void main(String[] args) {


        Configuration cfg;
        Session ses;
        SessionFactory factory;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Customer.class);
        cfg=cfg.addAnnotatedClass(Orders.class);

        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER ID");
        int id= sc.nextInt();

        Orders c1=ses.load(Orders.class,id);
        tx= ses.beginTransaction();
        ses.delete(c1);
        tx.commit();
        System.out.println("RECORD DELETED !!");

    }
}
