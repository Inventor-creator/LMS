package LearningManagementSystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "studentPass")
public class StudentPasses {

    //add bcrypt on top later
    @Id
    private Integer studentId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "studentId" , referencedColumnName = "studentId")
    private Student student;

    @OneToOne
    @JoinColumn(name="email" , referencedColumnName = "email")
    private StudentInfo studentInfo;


    @Column(name = "password")
    private String password;

    public StudentPasses(Student student, StudentInfo studentInfo, String password) {
        this.student = student;
        this.studentInfo = studentInfo;
        this.password = password;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StudentPasses(){

    }

    public StudentPasses(Integer studentId, Student student, StudentInfo studentInfo, String password) {
        this.studentId = studentId;
        this.student = student;
        this.studentInfo = studentInfo;
        this.password = password;
    }
}
