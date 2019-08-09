package fifokart.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateRegistration extends Exception {
    public DuplicateRegistration(String msg){
        super(msg);
    }
}
