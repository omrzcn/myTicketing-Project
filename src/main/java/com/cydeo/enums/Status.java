package com.cydeo.enums;

public enum Status {
    OPEN("Open"),IN_PROGRESS("In Progress"), COMPLETED("Completed");


    private final String value;
    Status( String value) {
        this.value = value;
    }

    public String getValue() { // this is getter
        return value;
    }
}
