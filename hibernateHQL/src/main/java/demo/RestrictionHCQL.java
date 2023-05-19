package demo;

import domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class RestrictionHCQL {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Product.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

//        fetch first 3 record from database table
        Criteria crt1=ses.createCriteria(Product.class);
        crt1.setMaxResults(3);

        List <Product> productList=crt1.list();

        for(Product p:productList)
        {
            System.out.println(p);
        }

        System.out.println("=============================================");

        //exclude first 3 records
        Criteria crt2=ses.createCriteria(Product.class);
        crt2.setFirstResult(3);

        List<Product> list1=crt2.list();
        for (Product p:list1)
        {
            System.out.println(p);
        }

//        Display products name of first 2 products
        Criteria crt3=ses.createCriteria(Product.class);
        crt3.setProjection(Projections.property("productName"));
        crt3.setMaxResults(2);

        List<String> list2=crt3.list();
        for(String name:list2)
        {
            System.out.println(name);
        }

//        Display products having price less than 30000.00;

        Criteria crt4= ses.createCriteria(Product.class);
        crt4.add(Restrictions.lt("productPrice",30000.0));
        List<Product> list3=crt4.list();

        for(Product p:list3)
        {
            System.out.println(p);
        }

//        Display products having price between 1000 and 5000

        Criteria crt5=ses.createCriteria(Product.class);
        crt5.add(Restrictions.between("productPrice",1000.0,5000.0));
        List<Product> list4=crt5.list();

        System.out.println("PRODUCT_ID\tPRODUCT_NAME\tPRODUCT_CATEGORY\tPRODUCT_PRICE");
        System.out.println("-------------------------------------------------------------------");

        for (Product p:list4)
        {
            System.out.println(p);
        }
        System.out.println("======================================================");

        //display product WHOSE names start with L
        Criteria crt6= ses.createCriteria(Product.class);
        crt6.add(Restrictions.like("productName","L%"));
        List <Product> list5=crt6.list();

        System.out.println("PRODUCT_ID\tPRODUCT_NAME\tPRODUCT_CATEGORY\tPRODUCT_PRICE");
        System.out.println("-------------------------------------------------------------------");
        for (Product p:list5)
        {
            System.out.println(p);
        }
        System.out.println("======================================================");

        //display all product from category electronics
        Criteria crt7=ses.createCriteria(Product.class);
        crt7.add(Restrictions.eq("productCategory","ELECTRONICS"));
        List<Product>list6=crt7.list();

        System.out.println("PRODUCT_ID\tPRODUCT_NAME\tPRODUCT_CATEGORY\tPRODUCT_PRICE");
        System.out.println("-------------------------------------------------------------------");


        for (Product p:list6)
        {
            System.out.println(p);
        }

        System.out.println("PRODUCT_ID\tPRODUCT_NAME\tPRODUCT_CATEGORY\tPRODUCT_PRICE");
        System.out.println("-------------------------------------------------------------------");

        Criteria crt8=ses.createCriteria(Product.class);
        crt8.add(Restrictions.eq("productCategory","GADGET"));
        crt8.add(Restrictions.gt("productPrice",30000.0));

        List<Product> list7=crt8.list();
        for (Product p: list7)
        {
            System.out.println(p);
        }

        System.out.println("PRODUCT_ID\tPRODUCT_NAME\tPRODUCT_CATEGORY\tPRODUCT_PRICE");
        System.out.println("-------------------------------------------------------------------");

        Criteria crt9=ses.createCriteria(Product.class);
        crt9.addOrder(Order.asc("productPrice"));

        List<Product> list8=crt9.list();
        for (Product p: list8)
        {
            System.out.println(p);
        }

        System.out.println("PRODUCT_ID\tPRODUCT_NAME\tPRODUCT_CATEGORY\tPRODUCT_PRICE");
        System.out.println("-------------------------------------------------------------------");
        Criteria crt10=ses.createCriteria(Product.class);
        crt10.addOrder(Order.desc("productCategory"));
        List<Product> list9=crt10.list();

        for(Product p:list9)
        {
            System.out.println(p);
        }

    }
}
