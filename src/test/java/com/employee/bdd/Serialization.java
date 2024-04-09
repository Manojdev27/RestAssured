package com.employee.bdd;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class Serialization {

    @Test
    public void serialization(){
        Map<String,Object> jsonBody = new HashMap<String, Object>();
        jsonBody.put("firstName","Harry");
        jsonBody.put("lastName","Potter");
        jsonBody.put("email", "harrypotter@hogwarts.com");
        List<String> skills = new ArrayList<String>();
        skills.add("Java");
        skills.add("Selenium");
        skills.add("RestAssured");
        skills.add("Github");
        jsonBody.put("skills",skills);
        System.out.println(jsonBody);

        given().baseUri("http://localhost:3000/")
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .log()
                .all()
                .when().put("/employees/1")
                .then().log().all();


    }
}
