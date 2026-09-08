package com.example.ecommerce.product;

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

    public List<Product> findAll(){
        return productRepository.findAll();

    }

    public Product findById(String id) {
        UUID uuid = UUID.fromString(id);
        return productRepository.findById(uuid)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void delete(String id) {
        Product product = findById(id);
        productRepository.delete(product);

    }

}
