package fifokart.services.product;

import fifokart.domain.product.Product;
import fifokart.response.AddProductResponse;
import fifokart.response.DeleteProductResponse;

public interface ProductService {
    AddProductResponse addProduct(Product product);
    DeleteProductResponse delete(Long productId);
}
