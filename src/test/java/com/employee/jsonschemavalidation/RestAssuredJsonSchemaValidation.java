package com.employee.jsonschemavalidation;

import static io.restassured.RestAssured.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class RestAssuredJsonSchemaValidation {

    @Test
    public void validationUsingJsonSchemaInClassPath(){

        File inputJson = new File("src/test/resources/input.json");
        given().baseUri("http://localhost:3000/")
                .header("Content-Type", "application.json")
                .body(inputJson).when().post("/employees").then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));

    }

    @Test
    public void validationUsingMatchesJsonSchema(){
        File inputJson = new File("src/test/resources/input.json");
        File inputSchema = new File("src/test/resources/schema.json");
        given().baseUri("http://localhost:3000/")
                .header("Content-Type", "application.json")
                .body(inputJson).when().post("/employees").then()
                .body(JsonSchemaValidator.matchesJsonSchema("{\n" +
                        "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
                        "  \"type\": \"object\",\n" +
                        "  \"properties\": {\n" +
                        "    \"skills\": {\n" +
                        "      \"type\": \"array\",\n" +
                        "      \"items\": [\n" +
                        "        {\n" +
                        "          \"type\": \"string\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"type\": \"string\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"type\": \"string\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"type\": \"string\"\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    },\n" +
                        "    \"firstName\": {\n" +
                        "      \"type\": \"string\"\n" +
                        "    },\n" +
                        "    \"lastName\": {\n" +
                        "      \"type\": \"string\"\n" +
                        "    },\n" +
                        "    \"email\": {\n" +
                        "      \"type\": \"string\"\n" +
                        "    },\n" +
                        "    \"id\": {\n" +
                        "      \"type\": \"integer\"\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"required\": [\n" +
                        "    \"skills\",\n" +
                        "    \"firstName\",\n" +
                        "    \"lastName\",\n" +
                        "    \"email\",\n" +
                        "    \"id\"\n" +
                        "  ]\n" +
                        "}"));
    }
}
