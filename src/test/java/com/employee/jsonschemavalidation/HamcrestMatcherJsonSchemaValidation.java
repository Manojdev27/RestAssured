package com.employee.jsonschemavalidation;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.io.*;

public class HamcrestMatcherJsonSchemaValidation {

   @Test
   public void validate() throws IOException {
        File inputJson = new File("src/test/resources/input.json");
        String jsonContent = FileUtils.readFileToString(inputJson, "UTF-8");
        File jsonSchema = new File("src/test/resources/schema.json");
        MatcherAssert.assertThat(jsonContent, JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
