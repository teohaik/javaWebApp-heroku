package com.example.resources;

import java.math.BigInteger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "calculator" path)
 */
@Path("calculator")
public class Calculator {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("add/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response adder(@PathParam("a") String a, @PathParam("b") String b) {
        BigInteger bi1 = new BigInteger(a);
        BigInteger bi2 = new BigInteger(b);
        BigInteger result = bi1.add(bi2);
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("pension")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculatePension(@QueryParam("months") String months,
            @QueryParam("lastSalary") String lastSalary) {
        Long result = Long.valueOf(months) * Long.valueOf(lastSalary) * 125;
        return Response.status(200).entity(result).build();
    }

}
