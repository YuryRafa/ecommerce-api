package product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);

    }

    public List<Product> list(){
        return productRepository.findAll();

    }

    public Product findById(String id) {
        UUID uuid = UUID.fromString(id);
        return productRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(String id) {
        Product product = findById(id);
        productRepository.delete(product);

    }

}
