package com.example.demo.repo;

import com.example.demo.models.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillRepo extends MongoRepository <Bill, String> {
}
