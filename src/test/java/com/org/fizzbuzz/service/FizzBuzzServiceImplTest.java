package com.org.fizzbuzz.service;


import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.fizzbuzz.exception.FizzBuzzException;
import com.org.fizzbuzz.model.FizzBuzzResponse;
import com.org.fizzbuzz.model.GlobalConstants;


/**
 * @author Gaurav Murkute
 *
 * Test class for testing {@link FizzBuzzServiceImpl}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzServiceImplTest {
    
    @Autowired
    private FizzBuzzService fizzBuzzService;
    
    
    
    @Test
    public void testFizzBuzzOfForNeitherFizzOrBuzz()
    {
        assertEquals(GlobalConstants.EMPTY_STRING, fizzBuzzService.fizzBuzzOf(1L));
        assertEquals(GlobalConstants.EMPTY_STRING, fizzBuzzService.fizzBuzzOf(2L));
        assertEquals(GlobalConstants.EMPTY_STRING, fizzBuzzService.fizzBuzzOf(0L));
    }
    
    @Test
    public void testFizzBuzzOfForFizz()
    {
        assertEquals(GlobalConstants.FIZZ_TEXT, fizzBuzzService.fizzBuzzOf(3L));
        assertEquals(GlobalConstants.FIZZ_TEXT, fizzBuzzService.fizzBuzzOf(6L));
        assertEquals(GlobalConstants.FIZZ_TEXT, fizzBuzzService.fizzBuzzOf(9L));
    }
    
    @Test
    public void testfizzBuzzOfForBuzz()
    {
        assertEquals(GlobalConstants.BUZZ_TEXT, fizzBuzzService.fizzBuzzOf(5L));
        assertEquals(GlobalConstants.BUZZ_TEXT, fizzBuzzService.fizzBuzzOf(10L));
        assertEquals(GlobalConstants.BUZZ_TEXT, fizzBuzzService.fizzBuzzOf(20L));
    }
    
    @Test
    public void testfizzBuzzOfForFizzBuzz()
    {
        assertEquals(GlobalConstants.FIZZ_TEXT+GlobalConstants.BUZZ_TEXT, fizzBuzzService.fizzBuzzOf(15L));
        assertEquals(GlobalConstants.FIZZ_TEXT+GlobalConstants.BUZZ_TEXT, fizzBuzzService.fizzBuzzOf(30L));
    }
    
    @Test
    public void testFizzBuzzServiceForPositiveInput() {

        FizzBuzzResponse response = fizzBuzzService.getFizzBuzz(15L);

        Assert.assertArrayEquals(new Long[] { new Long(3), new Long(6), new Long(9), new Long(12) },
                response.getFizzList().toArray());
        Assert.assertArrayEquals(new Long[] { new Long(5), new Long(10) }, response.getBuzzList().toArray());
        Assert.assertArrayEquals(new Long[] { new Long(15) }, response.getFizzBuzzList().toArray());
    }
    
    @Test(expected = FizzBuzzException.class)
    public void testFizzBuzzServiceForNegativeInput() {

        fizzBuzzService.getFizzBuzz(-15L);
   }
    
    @Test(expected = FizzBuzzException.class)
    public void testFizzBuzzServiceWithZero() {

        fizzBuzzService.getFizzBuzz(0L);
   }

}
