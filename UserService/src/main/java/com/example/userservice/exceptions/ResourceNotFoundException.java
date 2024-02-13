package com.example.userservice.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
//        extra properties that you want to manage,
        super("Resource not found on server !!");
    }
    public  ResourceNotFoundException(String message){
        super(message);
    }
}
