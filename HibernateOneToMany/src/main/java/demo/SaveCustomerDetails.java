package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class SaveCustomerDetails {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER CUSTOMER NAME");
        String name=sc.next();

        System.out.println("ENTER CUSTOMER EMAIL");
        String email= sc.next();

        System.out.println("ENTER FIRST ORDER NUMBER");
        String order1No=sc.next();

        System.out.println("ENTER SECOND ORDER NUMBER");
        String order2No=sc.next();

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

        //object of customer
        Customer c1=new Customer();
        c1.setCustomerName(name);
        c1.setCustomerEmail(email);

        //objects of orders
        Orders ord1=new Orders();
        ord1.setOrderNo(order1No);

        Orders ord2=new Orders();
        ord2.setOrderNo(order2No);

        //add orders to customer
        c1.addOrders(ord1);
        c1.addOrders(ord2);

        tx= ses.beginTransaction();
        ses.save(c1);
        ses.save(ord1);
        ses.save(ord2);
        tx.commit();

        System.out.println("DETAILS INSERTED SUCCESSFULLY !!");
    }
}
