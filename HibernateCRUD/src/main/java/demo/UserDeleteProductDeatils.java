package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;


public class UserDeleteProductDeatils {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        //Activate hibernate framework
        cfg=new Configuration();

        //read cfg file
        cfg=cfg.configure();

        //Establish communication link
        factory= cfg.buildSessionFactory();

        //session start
        ses=factory.openSession();

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER PRODUCT ID");
        int id=sc.nextInt();

        Product p=ses.load(Product.class,id);

        tx=ses.beginTransaction();
        ses.delete(p);
        tx.commit();

        System.out.println("RECORD DELETED SUCCESSFULLY");
    }
}
