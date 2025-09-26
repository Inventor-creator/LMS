package LearningManagementSystem.requestObjects;


public class EnrollStudentRequest {


    public Integer studentId;
    public Integer courseId;

    public Integer year;

    public EnrollStudentRequest(Integer studentId, Integer courseId, Integer year) {
        this.studentId = studentId;
        this.courseId = courseId;

        this.year = year;

    }

}
