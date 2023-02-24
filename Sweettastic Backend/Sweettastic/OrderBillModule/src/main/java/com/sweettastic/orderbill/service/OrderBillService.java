package com.sweettastic.orderbill.service;

import com.sweettastic.orderbill.exceptions.OrderBillException;
import com.sweettastic.orderbill.model.OrderBill;

import java.util.List;

public interface OrderBillService {


     OrderBill addOrderBill(OrderBill bill);
        OrderBill   updateOrderBill(OrderBill bill) throws OrderBillException;
        OrderBill cancelOrderBill(Integer id) throws OrderBillException;;

        List<OrderBill> showAllOrderBills() throws OrderBillException;;

        OrderBill showOrderDetails(Integer id) throws OrderBillException;;


}
