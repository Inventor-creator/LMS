package LearningManagementSystem.Controller;

import LearningManagementSystem.Model.StudentPasses;
import LearningManagementSystem.Service.Auth;
import LearningManagementSystem.requestObjects.Access;
import LearningManagementSystem.requestObjects.LoginInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(allowCredentials = "true" , origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    Auth auth;
    //post mapping with the body as username and pass

    @PostMapping("/login")
    public String setCookie(@RequestBody LoginInfo logInfo , HttpServletResponse response   )throws java.io.IOException {

        Optional<StudentPasses> checkStudent = auth.checkStuCredentials(logInfo);
        //set cookies based on the login details

        if(checkStudent.isPresent()){

            Cookie myCookie = new Cookie("token", "myCookieValue");

            // 2. Set Cookie properties (optional)
            myCookie.setMaxAge(60 * 60 * 24); // 24 hours in seconds
            myCookie.setPath("/"); // Available for all paths
            myCookie.setHttpOnly(true); // Prevents client-side script access


            // 3. Add the cookie to the HttpServletResponse
            response.addCookie(myCookie);
            return "student";
        }

        response.sendError(404);
        return "";
    }

    @PostMapping("/checkValid")
    public String validate(HttpServletRequest request  , Access access , HttpServletResponse response) throws java.io.IOException{

        //array of cookies
        Cookie[] reqCookie = request.getCookies();
        
//        response.sendError(404);

        return "";
    }
}

