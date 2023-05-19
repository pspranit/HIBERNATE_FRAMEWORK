package Demo;
import Domain.ProductDisplay;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DisplayAnnotation{
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(ProductDisplay.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        ProductDisplay pd=ses.load(ProductDisplay.class,2);
        int id=pd.getProductId();
        String name=pd.getProductName();
        String category=pd.getProductCategory();
        double price=pd.getProductPrice();



        System.out.println("ID\t\tNAME\t\tCATEGORY\t\tPRICE");
        System.out.println("=============================================");
        System.out.println(id+"\t\t"+name+"\t\t"+category+"\t\t"+price);

    }
}

