package com.example.resources;

import com.example.StatesDB;
import com.example.model.HelloObj;
import com.example.model.State;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("states")
public class States {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStates() {
        List<State> states = StatesDB.states;
        return  Response.status(200).entity(states).build();
    }

    @GET
    @Path("{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getState(@PathParam("code") String code) {
        State result = new State();
        Optional<State> optState = StatesDB.states
                .stream().filter(s -> s.getCode().equals(code))
                .findFirst();
        if(optState.isPresent()){
            result = optState.get();
        }
        return  Response.status(200).entity(result).build();
    }

}
