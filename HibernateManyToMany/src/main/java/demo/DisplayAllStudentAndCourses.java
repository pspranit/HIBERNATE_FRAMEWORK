package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllStudentAndCourses {
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

        Criteria crt1=ses.createCriteria(Student.class);
        List<Student> studentList=crt1.list();

        for(Student s1: studentList)
        {
            System.out.println("STUDENT_NAME");
            System.out.println("=================");
            System.out.println(s1.getStudentName());
            List<Course> courseList= s1.getCourseList();
            System.out.println("COURSE_NAME");

            for(Course c1:courseList)
            {
                System.out.println(c1.getCourseName());
            }
            System.out.println("*******************");
        }

    }
}
