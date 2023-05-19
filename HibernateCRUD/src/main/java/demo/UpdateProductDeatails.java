package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateProductDeatails {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        //step-1 Activate hibernate framework
        cfg=new Configuration();

        //read the data from cfg file
        cfg=cfg.configure();

        //step-2 Establish communication link
        factory=cfg.buildSessionFactory();

        //step-3 start the session
        ses=factory.openSession();

        Product p=ses.load(Product.class,2);
        p.setProductName("HEADPHONE");
        p.setProductPrice(1500.00);

        //step-5 start the transaction
        tx=ses.beginTransaction();
        ses.update(p);
        tx.commit();
        System.out.println("PRODUCT DETAILS UPDATED");
    }
}
