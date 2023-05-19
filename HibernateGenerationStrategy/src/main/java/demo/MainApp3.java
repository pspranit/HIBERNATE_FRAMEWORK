package demo;

import domain.BookData3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainApp3 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("ENTER BOOK NAME");
        String name=sc.nextLine();

        System.out.println("ENTER BOOK PRICE");
        double price=sc.nextDouble();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(BookData3.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        BookData3 b1=new BookData3();
        b1.setBookName(name);
        b1.setBookPrice(price);

        tx= ses.beginTransaction();
        ses.save(b1);
        tx.commit();
        System.out.println("BOOK INSERTED SUCCESSFULLY !!");

    }
}
