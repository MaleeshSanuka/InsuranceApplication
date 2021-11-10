package com.example.insuranceapplication.customer;

public class CustomerNotFoundException extends Throwable{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
