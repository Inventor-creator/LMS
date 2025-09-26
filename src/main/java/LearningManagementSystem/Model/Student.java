package LearningManagementSystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Student" , indexes={
    @Index(name="year" , columnList="year")
})
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="studentId")
    private Integer studentId;

    @Column(name="year")
    private Integer year;

    //branch table column here
    @ManyToOne
    @JoinColumn(name = "branchId" , referencedColumnName = "branchId")
    private Branches branch;

    public Student(){

    }

    public Student(Integer studentId, Integer year, Branches branch) {
        this.studentId = studentId;
        this.year = year;
        this.branch = branch;
    }

    public Student(Integer year, Branches branch) {
        this.year = year;
        this.branch = branch;
    }

    public Integer getStudentId() {
        return this.studentId;
    }
    public Integer getYear(){
        return this.year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", year=" + year +
                '}';
    }

}

