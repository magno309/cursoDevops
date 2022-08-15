package com.service.springcloud.couponservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.springcloud.couponservice.model.Coupon;
import com.service.springcloud.couponservice.repo.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CuponRestController {

    @Autowired
    CouponRepo couponRepo;

    @PostMapping("/coupons")
    public Coupon create(@RequestBody Coupon coupon) {
        return couponRepo.save(coupon);
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code") String code) {
        return couponRepo.findByCode(code);
    }

}
