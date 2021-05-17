package com.example.demo.models;

import com.example.demo.utils.ItemType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * This class is a DAO for an Order.
 */
@Document(value = "orders")
public class Order {
    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Field
    private String itemName;
    @Field
    private String itemDescription;
    @Field
    private int itemQuantity;
    @Field
    private double cost;
    @Field
    private ItemType itemType;

    public Order(String itemName, String itemDescription, int itemQuantity, double cost, ItemType itemType) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.cost = cost;
        this.itemType = itemType;
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
     * Getting item name
     * @return
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Setting item name
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Getting item desc
     * @return
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Setting item desc
     * @param itemDescription
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    /**
     * Getting item quantity
     * @return
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     * Setting item quantity
     * @param itemQuantity
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
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

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", cost=" + cost +
                ", itemType=" + itemType +
                '}';
    }


}
