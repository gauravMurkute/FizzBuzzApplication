package com.org.fizzbuzz.service;

import com.org.fizzbuzz.model.FizzBuzzResponse;

/**
 * @author Gaurav Murkute
 *
 *  Interface for evaluating Fizz Buzz.
 */
public interface FizzBuzzService {

    /**
     * @param number
     * @return
     * 
     * This method will fizzbuzzify upto given input number and group them across Fizz, Buzz and FizzBuzz category
     */
    FizzBuzzResponse getFizzBuzz(Long max);

    /**
     * @param number
     * @return
     * 
     * This method will determine if the given input number is a Fizz or Buzz or FizzBuzz.
     */
    String fizzBuzzOf(Long number);

}
