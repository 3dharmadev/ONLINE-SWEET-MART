package com.sweettastic.service;



import com.sweettastic.exceptions.OrderBillException;
import com.sweettastic.models.OrderBill;

import java.util.List;

public interface OrderBillService {


     OrderBill addOrderBill(OrderBill bill);
        OrderBill   updateOrderBill(OrderBill bill) throws OrderBillException;
        OrderBill cancelOrderBill(Integer id) throws OrderBillException;;

        List<OrderBill> showAllOrderBills() throws OrderBillException;;

        OrderBill showOrderDetails(Integer id) throws OrderBillException;;


}
