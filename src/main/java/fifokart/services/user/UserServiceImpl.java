package fifokart.services.user;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import fifokart.domain.user.User;
import fifokart.domain.user.UserLogin;
import fifokart.exceptions.user.DuplicateRegistration;
import fifokart.response.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import fifokart.repositories.UserRepository;
import fifokart.response.LoginResponse;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAll(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public RegistrationResponse addUser(User user) throws DuplicateRegistration {
        if(userRepository.countByPhoneOrEmailId(user.getPhone(), user.getEmailId()) > 0){
            throw new DuplicateRegistration("Phone number already registered");
        }
        User userRes = userRepository.save(user);
        RegistrationResponse res = new RegistrationResponse();
        res.setContext(userRes);
        return res;
    }

    @Override
    public LoginResponse login(UserLogin user){
        User logUser = new User();
        logUser = userRepository.findByPhoneAndPassword(user.getPhone(), user.getPassword());
        LoginResponse loginResponse = new LoginResponse();
        if(logUser == null){
            loginResponse.setStatus(404);
            loginResponse.setMessage("Invalid Credential");
        }else{
            loginResponse.setStatus(200);
            loginResponse.setMessage("Login Successfull");
            loginResponse.setContext(logUser);
        }
        return loginResponse;
    }

    @Override
    public RegistrationResponse updateUser(User user, Long id) throws DuplicateRegistration{
        if(userRepository.countByPhoneOrEmailId(user.getPhone(), user.getEmailId()) > 0){
            throw new DuplicateRegistration("Phone number already registered");
        }
        User getUser = userRepository.findById(id).get();
        getUser.setEmailId(user.getEmailId());
        getUser.setName(user.getName());
        getUser.setPassword(user.getPassword());
        User userRes = userRepository.save(getUser);
        RegistrationResponse res = new RegistrationResponse();
        res.setMessage("User profile updated successfully");
        res.setContext(userRes);
        return res;
    }
}
