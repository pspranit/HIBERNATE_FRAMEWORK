package student_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import student_domain.Education;
import student_domain.Student;

import java.util.Scanner;

public class MainApp1 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER STUDENT_NAME");
        String name=sc.next();

        System.out.println("ENTER STUDENT_CONT");
        int cont= sc.nextInt();

        System.out.println("ENTER PERCENTEAGE 10TH");
        double per10=sc.nextDouble();

        System.out.println("ENTER PERCENTEAGE 12TH");
        double per12=sc.nextDouble();

        System.out.println("ENTER PERCENTEAGE DEGREE");
        double degree=sc.nextDouble();

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

        Education e1=new Education();
        e1.setPercentage10(per10);
        e1.setPercentage12(per12);
        e1.setDegree(degree);

        Student s1=new Student();
        s1.setStudentName(name);
        s1.setStudentCont(cont);

        s1.setEducationId(e1);
        tx= ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("RECORD INSERTED !!");






    }
}
