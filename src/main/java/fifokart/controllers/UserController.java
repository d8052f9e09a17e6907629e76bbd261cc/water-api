package fifokart.controllers;

import fifokart.domain.user.User;
import fifokart.domain.user.UserLogin;
import fifokart.exceptions.user.DuplicateRegistration;
import fifokart.response.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import fifokart.response.LoginResponse;
import fifokart.services.user.UserService;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@Controller
public class UserController extends ResponseEntityExceptionHandler {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = "application/json; charset=UTF-8")
    public List<User> listUsers(){
        return userService.listAll();
    }

//    @PostMapping(value = "/user", produces = "application/json", consumes = "application/json")
//    public User addUser(@RequestBody User user) throws DuplicateRegistration {
//        return userService.addUser(user);
//    }
    @PostMapping(value = "/user", produces = "application/json", consumes = "application/json")
    public ResponseEntity<RegistrationResponse> addUser(@RequestBody User user) throws DuplicateRegistration{
        RegistrationResponse newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
    public LoginResponse login(@RequestBody UserLogin user){
        return userService.login(user);
    }

}
