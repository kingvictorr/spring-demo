package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This class is a DAO for an Item.
 */
@Document
public class Item {
    @Id
    @Field("_id")
    private String id;
    @Field
    private String name;
    @Field
    private String description;
    @Field
    private int quantity;
    @Field
    private double cost;

    public Item(String id, String name, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    /**
     * Getting ID
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Setting ID
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getting name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setting item name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getting item desc
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setting item desc
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getting item quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setting item quantity
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get cost
     * @return
     */
    public double getCost() { return this.cost; }

    /**
     * Set cost
     * @param cost
     */
    public void setCost(double cost) { this.cost = cost; }
}
