package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Bill;
import com.example.demo.models.Discount;
import com.example.demo.models.Order;
import com.example.demo.models.User;
import com.example.demo.utils.DiscountType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderProcessingController {
    @Autowired private MongoTemplate mongoTemplate;

    Logger logger = LoggerFactory.getLogger(OrderProcessingController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/bills/{id}/", produces="application/json")
    public Bill getDiscount(@PathVariable(required = true) String id) {
        logger.info("---------------------------------");
        Query billQ = new Query();
        // Find a bill with a matching supplied ID.
        billQ.addCriteria(Criteria.where("id").is(id));
        Bill bill = mongoTemplate.findOne(billQ, Bill.class);

        if (bill == null) {
            throw new ResourceNotFoundException("-- Bill --" + id);
        }

        if (bill.getOrders().size() < 1) {
            throw new ResourceNotFoundException("-- Bill Orders --" + id);
        }

        logger.info("BILL:" + bill);

        // Summation of all items on bill.
        double totalOfAllItems = bill.getOrders().stream().mapToDouble(Order::getCost).sum();
        bill.setTotal(totalOfAllItems);
        logger.info("Total of all items: " + totalOfAllItems);

        int numberOfLoyality = 0;
        int perHundredScheme = (int) (totalOfAllItems / 100);

        if (perHundredScheme > 1) {
            double calculatedPerHundredSchemeDiscount = calculatePerHundredSchemeDiscount(totalOfAllItems, bill);
        }

//        Bill updatedBill = (Bill) mongoTemplate.save(bill);

//        if (discount == null) {
//            throw new UserNotFoundException(id);
//        }

        logger.info("---------------------------------");
        return null;
    }

    private double calculatePerHundredSchemeDiscount(double totalOfAllItems, Bill bill) {
        var discount = mongoTemplate.findOne(
                Query.query(Criteria.where("type").is(DiscountType.HUNDRED_BILL))
                , Discount.class
        );

        if (discount == null) {
            return 0;
        }

        double sumOfDiscount = 0;

        for (double i = totalOfAllItems; i > 100; i-=100) {
            logger.info("> I: " + i);
            sumOfDiscount+=discount.getValue();
        }

        return sumOfDiscount;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bills", produces="application/json")
    public Bill createOrderBill(@RequestBody Bill bill) {
        List<Order> newOrders = new ArrayList<>();

        Query userQ = new Query();
        userQ.addCriteria(Criteria.where("id").is(bill.getUser().getId()));
        User usr = mongoTemplate.findOne(userQ, User.class);

        if (usr == null) {
            throw new ResourceNotFoundException("-- USER --" + bill.getUser().getId());
        }

        bill.getOrders().forEach((b) -> {
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(b.getId()));
            Order order = mongoTemplate.findOne(query, Order.class);

            if (order == null) {
                throw new ResourceNotFoundException("-- Bill Order --" + b.getId());
            }

            newOrders.add(order);
        });

        double totalOfAllItems = bill.getOrders().stream().mapToDouble(Order::getCost).sum();
        bill.setTotal(totalOfAllItems);
        bill.setOrders(newOrders);
        bill.setUser(usr);

        return mongoTemplate.save(bill);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/", produces="application/json")
    public ArrayList<Order> getOrder() {
        return (ArrayList<Order>) mongoTemplate.findAll(Order.class);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/", produces="application/json")
    public Order addOrder(@RequestBody Order order) {
        return mongoTemplate.save(order);
    }
}
