package com.sweettastic.controllers;


import com.sweettastic.exceptions.CustomerException;
import com.sweettastic.exceptions.ProductException;
import com.sweettastic.models.Category;
import com.sweettastic.models.Customer;
import com.sweettastic.models.Product;
import com.sweettastic.models.User;
import com.sweettastic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
     private AdminService adminService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> users =adminService.allUsers();
        return new ResponseEntity<>(users, HttpStatus.FOUND);

    }


    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() throws CustomerException {

        List<Customer> customers =adminService.allCustomers();
        return new ResponseEntity<>(customers, HttpStatus.FOUND);

    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() throws ProductException {

        List<Product> products =adminService.allProducts();
        return new ResponseEntity<>(products, HttpStatus.FOUND);

    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(){

        List<Category> categories =adminService.allCategories();
        return new ResponseEntity<>(categories, HttpStatus.FOUND);

    }





}
