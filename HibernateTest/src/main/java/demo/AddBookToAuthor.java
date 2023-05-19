package demo;

import domain.Author;
import domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AddBookToAuthor {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Author.class);
        cfg=cfg.addAnnotatedClass(Book.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER BOOK ID");
        int id=sc.nextInt();

        System.out.println("ENTER AUTHOR NAME");
        String name=sc.next();

        Author a1=ses.load(Author.class,id);

        Book b1=new Book();
        b1.setBookname(name);

        b1.addAuthors(a1);
        tx = ses.beginTransaction();
        ses.save(b1);
        ses.save(a1);
        tx.commit();
        System.out.println("RECORD INSERTED SUCCESS !!");
    }
}
