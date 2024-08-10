package com.hideki.pawnshopSystem.shared;

public class ApiResponse<T> {
    private String message;
    private T data;

    public ApiResponse(){}

    public ApiResponse(String message){
        this.message = message;
    }

    public ApiResponse(String message, T data){
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
