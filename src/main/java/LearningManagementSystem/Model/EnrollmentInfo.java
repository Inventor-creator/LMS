package LearningManagementSystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "EnrollmentInfo" , indexes = {
        @Index(name = "year" , columnList = "year")
})
public class EnrollmentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EnrollmentNum")
    private Integer EnrollmentNum;

    @Column(name = "year")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "studentId" , referencedColumnName = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId" , referencedColumnName = "courseId")
    private Courses course;

    @Column(name = "status")
    private boolean status;

    public EnrollmentInfo(){

    }

    public EnrollmentInfo(Integer year, Student student, Courses course, boolean status) {
        this.year = year;
        this.student = student;
        this.course = course;
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }
}



