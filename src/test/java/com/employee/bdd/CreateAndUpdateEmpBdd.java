package com.employee.bdd;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class CreateAndUpdateEmpBdd {

    @Test(enabled = false)
    public void createAnEmp(){
        given().baseUri("http://localhost:3000")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"id\": \"16\",\n" +
                        "    \"firstname\": \"Azel\",\n" +
                        "    \"lastname\": \"Godhand\",\n" +
                        "    \"email\": \"Azel@godhand.com\"\n" +
                        "  }").when().post("/employees").prettyPrint();

    }

    @Test(enabled = true)
    public void updateEmp(){

        given().baseUri("http://localhost:3000")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"id\": \"16\",\n" +
                        "    \"firstname\": \"Azel\",\n" +
                        "    \"lastname\": \"Devilhand\",\n" +
                        "    \"email\": \"Azel@devilhand.com\"\n" +
                        "  }")
                .when().put("/employees/16").prettyPrint();
    }
}
