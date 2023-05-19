package student_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import student_domain.Education;
import student_domain.Student;

import java.util.Scanner;

public class MainApp3 {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER STUDENT ID");
        int id=sc.nextInt();

        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Education.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Student s1=ses.load(Student.class,id);
        String name=s1.getStudentName();

        Education e1=s1.getEducationId();
        double prce10=e1.getPercentage10();
        double prce12=e1.getPercentage12();
        double degree=e1.getDegree();

        System.out.println("NAME\t\t10th_PER\t\t12TH_PREC\t\tDEGREE");
        System.out.println("===================================================");
        System.out.println(name+"\t\t"+prce10+"\t\t"+prce12+"\t\t"+degree);
    }
}
