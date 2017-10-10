package com.org.fizzbuzz.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Gaurav Murkute
 * 
 * Model class for holding error details.
 *
 */
@Getter
@Setter
public class ErrorResponse {
    
       public ErrorResponse(String message, int messageCode) {
        super();
        this.message = message;
        this.messageCode = messageCode;
    }

    private String message;
    private int messageCode;

}
