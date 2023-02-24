package com.sweettastic.orderbill.controller;

import com.sweettastic.orderbill.model.OrderBill;
import com.sweettastic.orderbill.service.OrderBillService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderbill")
public class OrderBillController {

    @Autowired
    private OrderBillService service;


    @PostMapping("/save")
    public ResponseEntity<OrderBill> saveOrderBill(@RequestBody OrderBill orderBill){

        return new ResponseEntity<>(service.addOrderBill(orderBill), HttpStatus.CREATED);
    }


    @DeleteMapping("/orderbill/{id}")
    public ResponseEntity<OrderBill> deleteOrderBill(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.cancelOrderBill(id),HttpStatus.OK);

    }


    @GetMapping("/update/orderbill")
    public ResponseEntity<OrderBill> updateOrderBill(@RequestBody OrderBill orderBill){
        return new ResponseEntity<>(service.updateOrderBill(orderBill),HttpStatus.OK);

    }


    @GetMapping("/bills")
    public ResponseEntity<List<OrderBill>> showAllOrders(){
        return new ResponseEntity<>(service.showAllOrderBills(),HttpStatus.OK);

    }

    @GetMapping("/orderbill/{id}")
    public ResponseEntity<OrderBill> totalPrice(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.showOrderDetails(id),HttpStatus.OK);
    }




}
