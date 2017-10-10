package com.org.fizzbuzz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.org.fizzbuzz.exception.FizzBuzzException;
import com.org.fizzbuzz.model.GlobalConstants;
import com.org.fizzbuzz.model.FizzBuzzResponse;

import java.util.stream.LongStream;



/**
 * @author Gaurav Murkute
 *
 * Implementation class for {@link FizzBuzzService} interface.
 */
@Service
public class FizzBuzzServiceImpl implements FizzBuzzService{

    private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzServiceImpl.class);

    private Long min = 1L;


    /**
     * @param number
     * @return
     * 
     * This method will fizzbuzzify upto given input number and group them across Fizz, Buzz and FizzBuzz category
     */
    @Override
    public FizzBuzzResponse getFizzBuzz(Long maxNumber) {

        // To validate if the input number is greater than equal to min number defined. 
        validateInput(maxNumber);

        FizzBuzzResponse response = new FizzBuzzResponse();

        LOGGER.info("Invoking FizzBuzzServiceImpl.doFizzBuzz()");
        // This will be trigger doFizzBuzz from min..number  
        LongStream.rangeClosed(min, maxNumber)
        .forEach(num -> {
            doFizzBuzz(num, response);
        });

        return response;

    }


    /**
     * @param number
     * @param response
     * 
     * This method will evaluate fizzBuzz output for an input number
     * and group number in Fizz, Buzz and FizzBuzz.
     */
    private void doFizzBuzz(Long number, FizzBuzzResponse response) {

        String output = fizzBuzzOf(number);

        if(GlobalConstants.FIZZ_TEXT.equals(output))
        {
            response.getFizzList().add(number);
        }
        else if(GlobalConstants.BUZZ_TEXT.equals(output))
        {
            response.getBuzzList().add(number);
        }
        else if((GlobalConstants.FIZZ_TEXT+GlobalConstants.BUZZ_TEXT).equals(output))
        {
            response.getFizzBuzzList().add(number);
        }

    }

    /**
     * @param number
     * 
     *  This method will validate the input number for being smaller than minimum number allowed.
     */
    private void validateInput(Long number) {

        LOGGER.info("Validating input number");
        if(number < min)
        {
            LOGGER.error("GlobalConstants.INVALID_INPUT_NUMBER" + min);
            throw new FizzBuzzException(GlobalConstants.INVALID_INPUT_NUMBER + min );
        }

    }



    /**
     * @param number
     * @return
     * 
     * This method will determine if the given input number is a Fizz or Buzz or FizzBuzz.
     */
    @Override
    public String fizzBuzzOf(Long number)
    {

        String output = GlobalConstants.EMPTY_STRING;

        if(number == 0)
        {
            return output;
        }

        boolean isFizz = divisibleBy(number, GlobalConstants.FIZZ_NUMBER);
        boolean isBuzz = divisibleBy(number, GlobalConstants.BUZZ_NUMBER);

        if(isFizz)
        {
            output+=GlobalConstants.FIZZ_TEXT;
        }
        if(isBuzz)
        {
            output+=GlobalConstants.BUZZ_TEXT;
        }

        return output;
    }



    /**
     * @param numerator
     * @param denominator
     * @return
     * 
     * This method will check if the numerator number is divisible by denominator number
     */
    private boolean divisibleBy(Long numerator, Long denominator)
    {
        return (numerator % denominator) == 0;
    }

}
