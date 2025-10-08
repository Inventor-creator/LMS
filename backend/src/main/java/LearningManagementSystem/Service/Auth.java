package LearningManagementSystem.Service;

import LearningManagementSystem.Component.JwtUtil;
import LearningManagementSystem.Model.StudentPasses;
import LearningManagementSystem.Repositories.StudentPassRepo;
import LearningManagementSystem.requestObjects.Access;
import LearningManagementSystem.requestObjects.LoginInfo;

import jakarta.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Auth {
    @Autowired
    StudentPassRepo passRepo;

    //create another method for checking instructor credentials
    public Optional<StudentPasses> checkStuCredentials(LoginInfo loginInfo){

        String mail = loginInfo.getEmail();
        String password = loginInfo.getPassword();


        return passRepo.lookForPass(mail , password);
    }

    @Autowired
    JwtUtil jwtUtil;
    public Cookie getAuthCookie(Access userDeets , String mail){

        Cookie myCookie = new Cookie("token", jwtUtil.generateToken(userDeets , mail));

        myCookie.setMaxAge(60000); // 24 hours in seconds
        myCookie.setPath("/"); // Available for all paths
        myCookie.setHttpOnly(true); // Prevents client-side script access

        return myCookie;
    }

    public Boolean validateCookie(Cookie cookie , Access access){


        return jwtUtil.validateToken(cookie.getValue() , access.getName() , access.getId() );

    }

}
