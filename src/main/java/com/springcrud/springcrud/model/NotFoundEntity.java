package com.springcrud.springcrud.model;




public class NotFoundEntity {
    String message;
    long statusCode;
    long timestamp;

    public NotFoundEntity() {
    }

    public NotFoundEntity(String message, long statusCode, long timestamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public long getStatusCode() {
        return statusCode;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatusCode(long statusCode) {
        this.statusCode = statusCode;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
