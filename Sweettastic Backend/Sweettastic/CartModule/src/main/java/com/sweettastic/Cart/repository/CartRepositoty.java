package com.sweettastic.Cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweettastic.Cart.Model.Cart;

public interface CartRepositoty extends JpaRepository<Cart, Integer> {

}
