package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
public class Bill {
    @Id
    @Field("_id")
    private String id;
    @Field
    private List<Item> items;
    @Field
    private Double total;
    @Field
    @DBRef
    private User user;

    public Bill(List<Item> items, Double total) {
        this.id = id;
        this.items = items;
        this.total = total;
    }

    public Bill(String id, List<Item> items, Double total) {
        this.id = id;
        this.items = items;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
