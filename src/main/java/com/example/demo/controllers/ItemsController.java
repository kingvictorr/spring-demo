package com.example.demo.controllers;

import com.example.demo.models.Discount;
import com.example.demo.models.Item;
import com.example.demo.repo.BillRepo;
import com.example.demo.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    ItemRepo itemsRepo;

    @RequestMapping(method = RequestMethod.GET, value = "/", produces="application/json")
    public ArrayList<Item> getItem() {
        return (ArrayList<Item>) itemsRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/", produces="application/json")
    public Item addItem(@RequestBody Item item) {
        return itemsRepo.save(item);
    }
}
