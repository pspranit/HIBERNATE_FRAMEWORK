package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DisplayCustomerDetails3 {
    public static void main(String[] args) {

        Configuration cfg;
        Session ses;
        SessionFactory factory;


        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Customer.class);
        cfg=cfg.addAnnotatedClass(Orders.class);

        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc=new Scanner(System.in);
        System.out.println("CUSTOMER_ID");
        int id=sc.nextInt();

        Customer c1=ses.load(Customer.class,id);

        String name=c1.getCustomerName();

        List<Orders> data= c1.getOrdersList();

        System.out.println(name);

        for(Orders o:data)
        {
            System.out.println(o.getOrderNo());
        }






    }
}
