package LearningManagementSystem.Controller;


import LearningManagementSystem.Model.Courses;
import LearningManagementSystem.Model.EnrollmentInfo;
import LearningManagementSystem.Service.EnrollmentsService;
import LearningManagementSystem.requestObjects.EnrollStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(allowCredentials = "true" , origins = "http://localhost:5173")
@RestController
public class Enrollments {

    @Autowired
    EnrollmentsService eService;

    @PostMapping("/enroll")
    public String enrollStudent(@RequestBody EnrollStudentRequest enrollStudentRequest){

        if(eService.enroll(enrollStudentRequest)){
            return "User Enrolled successfully";
        }
        else{
            return "userId or courseId dosent exist or student has already enrolled in the given course";
        }

    }

    //takes courseId, so configure frontend request accordingly,
    //stored in the database with the intention that multiple instructors can teach the same course
    @GetMapping("/studentsEnrolled/{courseId}")
    public List<EnrollmentInfo> checkEnrolled(@PathVariable Integer courseId){

        return eService.getEnrollmentByCourse(courseId);

    }

    @GetMapping("/enrolledCourses/{studentId}")
    public List<Courses> enrolledCourses( @PathVariable Integer studentId, @RequestParam Integer isActive){
        Boolean active = isActive == 1;
        List<Courses> enrolledCourses = new ArrayList<>();
        List<EnrollmentInfo> eInfo =  eService.getEnrollmentOfStudents(studentId , active);
        for(int i = 0 ; i <  eInfo.toArray().length; i++){
            enrolledCourses.add(eInfo.get(i).getCourse());
        }

        return enrolledCourses;

    }

}
