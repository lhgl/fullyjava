package com.ai.resource;

import com.ai.alg.Perceptron;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/perceptron")
public class PerceptronResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String predict(double[] input) {
        Perceptron perceptron = new Perceptron(input.length, 0.1);
        int prediction = perceptron.predict(input, 0);
        return prediction == 1 ? "Dura" : "Macia";
    }
}