package fifokart.controllers;

import fifokart.domain.product.Product;
import fifokart.response.AddProductResponse;
import fifokart.response.DeleteProductResponse;
import fifokart.response.FileUploadResponse;
import fifokart.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping(value = "/upload")
    public FileUploadResponse fileUpload(@RequestBody MultipartFile file){
        FileUploadResponse fileUploadResponse = new FileUploadResponse();
        System.out.println("call api");
        if(file.isEmpty()){
            System.out.println("file not found");
            fileUploadResponse.setUploadMessage("File not found");
            return fileUploadResponse;
        }
        try {
            System.out.println("inside try");
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("/Users/mohit.prakash/Java/fifokartimages/" + file.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println("file uploaded");
            fileUploadResponse.setUploadMessage("File uploaded successfully");
            return fileUploadResponse;

        } catch (IOException e) {
            System.out.println("catch");
            fileUploadResponse.setUploadMessage(e.getCause().getMessage());
            return fileUploadResponse;
        }
    }

    @PostMapping("/product")
    public ResponseEntity<AddProductResponse> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<DeleteProductResponse> deleteProduct(@PathVariable("productId") Long productId){
        return new ResponseEntity<>(productService.delete(productId), HttpStatus.OK);
    }
}
