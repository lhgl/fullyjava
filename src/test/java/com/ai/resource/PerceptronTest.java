package com.ai.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PerceptronTest {
    @Test
    public void testPostPredict() {
        double[] input = {1.0};
        given()
                .contentType(ContentType.JSON)
                .body(String.valueOf(input))
                .post("/perceptron/predict")
                .then()
                .statusCode(200);
    }
}