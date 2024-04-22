package com.employee.unirest;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.net.MalformedURLException;

public class UnirestHTTPClient {

    public void getRequest() throws MalformedURLException {
      HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:3000/employees").asJson();
        System.out.println("Status Code: "+jsonResponse.getStatus());
        System.out.println("Status Message: "+jsonResponse.getStatusText());
        System.out.println("Response Body: "+jsonResponse.getBody());

    }
    public void postMethod(){
        HttpResponse<JsonNode> jsonResponse = Unirest.post("http://localhost:3000/employees").body("{\n" +
               "    \"id\": \"70\",\n" +
               "    \"firstname\": \"Florence\",\n" +
               "    \"lastname\": \"Mills\",\n" +
               "    \"email\": \"FlorenceMills@anywoods.com\"\n" +
               "  }").asJson();
        System.out.println("Status Code: "+jsonResponse.getStatus());
        System.out.println("Status Message: "+jsonResponse.getStatusText());
        System.out.println("Response Body: "+jsonResponse.getBody());

    }

    public void putMethod() {
        HttpResponse<JsonNode> jsonResponse = Unirest.put("http://localhost:3000/employees/70").body("{\n" +
                "    \"id\": 70,\n" +
                "    \"firstname\": \"Emma\",\n" +
                "    \"lastname\": \"Watson\",\n" +
                "    \"email\": \"EmmaWatson@anywoods.com\"\n" +
                "  }").asJson();
        System.out.println("Status Code: " + jsonResponse.getStatus());
        System.out.println("Status Message: " + jsonResponse.getStatusText());
        System.out.println("Response Body: " + jsonResponse.getBody());
    }

    public void deleteMethod() {
        HttpResponse<JsonNode> jsonResponse = Unirest.delete("http://localhost:3000/employees/70").asJson();
        System.out.println("Status Code: " + jsonResponse.getStatus());
        System.out.println("Status Message: " + jsonResponse.getStatusText());
        System.out.println("Response Body: " + jsonResponse.getBody());
    }
    public static void main(String[] args) throws MalformedURLException {
        UnirestHTTPClient unirestHTTPClient = new UnirestHTTPClient();
        unirestHTTPClient.getRequest();
        unirestHTTPClient.postMethod();
        unirestHTTPClient.putMethod();
        unirestHTTPClient.deleteMethod();


    }
}
