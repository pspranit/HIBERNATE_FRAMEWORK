package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayStudents5 {
    public static void main(String[] args) {

        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Course.class);

        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER ID");
        int id= sc.nextInt();

        Course c1=ses.load(Course.class,id);
        List<Student> courseList=c1.getStudentList();

        for (Student c:courseList)
        {
            System.out.println(c.getStudentName());
        }

    }
}
