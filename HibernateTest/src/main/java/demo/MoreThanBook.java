package demo;

import domain.Author;
import domain.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MoreThanBook {

    public static void main(String[] args) {
        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Book.class);
        cfg = cfg.addAnnotatedClass(Author.class);

        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt = ses.createCriteria(Author.class);

        List<Author> bookList = crt.list();

        for (Author c : bookList) {
            List<Book> bookList1 = c.getBookList();
            if(bookList1.size()>1)
            {
                System.out.println("BOOK NAME: " + c.getAuthorName());
            }
        }
    }
}
