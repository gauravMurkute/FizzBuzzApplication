package com.org.fizzbuzz.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.org.fizzbuzz.model.FizzBuzzResponse;
import com.org.fizzbuzz.model.GlobalConstants;
import com.org.fizzbuzz.service.FizzBuzzService;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Gaurav Murkute
 * 
 * Test class for {@link FizzBuzzController} class 
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzControllerTest {

    private MockMvc mockMvc;


    @Mock
    private FizzBuzzService fizzBuzzMockService;

    @InjectMocks
    private FizzBuzzController controller;


    @Before
    public void setUp() {
        if (fizzBuzzMockService != null) {
            FizzBuzzResponse response = new FizzBuzzResponse();
            response.getFizzList().add(3L);
            when(fizzBuzzMockService.getFizzBuzz(3L)).thenReturn(response);

            this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        }
    }


    /**
     * @throws Exception
     * 
     * Test for valid numeric input using Mock Service.
     */
    @Test
    public void testFizzBuzzControllerForNumericInput() throws Exception {

        mockMvc.perform(get("/fizzbuzz/3")).andExpect(status().isOk()).
        andExpect(jsonPath("$."+GlobalConstants.FIZZ_TEXT).value(3));

        verify(fizzBuzzMockService, atLeastOnce()).getFizzBuzz(3L);
    }

    /**
     * @throws Exception
     * 
     * Test for non-numeric input using Mock Service.
     */
    @Test
    public void testFizzBuzzControllerForNonNumericInput() throws Exception {

        mockMvc.perform(get("/fizzbuzz/hello")).andExpect(status().isBadRequest());

    }
}
