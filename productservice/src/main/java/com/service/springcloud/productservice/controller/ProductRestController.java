package com.service.springcloud.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.service.springcloud.productservice.dto.Coupon;
import com.service.springcloud.productservice.model.Product;
import com.service.springcloud.productservice.repo.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
    
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${couponService.url}")
    private String couponServiceURL;

    @PostMapping("/products")
    public Product create(@RequestBody Product product){
        Coupon coupon = restTemplate.getForObject(couponServiceURL + product.getCouponCode(), Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepo.save(product);
    }

}
