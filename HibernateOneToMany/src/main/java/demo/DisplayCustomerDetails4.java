package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import java.util.List;

public class DisplayCustomerDetails4 {
    public static void main(String[] args) {
        Configuration cfg;
        Session ses;
        SessionFactory factory;


        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Customer.class);
        cfg = cfg.addAnnotatedClass(Orders.class);

        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt1 = ses.createCriteria(Customer.class);

        List<Customer> customerList = crt1.list();

        for(Customer c: customerList)
        {
            System.out.println("CUSTOMER_NAME");
            System.out.println("==========================");
            System.out.println(c.getCustomerName());
            List<Orders> ordersList= c.getOrdersList();
            System.out.println("ORDER_NO");

            for(Orders o:ordersList)
            {
                System.out.println(o.getOrderNo());
            }
            System.out.println("=====================");
        }


    }
}
