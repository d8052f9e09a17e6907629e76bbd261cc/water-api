package fifokart.response;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class DeleteProductResponse {
    private boolean status = true;
    private String message = "Product deleted successfully";
}
