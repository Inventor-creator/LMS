package LearningManagementSystem.requestObjects;

public class createCourseReq {

    public String courseName;
    public Integer instructorId;

    public createCourseReq(String courseName, Integer instructorId) {
        this.courseName = courseName;
        this.instructorId = instructorId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }
}
