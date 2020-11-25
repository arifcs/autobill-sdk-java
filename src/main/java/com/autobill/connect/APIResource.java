package com.autobill.connect;

public enum APIResource {
    ACCOUNT("accounts"),
    PRODUCT("products"),
    ORDER("orders");

    @Override
    public String toString() {
        return name;
    }

    APIResource(String name){
        this.name = name;
    }

    private String name;

}
