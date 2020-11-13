package com.example;

import javax.ws.rs.core.Application;

import com.example.model.State;
import com.example.resources.States;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StatesTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(States.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetState() {
        final State responseMsg = target()
                .path("states")
                .path("AL")
                .request().get(State.class);

        assertNotNull(responseMsg);
        assertEquals("ALABAMA", responseMsg.getName());
    }

    @Test
    public void testGetStateError() {
        final State responseMsg = target()
                .path("states")
                .path("ALa")
                .request().get(State.class);

        assertNotNull(responseMsg);
        assertEquals("", responseMsg.getName());
    }

}
