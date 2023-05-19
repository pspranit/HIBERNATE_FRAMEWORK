package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveStudentDetails3 {
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

        Student s1 = ses.load(Student.class, 3);

        Course c1 = new Course();
        c1.setCourseName("JDBC");

        Course c2 = new Course();
        c2.setCourseName("HIBERNATE");

        s1.addCourses(c1);
        s1.addCourses(c2);

        tx = ses.beginTransaction();

        ses.save(c1);
        ses.save(c2);
        tx.commit();
        System.out.println("RECORD INSERTED");

    }
}
