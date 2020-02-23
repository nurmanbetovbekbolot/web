package itacademy.hw.service;

import itacademy.hw.model.Integers;
import itacademy.hw.model.Result;
import itacademy.hw.model.TemporalKey;
import itacademy.hw.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/hw")
public class MyService {

    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON})
    public String getSum(Integers a) {
        return a.addInts() + "";
    }

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/sum/{integer1}&{integer2}")

    public String addInts(@PathParam("integer1") Integer a, @PathParam("integer2") Integer b) {
        return a + b + "";
    }

    @GET
    @Path("/result")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Result getRes(Integers integers) {
        return new Result(integers.getA() + integers.getB());
    }

    @GET
    @Path("/user")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TemporalKey getRes(User user) {
        return new TemporalKey("temporalkey");
    }
    @GET
    @Path("/time")
    @Produces({MediaType.TEXT_PLAIN})
    public String showtime() {
        return new Date().toString();
    }
}