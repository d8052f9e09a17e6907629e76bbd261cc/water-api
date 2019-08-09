package fifokart.response;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class FileUploadResponse {
    private String uploadMessage;

    public String getUploadMessage() {
        return uploadMessage;
    }

    public void setUploadMessage(String uploadMessage) {
        this.uploadMessage = uploadMessage;
    }
}
