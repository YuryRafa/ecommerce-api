package com.example.ecommerce.product;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> { // <Entity Type, Primary Key type>
}

/*
save()
findById()
findAll()
delete()

*/