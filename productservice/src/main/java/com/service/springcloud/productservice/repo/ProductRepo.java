package com.service.springcloud.productservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.springcloud.productservice.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
    
}
