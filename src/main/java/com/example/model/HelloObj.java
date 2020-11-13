package com.example.model;

public class HelloObj {

    private String message;

    public HelloObj(String message) {
        this.message = message;
    }

    public HelloObj() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloObj{" +
                "message='" + message + '\'' +
                '}';
    }
}
