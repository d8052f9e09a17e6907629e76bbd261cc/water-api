package fifokart.response;

import fifokart.domain.user.User;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ResponseBody
public class RegistrationResponse {
    private boolean status = true;
    private String message = "Registration Successfull";
    private User context;

    public User getContext() {
        return context;
    }

    public void setContext(User context) {
        this.context = context;
    }

    public boolean getStatus(){
        return status;
    }

    public String getMessage() {
        return message;
    }

}
