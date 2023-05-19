package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteStudentDetails {
    public static void main(String[] args) {


        Configuration cfg;
        Session ses;
        SessionFactory factory;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        cfg = cfg.addAnnotatedClass(Course.class);

        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER ID");
        int id = sc.nextInt();

        Student c1 = ses.load(Student.class, id);
        tx = ses.beginTransaction();
        ses.delete(c1);
        tx.commit();
        System.out.println("RECORD DELETED !!");
    }
}
