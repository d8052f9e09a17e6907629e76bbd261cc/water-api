package fifokart.repositories;

import fifokart.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhoneAndPassword(String phone, String password);

    Long countByPhoneOrEmailId(String phone, String emailId);
}
