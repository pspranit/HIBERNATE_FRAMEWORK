package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UserProductInfo {
    public static void main(String[] args) {


        Configuration cfg;
        Session ses;
        SessionFactory factory;
        Transaction tx;

        //step-1 Activate hibernate framework
        cfg=new Configuration();

        //read the data from cfg file
        cfg=cfg.configure();

        //step-2 Establish communication link
        factory=cfg.buildSessionFactory();

        //step-3 start the session
        ses=factory.openSession();

        //step-4 create object of domain class
        Product p1=new Product();
        Scanner sc=new Scanner(System.in);

        System.out.println("ENTER ID");
        int id=sc.nextInt();

        System.out.println("ENTER PRODUCT NAME");
        String name=sc.next();

        System.out.println("ENTER PRODUCT CATEGORY");
        String category=sc.next();

        System.out.println("ENTER PRODUCT PRICE");
        double price=sc.nextDouble();

        p1.setProductId(id);
        p1.setProductName(name);
        p1.setProductCategory(category);
        p1.setProductPrice(price);

        //step-5 start the transaction
        tx=ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("PRODUCT INSERTED SUCCESSFULLY !!");


    }
}
