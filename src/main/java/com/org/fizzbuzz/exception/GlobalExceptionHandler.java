package com.org.fizzbuzz.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.org.fizzbuzz.model.ErrorResponse;
import com.org.fizzbuzz.model.GlobalConstants;

/**
 * @author Gaurav Murkute
 * 
 * Exception Handler class for handling different exceptions from application
 * and returning appropriate error message and error code.
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * @param ex
     * @return
     * 
     * This method will handle error if there is any {@link NumberFormatException}.
     */
    @ExceptionHandler(value = { NumberFormatException.class, MethodArgumentTypeMismatchException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse invalidInputException(NumberFormatException ex) {
        LOGGER.info("Invoking GlobalExceptionHandler.invalidInputException : " + ex.getMessage());

        return new ErrorResponse(GlobalConstants.INVALID_INPUT_FORMAT, HttpStatus.BAD_REQUEST.value());


    }

    /**
     * @param ex
     * @return
     * 
     * This method will handle error for {@link FizzBuzzException}
     */
    @ExceptionHandler(value = { FizzBuzzException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse fizzBuzzException(FizzBuzzException ex) {
        LOGGER.info("Invoking GlobalExceptionHandler.fizzBuzzException : " + ex.getMessage());

        return new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());

    }


}
