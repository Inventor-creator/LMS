package LearningManagementSystem.Controller;

import LearningManagementSystem.Model.StudentPasses;
import LearningManagementSystem.Service.Auth;
import LearningManagementSystem.Service.StudentService;
import LearningManagementSystem.requestObjects.Access;
import LearningManagementSystem.requestObjects.LoginInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@RestController
@CrossOrigin(allowCredentials = "true" , origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    Auth auth;
    @Autowired
    StudentService sService;
    //post mapping with the body as username and pass

    @PostMapping("/login")
    public Access setCookie(@RequestBody LoginInfo logInfo , HttpServletResponse response   )throws java.io.IOException {

        Optional<StudentPasses> checkStudent = auth.checkStuCredentials(logInfo);


        if(checkStudent.isPresent()){

            Access userDeets = sService.getAccess(logInfo.getEmail());

            response.addCookie(auth.getAuthCookie(userDeets ,logInfo.getEmail() ));

            return userDeets;
        }

        response.sendError(404);
        return new Access();
    }

    @PostMapping("/checkValid")
    public String validate( @RequestBody Access access ,HttpServletRequest request  , HttpServletResponse response) throws java.io.IOException{

        //array of cookies

        Optional<Cookie> myCookie = Arrays.stream(request.getCookies())
                .filter(cookie -> "token".equals(cookie.getName()))
                .findFirst();

//        System.out.println(access);

            if(myCookie.isPresent()){
                if (auth.validateCookie(myCookie.get(), access)) {
                    response.setStatus(200);
                    return "valid";

                }
            }



            response.sendError(403 );
            return "not valid";


    }
}

