package LearningManagementSystem.requestObjects;


public class EnrollStudentRequest {


    public Integer studentId;
    public Integer courseId;


    public EnrollStudentRequest(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;


    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


}
