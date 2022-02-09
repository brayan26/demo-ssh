package com.example.demo.infrastructure.utils;

public class Error400Exception extends RuntimeException {
    public Error400Exception(String message) {
        super(message);
    }
}
