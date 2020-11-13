package com.example;

import com.example.model.HelloObj;
import com.example.model.State;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("states")
public class States {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHello() {
        List<State> states = StatesDB.states;
        return  Response.status(200).entity(states).build();
    }

}
