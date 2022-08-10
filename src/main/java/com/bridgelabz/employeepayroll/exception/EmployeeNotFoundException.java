package com.bridgelabz.employeepayroll.exception;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeNotFoundException extends RuntimeException{
    public Response getErrorResponse;
    private int statusCode;
    private String statusMessage;
    public EmployeeNotFoundException(int statusCode, String statusMessage) {
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
