package student_demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import student_domain.Education;
import student_domain.Student;

import java.util.List;
import java.util.Scanner;

public class MainApp2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER STUDENT ID");
        int id=sc.nextInt();

        Configuration cfg;
        Session ses;
        SessionFactory factory;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Education.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Student s1=ses.load(Student.class,id);
        String name=s1.getStudentName();

        Education ed=s1.getEducationId();
        double degree=ed.getDegree();

        System.out.println("NAME\t\tDEGREE");
        System.out.println("========================");
        System.out.println(name+"\t\t"+degree);




    }
}
