package fifokart.services.user;


import fifokart.domain.user.User;
import fifokart.domain.user.UserLogin;
import fifokart.exceptions.user.DuplicateRegistration;
import fifokart.response.LoginResponse;
import fifokart.response.RegistrationResponse;

import java.util.List;

public interface UserService {
    List<User> listAll();

//    User listById(Long userId);

    RegistrationResponse addUser(User user) throws DuplicateRegistration;

    LoginResponse login(UserLogin user);

    RegistrationResponse updateUser(User user, Long id) throws DuplicateRegistration;

//    void delete(Long userId);
}
