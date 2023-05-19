package student_domain;

import javax.persistence.*;

@Entity
@Table(name = "student_details")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")

    private int studentId;

    @Column(name = "s_name")
    private String studentName;
    @Column(name = "s_cont")
    private int studentCont;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "e_id")
    private Education educationId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentCont() {
        return studentCont;
    }

    public void setStudentCont(int studentCont) {
        this.studentCont = studentCont;
    }

    public Education getEducationId() {
        return educationId;
    }

    public void setEducationId(Education educationId) {
        this.educationId = educationId;
    }
}
