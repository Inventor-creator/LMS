package LearningManagementSystem.Controller;

import LearningManagementSystem.Model.Courses;
import LearningManagementSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    CourseService cService;

    @PostMapping("/createCourse")
    public String createCourse(@RequestBody Courses course){

        if(cService.createRepo(course)){
            return "Course created successfully";
        }
        return "Course already exists";

    }


}
