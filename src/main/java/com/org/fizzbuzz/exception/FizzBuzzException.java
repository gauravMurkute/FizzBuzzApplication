package com.org.fizzbuzz.exception;

/**
 * @author Gaurav Murkute
 * 
 * Global Exception class for FizzBuzz application exceptions.
 *
 */
public class FizzBuzzException extends RuntimeException{


    private static final long serialVersionUID = 1L;

    public FizzBuzzException(String msg) {
        super(msg);
    }

    public FizzBuzzException(String msg, Throwable t) {
        super(msg, t);
    }

    public FizzBuzzException()
    {
        super();
    }


}
