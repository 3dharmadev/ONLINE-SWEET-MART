package com.sweettastic.orderbill.Repository;

import com.sweettastic.orderbill.model.OrderBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBillRepo extends JpaRepository<OrderBill,Integer> {

}
