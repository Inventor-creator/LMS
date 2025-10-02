package LearningManagementSystem.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "Instructors")
public class Instructors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructorId")
    private Integer instructorId;

    @Column(name = "instructorName")
    private String instructorName;

    public Instructors(){
    }

    public Instructors(String instructorName) {
        this.instructorName = instructorName;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}
