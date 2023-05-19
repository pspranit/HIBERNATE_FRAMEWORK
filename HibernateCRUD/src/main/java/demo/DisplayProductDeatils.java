package demo;


import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DisplayProductDeatils {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        //step-1 Activate hibernate framework
        cfg=new Configuration();

        //read the data from cfg file
        cfg=cfg.configure();

        //step-2 Establish communication link
        factory=cfg.buildSessionFactory();

        //step-3 start the session
        ses=factory.openSession();

        //step-4 read the data from table
        Product pd=ses.load(Product.class,3);
        int id=pd.getProductId();
        String name=pd.getProductName();
        String category=pd.getProductCategory();
        double price=pd.getProductPrice();



        System.out.println("ID\t\tNAME\t\tCATEGORY\t\tPRICE");
        System.out.println("=============================================");
        System.out.println(id+"\t\t"+name+"\t\t"+category+"\t\t"+price);
    }
}
