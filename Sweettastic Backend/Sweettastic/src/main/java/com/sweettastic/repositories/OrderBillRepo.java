package com.sweettastic.repositories;

 import com.sweettastic.models.OrderBill;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

@Repository
public interface OrderBillRepo extends JpaRepository<OrderBill,Integer> {

}
