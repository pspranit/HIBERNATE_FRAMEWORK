package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayCourses4 {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        cfg = cfg.addAnnotatedClass(Course.class);


        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER ID");
        int id= sc.nextInt();

        Student s1=ses.load(Student.class,id);
        List<Course> courseList=s1.getCourseList();
        for (Course c:courseList)
        {
            System.out.println(c.getCourseName());
        }

    }
}
