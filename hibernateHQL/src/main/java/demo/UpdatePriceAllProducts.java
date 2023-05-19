package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;


public class UpdatePriceAllProducts {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Product.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();
        tx=ses.beginTransaction();

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER PRICE");
        double price=sc.nextDouble();

        //HQL----> to display all the objects of product class
        Query q = ses.createQuery("update Product p set p.productPrice='"+price+"'");
        int count=q.executeUpdate();

        tx.commit();
        System.out.println(count+": PRODUCT UPDATED !!");


    }
}
