package fifokart.services.product;

import fifokart.domain.product.Product;
import fifokart.repositories.ProductRepository;
import fifokart.response.AddProductResponse;
import fifokart.response.DeleteProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public AddProductResponse addProduct(Product product){
        productRepository.save(product);
        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setContext(product);
        return addProductResponse;
    }

    @Override
    public DeleteProductResponse delete(Long productId){
        productRepository.deleteById(productId);
        return new DeleteProductResponse();
    }
}
