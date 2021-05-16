package com.example.demo.controllers;

import com.example.demo.models.Bill;
import com.example.demo.models.Discount;
import com.example.demo.repo.BillRepo;
import com.example.demo.repo.DiscountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
public class OrderProcessingController {
    @Autowired DiscountRepo discRepo;
    @Autowired BillRepo billRepo;

    @RequestMapping(method = RequestMethod.GET, value = "/", produces="application/json")
    public ArrayList<Discount> getDiscount() {
        return (ArrayList<Discount>) discRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/", produces="application/json")
    public Bill createOrderBill(@RequestBody Bill bill) {
        System.out.println("BILL: " + bill.toString());
        return null;
    }
}
