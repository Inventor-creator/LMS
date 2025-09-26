package LearningManagementSystem.Controller;


import LearningManagementSystem.Service.EnrollmentsService;
import LearningManagementSystem.requestObjects.EnrollStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

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
            return "userId or courseId dosent exist";
        }

    }

//    @GetMapping("/studentsEnrolled/{courseId}")
//    public String checkEnrolled(@PathVariable Integer courseId){
//
//    }
//
//    @GetMapping("/enrolledCourses/{studentId}")
//    public String enrolledCourses(@RequestParam Integer active ,@PathVariable Integer studentId){
//
//
//
//    }


}
