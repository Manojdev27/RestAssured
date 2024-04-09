package com.employee.jsonschemavalidation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class NetworkNtJsonSchemaValidator {

    @Test
    public void validateJsonSchema() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        File inputJson = new File("src/test/resources/input.json");
        InputStream inputSchema = new FileInputStream("src/test/resources/schema.json");
        JsonNode jsonNode = objectMapper.readTree(inputJson);
        JsonSchema jsonSchema = jsonSchemaFactory.getSchema(inputSchema);
        Set<ValidationMessage> result = jsonSchema.validate(jsonNode);
        if(result.isEmpty()){
            System.out.println("No Validation Errors");
        }
        else{
            for(ValidationMessage message:result){
                System.out.println(message);
            }
        }
//        RestAssured.given().baseUri("http://localhost:3000/")
//                .header("Content-Type", "application.json")
//                .body(inputJson).post("/employees");
    }
}
