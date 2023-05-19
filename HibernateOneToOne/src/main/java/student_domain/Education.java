package student_domain;

import javax.persistence.*;

@Entity
@Table(name = "education_details")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_id")
    private int educationId;
    @Column(name = "10th_per")
    private double percentage10;
    @Column(name = "12th_per")
    private double percentage12;
    @Column(name = "degree_per")
    private double degree;

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public double getPercentage10() {
        return percentage10;
    }

    public void setPercentage10(double percentage10) {
        this.percentage10 = percentage10;
    }

    public double getPercentage12() {
        return percentage12;
    }

    public void setPercentage12(double percentage12) {
        this.percentage12 = percentage12;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }
}
