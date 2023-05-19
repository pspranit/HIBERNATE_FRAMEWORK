package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveStudentCourseDetails1 {

    public static void main(String[] args) {


        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        cfg = cfg.addAnnotatedClass(Course.class);


        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        //create object of courses
        Course c1 = new Course();
        c1.setCourseName("WEBTECH");

        Course c2 = new Course();
        c2.setCourseName("SQL");

        //Create object of Student
        Student s1 = new Student();
        s1.setStudentName("AKSHAY");



        //add student to courses
        s1.addCourses(c1);
        s1.addCourses(c2);

        tx = ses.beginTransaction();
        ses.save(s1);
        ses.save(c1);
        ses.save(c2);
        tx.commit();
        System.out.println("RECORD INSERTED");

    }
}
