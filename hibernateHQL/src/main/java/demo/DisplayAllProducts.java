package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllProducts {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        //HQL
        Query q=ses.createQuery("select p from Product p");
        List<Product> productList=q.list();

        System.out.println("ID\t\tNAME\t\tCATEGORY\t\tPRICE");
        System.out.println("=============================================");

        for(Product p:productList)
        {
            System.out.println(p);
        }
    }
}
