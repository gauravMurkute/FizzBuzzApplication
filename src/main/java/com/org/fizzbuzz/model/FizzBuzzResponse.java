package com.org.fizzbuzz.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Gaurav Murkute
 * 
 * Output Model class for holding fizzbuzz numbers.
 *
 */
@Getter
@Setter
public class FizzBuzzResponse {

    @JsonProperty("Fizz")
    private List<Long> fizzList;
    
    @JsonProperty("Buzz")
    private List<Long> buzzList;
    
    @JsonProperty("FizzBuzz")
    private List<Long> fizzBuzzList;
    
    public FizzBuzzResponse() {
        
        fizzList = new ArrayList<>();
        buzzList =  new ArrayList<>();
        fizzBuzzList = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "FizzBuzzResponse [fizzList=" + fizzList + ", buzzList=" + buzzList + ", fizzBuzzList=" + fizzBuzzList
                + "]";
    }
    
    
}
