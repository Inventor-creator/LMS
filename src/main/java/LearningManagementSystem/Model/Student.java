package LearningManagementSystem.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

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

    public Student(){

    }
    public Student(int year) {
        this.year = year;
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

