package com.sweettastic.orderbill.service;

import com.sweettastic.orderbill.Repository.OrderBillRepo;
import com.sweettastic.orderbill.exceptions.OrderBillException;
import com.sweettastic.orderbill.model.OrderBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderBillServiceImpl implements  OrderBillService{

    @Autowired
    private OrderBillRepo billRepo;

    @Override
    public OrderBill addOrderBill(OrderBill bill) {

        return billRepo.save(bill);
    }

    @Override
    public OrderBill updateOrderBill(OrderBill bill) {
        Optional<OrderBill> optional =  billRepo.findById(bill.getOrderBillId());
      if(optional.isEmpty()) throw new OrderBillException("order bill does not exits");
      return  billRepo.save(bill);
    }

    @Override
    public OrderBill cancelOrderBill(Integer id) {

         Optional<OrderBill> optional=billRepo.findById(id);
         billRepo.deleteById(id);
        return optional.get();
    }

    @Override
    public List<OrderBill> showAllOrderBills() {
        return billRepo.findAll();
    }

    @Override
    public OrderBill showOrderDetails(Integer id) {
        Optional<OrderBill> optional=billRepo.findById(id);
            return  optional.get();
    }
}
