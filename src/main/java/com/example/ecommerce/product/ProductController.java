package com.example.ecommerce.product;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;

    }

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return this.productService.create(product);

    }

    @GetMapping
    public List<Product> findAll(){
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable String id){
        return this.productService.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        this.productService.delete(id);

    }



}

