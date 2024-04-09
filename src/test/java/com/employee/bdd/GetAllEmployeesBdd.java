package com.employee.bdd;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetAllEmployeesBdd {

    @Test
    public void getAllEmployees(){

        RestAssured.given().baseUri("http://localhost:3000/")
                .when().get("employees").prettyPrint();


    }
}
