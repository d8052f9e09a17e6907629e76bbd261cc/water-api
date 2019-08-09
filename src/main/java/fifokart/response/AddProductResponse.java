package fifokart.response;

import fifokart.domain.product.Product;
import fifokart.domain.user.User;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class AddProductResponse {
    private boolean status = true;
    private String message = "Product added successfully";
    private Product context;

    public Product getContext() {
        return context;
    }

    public void setContext(Product context) {
        this.context = context;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
