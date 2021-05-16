package com.example.demo.repo;

import com.example.demo.models.Discount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiscountRepo extends MongoRepository<Discount, String> {
}
