package com.skpissay.baseproject.rest.response;

/**
 * Created by skpissay on 11/07/17.
 */

public class RestError {
    private int status;
    private String message;

    public RestError(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public RestError() {
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
