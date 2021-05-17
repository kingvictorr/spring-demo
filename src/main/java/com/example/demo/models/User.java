package com.example.demo.models;

import com.example.demo.utils.UserType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

/**
 * User DAO
 */
@Document(value = "users")
public class User {
    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Field
    private String name;
    @Field
    private String email;
    @Field
    private String phoneNumber;
    @Field
    private UserType userType;
    @Field
    private Date dateCreated;

    @PersistenceConstructor
    public User(String name, String email, String phoneNumber, UserType userType, Date dateCreated) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.dateCreated = dateCreated;
    }

    /**
     * Getting ID
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Setting an ID
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get user name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set user name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getting user email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setting user email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getting user email
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setting user email
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getting user type
     * @return
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Setting user type
     * @param userType
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * This function is for getting the user date creation.
     * @return
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * This function is for setting user date creation.
     * @param dateCreated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userType=" + userType +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
