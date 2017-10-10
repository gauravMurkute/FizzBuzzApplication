package com.org.fizzbuzz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.fizzbuzz.model.FizzBuzzResponse;
import com.org.fizzbuzz.service.FizzBuzzService;

/**
 * @author Gaurav Murkute
 *
 * Rest Controller class for providing api's for FizzBuzz Service.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/fizzbuzz")
public class FizzBuzzController{

    private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzController.class);
    
    @Autowired
    private FizzBuzzService fizzBuzzService;
    
    private FizzBuzzController() {
      
    }
    
    /**
     * @param number
     * @return
     * 
     * This method supports api for accepting upper bound integer number and return FizzBuzz Response.
     */
    @GetMapping(value = "/{number}")
    public FizzBuzzResponse calculateFizzBuzz(@PathVariable Long number)
    {
        LOGGER.info("Invoking fizzBuzzService.getFizzBuzz()");
        return fizzBuzzService.getFizzBuzz(number);
    }
}
