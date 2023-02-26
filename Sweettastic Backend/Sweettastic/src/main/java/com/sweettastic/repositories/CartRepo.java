package com.sweettastic.repositories;

 import com.sweettastic.models.Cart;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

}
