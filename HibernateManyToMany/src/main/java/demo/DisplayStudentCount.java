package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayStudentCount {
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

        Criteria crt= ses.createCriteria(Course.class);

        List <Course> courseList=crt.list();
        for(Course c:courseList)
        {
            System.out.println("COURSE NAME: "+c.getCourseName());
            List <Student>studentList=c.getStudentList();
            System.out.println("TOTAL NO OF STUDENTS ARE :"+studentList.size());
            System.out.println("=============================");
        }
    }
}
