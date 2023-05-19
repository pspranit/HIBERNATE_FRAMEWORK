package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductInfo {
    public static void main(String[] args) {


        //Configuration cfg;
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
        p1.setProductId(3);
        p1.setProductName("LAPTOP");
        p1.setProductCategory("ELECTRONICS");
        p1.setProductPrice(45000.00);

        //step-5 start the transaction
        tx=ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("PRODUCT INSERTED SUCCESSFULLY !!");


    }
}

