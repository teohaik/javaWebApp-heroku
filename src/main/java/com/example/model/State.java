package com.example.model;

public class State {

    private String code;
    private String name;


    public State(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public State() {
        code = "N/A";
        name = "N/A";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
