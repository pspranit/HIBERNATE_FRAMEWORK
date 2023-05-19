package demo;

import domain.Author;
import domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayBooks {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Author.class);
        cfg=cfg.addAnnotatedClass(Book.class);


        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER BOOK ID");
        int id=sc.nextInt();

        Author a1=ses.load(Author.class,id);
        List<Book> bookList=a1.getBookList();
        for (Book c:bookList)
        {
            System.out.println(c.getBookname());
        }


    }
}
