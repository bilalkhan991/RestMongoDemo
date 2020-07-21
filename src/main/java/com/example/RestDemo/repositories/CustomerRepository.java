package com.example.RestDemo.repositories;

import com.example.RestDemo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
