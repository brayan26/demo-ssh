package com.example.demo.infrastructure.utils;

public class Error404Exception extends RuntimeException {
    public Error404Exception(String message) {
        super(message);
    }
}
