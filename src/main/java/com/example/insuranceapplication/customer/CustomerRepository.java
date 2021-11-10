package com.example.insuranceapplication.customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    public Integer countById(Integer id);
}
