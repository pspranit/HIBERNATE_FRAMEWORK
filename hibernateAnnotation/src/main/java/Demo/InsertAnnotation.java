package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertAnnotation {

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

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER PRODUCT ID");
        int id=sc.nextInt();

        System.out.println("ENTER PRODUCT NAME");
        String name=sc.next();

        System.out.println("ENTER PRODUCT CATEGORY");
        String category=sc.next();

        System.out.println("ENTER PRODUCT PRICE");
        double price=sc.nextDouble();
        Product p1 = new Product(id, name, category, price);
        tx = ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("RECORD INSERTED !!");


    }

}
