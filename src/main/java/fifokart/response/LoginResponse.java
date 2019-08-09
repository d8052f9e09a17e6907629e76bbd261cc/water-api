package fifokart.response;

import fifokart.domain.user.User;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class LoginResponse {
    private Integer status;
    private String message;
    private User context;

    public User getContext() {
        return context;
    }

    public void setContext(User context) {
        this.context = context;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
