package com.example.demo.repo;

import com.example.demo.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepo extends MongoRepository<Item, String> {
}
