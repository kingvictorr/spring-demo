package com.example.demo.models;

import com.example.demo.utils.DiscountType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Discount DAO
 */
@Document
public class Discount {
    @Id
    @Field("_id")
    private String id;
    @Field
    private DiscountType type;
    @Field
    private float value;

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
     * Getting type
     * @return
     */
    public DiscountType getType() {
        return type;
    }

    /**
     * Setting type
     * @param type
     */
    public void setType(DiscountType type) {
        this.type = type;
    }

    /**
     * Get value
     * @return
     */
    public float getValue() {
        return value;
    }

    /**
     * Set value
     * @param value
     */
    public void setValue(float value) {
        this.value = value;
    }
}
