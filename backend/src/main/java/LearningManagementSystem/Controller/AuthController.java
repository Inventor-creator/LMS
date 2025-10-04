package LearningManagementSystem.Controller;

import LearningManagementSystem.requestObjects.LoginInfo;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true" , origins = "http://localhost:5173")
public class AuthController {

    //post mapping with the body as username and pass

    @PostMapping("/login")
    public String setCookie(@RequestBody LoginInfo logInfo ,HttpServletResponse response  ) {

        //set cookies based on the login details

        Cookie myCookie = new Cookie("myCookieName", "myCookieValue");

        // 2. Set Cookie properties (optional)
        myCookie.setMaxAge(60 * 60 * 24); // 24 hours in seconds
        myCookie.setPath("/"); // Available for all paths
        myCookie.setHttpOnly(true); // Prevents client-side script access


        // 3. Add the cookie to the HttpServletResponse
        response.addCookie(myCookie);



        return "Cookie 'myCookieName' has been set!";
    }

    @PostMapping("/checkValid")
    public String validate(HttpServletResponse response){



        return "";
    }
}

