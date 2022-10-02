package com.projectteam3.recipeproject.app.gen.enums;

public enum ExceptionMessage {

    RESOURCE_NOT_FOUND("Resource not found"),
    RESOURCE_USED("Resource is used"),
    ;

    private String message;
    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
