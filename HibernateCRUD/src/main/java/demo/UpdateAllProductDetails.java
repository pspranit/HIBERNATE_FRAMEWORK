package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateAllProductDetails {
    public static void main(String[] args)
    {

        Configuration cfg;
        Session ses;
        SessionFactory factory;
        Transaction tx;

        //Active hibernate
        cfg=new Configuration();

        //read cfg file
        cfg=cfg.configure();

        //Establish commmunication link
        factory= cfg.buildSessionFactory();

        //start the session
        ses=factory.openSession();

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER PRODUCT ID");
        int id=sc.nextInt();

        System.out.println("WHICH FIELD NEED TO MODIFY");

        System.out.println("1)MODIFY NAME\n2)MODIFY CATEGORY\n3)MODIFY PRICE");

        System.out.println("ENTER CHOICE");
        int choice=sc.nextInt();

        Product p = null;
        if(choice==1) {
            System.out.println("ENTER UPDATED PRODUCT NAME");
            String name=sc.next();
            p=ses.load(Product.class,id);
            p.setProductName(name);

        }
        else if (choice==2) {
            System.out.println("ENTER UPDATED PRODUCT CATEGORY");
            String category=sc.next();
            p=ses.load(Product.class,id);
            p.setProductCategory(category);
        }
        else if (choice==3) {
            System.out.println("ENTER UPDATED PRODUCT PRICE");
            double price=sc.nextDouble();
            p=ses.load(Product.class,id);
            p.setProductPrice(price);
        }
        else {
            System.out.println("INVALID CHOICE");
        }

        tx=ses.beginTransaction();
        ses.update(p);
        tx.commit();

        System.out.println("UPDATED SUCCESS !!");
    }
}
