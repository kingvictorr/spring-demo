package com.example.demo.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String id) {
        super("Resource cannot be found with ID: " + id);
    }
}
