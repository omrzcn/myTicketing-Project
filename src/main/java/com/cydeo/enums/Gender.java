package com.cydeo.enums;

public enum Gender {
    MALE("Male") , FEMALE("Female");

    private String value;
    Gender(String value) {
    }

    public String getValue() {
        return value;
    }
}
