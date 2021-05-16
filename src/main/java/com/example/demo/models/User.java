package com.example.demo.models;

import com.example.demo.utils.UserType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * User DAO
 */
@Document
public class User {
    @Id
    @Field("_id")
    private String id;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private String email;
    @Field
    private String phoneNumber;
    @Field
    private UserType userType;
    @Field
    private Date dateCreated;

    public User(String id, String firstName, String lastName, String email, String phoneNumber, UserType userType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
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
     * Get user first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set user first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getting user last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setting user last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
