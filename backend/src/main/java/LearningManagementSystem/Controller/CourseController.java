package LearningManagementSystem.Controller;

import LearningManagementSystem.requestObjects.createCourseReq;
import LearningManagementSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true" , origins = "http://localhost:5173")
public class CourseController {
    @Autowired
    CourseService cService;

    @PostMapping("/createCourse")
    public String createCourse(@RequestBody createCourseReq course){

        if(cService.createRepo(course)){
            return "Course created successfully";
        }
        return "Course already exists";

    }


}
