package LearningManagementSystem.Controller;

import LearningManagementSystem.Model.Instructors;
import LearningManagementSystem.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true" , origins = "http://localhost:5173")
public class InstructorController {
    @Autowired
    InstructorService iService;


    //will have to change at some point with posting another object
    //will have to take more info of prof
    @PostMapping("/createProf")
    public String createProf(@RequestBody Instructors instructor){
        if(iService.createInstructor(instructor)){
            return  "Instructor created successfully";
        }else{
            return "something went wrong";
        }

    }

    @GetMapping("/searchInstructors/{instructorName}")
    public List<Instructors> getSimilarNameInstructors(@PathVariable("instructorName") String instructorName){

        return iService.searchInstructor(instructorName);
    }

}
