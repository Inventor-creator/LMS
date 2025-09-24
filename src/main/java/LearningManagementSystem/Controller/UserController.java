package LearningManagementSystem.Controller;

import LearningManagementSystem.Model.Student;
import LearningManagementSystem.Service.StudentService;
import LearningManagementSystem.requestObjects.RequestStudent;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    StudentService sService;

    @GetMapping("/getUser")
    public String getUserController(@RequestParam Integer studentId){
        Optional<Student> temp = sService.getUserService(studentId);
        if(temp.isEmpty()){
            return "no student found";
        }
        else{
            return sService.getUserService(studentId).get().toString();
        }

    }

    @GetMapping("/getYear/{year}")
    public List<Student> getUserByYear(@PathVariable Integer year){
        return sService.getByYear(year);
    }

    //filter year by
    @PostMapping("/createStudent")
    public String makeStudentController(@RequestBody RequestStudent stu ){

        return sService.createStudentService(stu);

    }

    @GetMapping("/test")
    public List<Student> getShit(){
        return sService.getAll();
    }

}



