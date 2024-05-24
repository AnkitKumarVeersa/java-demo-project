package com.appsdeveloper.app.ws.mobileappws.ui.model.response;

public enum ErrorMessages {
    MISSING_REQUIRED_FIELD("Missing required field. Please send all the required fields."),
    RECORD_ALREADY_EXISTS("Record already exists"),
    NO_RECORD_FOUND("Record not found");

    private String errorMessage;

    ErrorMessages(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
