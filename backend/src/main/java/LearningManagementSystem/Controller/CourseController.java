package LearningManagementSystem.Controller;

import LearningManagementSystem.Model.Courses;
import LearningManagementSystem.Repositories.FlagsRepo;
import LearningManagementSystem.requestObjects.createCourseReq;
import LearningManagementSystem.Service.CourseService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true" , origins = "http://localhost:5173")
public class CourseController {
    @Autowired
    CourseService cService;
    @Autowired
    FlagsRepo fRepo;

    @GetMapping("/getCourses")
    public List<Courses> getAllCourses(){
        return cService.getAll();
    }

    //only accessible through adminAccess dashboard prolly ( for now only through postman )
    @PostMapping("/createCourse")
    public String createCourse(@RequestBody createCourseReq course){
        if(fRepo.isEditing().isPresent()) {

            if (cService.createRepo(course)) {
                return "Course created successfully";
            }
            return "Course already exists";
        }
        return "System not editable";
    }

    @GetMapping("/getCoursesByYear/{studentId}")
    public List<Courses> getCourses(@PathVariable Integer studentId , HttpServletResponse response) throws IOException {

        if(fRepo.isEnrolling().isPresent()){
            return cService.getByYear(studentId);
        }

        response.sendError(403 , "Enrollment isnt going on rn");
        return null;

    }

}
