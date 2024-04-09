package com.employee.bdd;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteEmp {

    @Test
    public void deleteEmp(){
        given().baseUri("http://localhost:3000")
                .when().delete("/employees/20").prettyPrint();
    }
}
