package LearningManagementSystem.Model;
import jakarta.persistence.*;
import LearningManagementSystem.Model.Student;


@Entity
@Table(name = "StudentInfo")
public class StudentInfo {

    @Id
    private Integer studentId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "studentId" , referencedColumnName = "studentId")
    private Student student;


    @Column(name="address")
    private String address;
    @Column(name="phoneNumber")
    private String number;
    @Column(name="email")
    private String email;
    @Column(name="studentName")
    private String studentName;

    public StudentInfo(){

    }

    public StudentInfo(Student student, String address, String number, String email, String studentName) {
        this.student = student;
        this.address = address;
        this.number = number;
        this.email = email;
        this.studentName = studentName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
