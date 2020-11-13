package com.example;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import com.example.resources.Calculator;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class CalculatorTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(Calculator.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void test9() {
        final String result = target().path("calculator").path("add").path("4").path("5").request().get(String.class);

        System.out.println("Response = "+result);
        assertEquals("9", result);

    }

    @Test
    public void test0() {
        final String result2 = target().path("calculator").path("add").path("0").path("0").request().get(String.class);
        assertEquals("0", result2);
    }


    @Test
    public void testMax() {
        final String result = target().path("calculator").path("add").path("2147483646").path("1").request().get(String.class);
        System.out.println("Response = "+result);
        assertEquals("2147483647", result);
    }
}
