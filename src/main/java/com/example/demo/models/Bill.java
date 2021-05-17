package com.example.demo.models;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.List;

@Document("bills")
public class Bill {
    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Field
    @DBRef
    private List<Order> orders;
    @Field
    private Double total;
    @Field
    @Nullable
    private Double discountedTotal;
    @Field
    @DBRef
    private User user;
    @Field
    @DBRef
    private List<Discount> discountList;

    public Bill(List<Order> orders, User user) {
        this.orders = orders;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Nullable
    public Double getDiscountedTotal() {
        return discountedTotal;
    }

    public void setDiscountedTotal(@Nullable Double discountedTotal) {
        this.discountedTotal = discountedTotal;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Discount> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<Discount> discountList) {
        this.discountList = discountList;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", orders=" + orders +
                ", total=" + total +
                ", discountedTotal=" + discountedTotal +
                ", user=" + user +
                ", discountList=" + discountList +
                '}';
    }
}
