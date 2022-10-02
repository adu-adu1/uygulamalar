package com.projectteam3.recipeproject.app.gen.enums;

public enum ResponseMessage {
    SUCCESSFUL("Successful"),
    ;

    private String message;
    ResponseMessage(String message) {
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
