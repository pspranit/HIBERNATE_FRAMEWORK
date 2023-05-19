package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveCustomerDetails1 {
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

        //object of customer
        Customer c1=new Customer();
        c1.setCustomerName("PRATIK");
        c1.setCustomerEmail("P@GMAIL.COM");

        Customer c2=new Customer();
        c2.setCustomerName("AKSHAY");
        c2.setCustomerEmail("AK@GMAIL.COM");

        //objects of orders
        Orders ord1=new Orders();
        ord1.setOrderNo("ORDER600");

        Orders ord2=new Orders();
        ord2.setOrderNo("ORDER700");

        Orders ord3=new Orders();
        ord3.setOrderNo("ORDER800");

        //add orders to customer
        c1.addOrders(ord1);
        c1.addOrders(ord2);
        c2.addOrders(ord3);

        tx= ses.beginTransaction();
        ses.save(c1);
        ses.save(c2);
        ses.save(ord1);
        ses.save(ord2);
        ses.save(ord3);
        tx.commit();

        System.out.println("DETAILS INSERTED SUCCESSFULLY !!");
    }
}
