package com.employee.nonbdd;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateEmployee {

    @Test
    public void createAnEmployee(){
        RestAssured.baseURI="http://localhost:3000/";
        RequestSpecification requestSpecification = RestAssured
                .given()
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"id\": \"15\",\n" +
                        "    \"firstname\": \"Shannon\",\n" +
                        "    \"lastname\": \"Godhand\",\n" +
                        "    \"email\": \"shannon@godhand.com\"\n" +
                        "  }");
        Response response = requestSpecification.request(Method.POST, "employees");
        System.out.println(response.asPrettyString());
        System.out.println(response.getStatusLine());

    }
}
