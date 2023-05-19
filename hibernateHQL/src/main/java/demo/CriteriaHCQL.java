package demo;

import domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;


import java.util.Iterator;
import java.util.List;

public class CriteriaHCQL {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Product.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

//        Criteria crt1=ses.createCriteria(Product.class);
//        List<Product> productList =crt1.list();

//        System.out.println("ID\t\tNAME\t\tCATEGORY\t\tPRICE");
//        System.out.println("=============================================");

//        for(Product p:productList)
//        {
//            System.out.println(p);
//        }
//
//        Criteria crt2=ses.createCriteria(Product.class);
//
//        //add requirement details
//        crt2.setProjection(Projections.property("productName"));
//
//        //execute criteria
//        List<String> name=crt2.list();
//
//        System.out.println("PRODUCT_NAME");
//        System.out.println("=============");
//        for (String s:name)
//        {
//            System.out.println(s);
//        }

//        fetch details from name and price column

        Criteria crt3=ses.createCriteria(Product.class);
        //add requirement details
        ProjectionList pList=Projections.projectionList();
        pList.add(Projections.property("productName"));
        pList.add(Projections.property("productPrice"));
        pList.add(Projections.property("productCategory"));

        crt3.setProjection(pList);

        //execute criteria
        List data=crt3.list();

        Iterator itr=data.iterator();
        while(itr.hasNext())
        {
            Object[]arr= (Object[]) itr.next();
            System.out.println(arr[0]+"\t\t"+arr[1]+"\t\t"+arr[2]);
        }

    }

}
