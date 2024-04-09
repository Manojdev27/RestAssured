package com.employee.bdd;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
public class CreateEmpFromJsonFile {

   @Test(enabled = true)
   public void createEmpFromJson(){
        File jsonFile = new File("postData.json");
        given().baseUri("http://localhost:3000")
                .header("Content-Type", "application/json")
                .body(jsonFile)
                .when().post("/employees").prettyPrint();
    }

    @Test(enabled = false)
    public void updateEmpFromJson(){
        File jsonFile = new File("postData.json");
        given().baseUri("http://localhost:3000")
                .header("Content-Type", "application/json")
                .body(jsonFile)
                .when().put("/employees/1").prettyPrint();
    }
}



