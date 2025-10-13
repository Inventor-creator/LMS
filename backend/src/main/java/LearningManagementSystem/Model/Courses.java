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

    @Column(name = "enrollmentYear")
    private Integer enrollmentYear;

    public Courses(){

    }


    public Courses( String courseName, Instructors instructor, Integer enrollmentYear) {

        this.courseName = courseName;
        this.instructor = instructor;
        this.enrollmentYear = enrollmentYear;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Instructors getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructors instructor) {
        this.instructor = instructor;
    }

    public Integer getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(Integer enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }
}
