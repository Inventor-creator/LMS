package LearningManagementSystem.Controller;

import LearningManagementSystem.Component.JwtUtil;
import LearningManagementSystem.Model.Student;
import LearningManagementSystem.Service.StudentService;
import LearningManagementSystem.requestObjects.AllStudentInfo;
import LearningManagementSystem.requestObjects.RequestStudent;
import jakarta.persistence.Column;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(allowCredentials = "true" , origins = "http://localhost:5173")
@RestController
public class UserController {
    @Autowired
    StudentService sService;
    @Autowired
    JwtUtil jwtUtil;

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
    public String makeStudentController(@RequestBody RequestStudent stu , HttpServletRequest request , HttpServletResponse response) throws IOException {
        Optional<Cookie> myCookie = Arrays.stream(request.getCookies())
                .filter(cookie -> "token".equals(cookie.getName()))
                .findFirst();
        if(myCookie.isPresent()) {
            jwtUtil.validateToken(myCookie.get().getValue());
        }
        else{
            response.sendError(403 , "token not valid ");
        }
        return sService.createStudentService(stu);

    }


    @GetMapping("/test")
    public List<AllStudentInfo>  getShit(){

        return sService.getAll();
    }



}



