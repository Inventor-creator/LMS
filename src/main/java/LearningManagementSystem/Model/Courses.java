package LearningManagementSystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Courses")
public class Courses {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="courseId")
    private Integer courseId;

    @Column(name = "courseName")
    private String courseName;

    //foreign key to instructor
    @ManyToOne
    @JoinColumn(name="instructorId" , referencedColumnName = "instructorId")
    private Instructors instructor;

    public Courses(){

    }


    //take an instructor
    public Courses(String courseName ,Instructors instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public Instructors getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructors instructor) {
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
