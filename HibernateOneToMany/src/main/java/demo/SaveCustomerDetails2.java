package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveCustomerDetails2 {
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

        Customer c1=ses.load(Customer.class,6);

        //objects of orders
        Orders ord1=new Orders();
        ord1.setOrderNo("ORDER900");

        Orders ord2=new Orders();
        ord2.setOrderNo("ORDER1000");

        c1.addOrders(ord1);
        c1.addOrders(ord2);

        tx= ses.beginTransaction();

        ses.save(ord1);
        ses.save(ord2);

        tx.commit();

        System.out.println("DETAILS INSERTED SUCCESSFULLY !!");
    }
}

