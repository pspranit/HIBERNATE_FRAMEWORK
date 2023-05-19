package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveCourseStudentDetails {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Course.class);


        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        //create object of courses
        Course c1=new Course();
        c1.setCourseName("JAVA");

        //Create object of Student
        Student s1=new Student();
        s1.setStudentName("PRANIT");

        Student s2=new Student();
        s2.setStudentName("SHUBHAM");

        //add student to courses
        c1.addStudents(s1);
        c1.addStudents(s2);

        tx= ses.beginTransaction();
        ses.save(s1);
        ses.save(s2);
        ses.save(c1);
        tx.commit();
        System.out.println("RECORD INSERTED");

    }
}
