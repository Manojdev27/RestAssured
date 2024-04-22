package com.employee.httpUrlConnection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionTest {

    public void getMethod() throws IOException {
        URL url = new URL("http://localhost:3000/employees");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        int statusCode = httpURLConnection.getResponseCode();
        System.out.println("Status Code is "+statusCode);

        String message = httpURLConnection.getResponseMessage();
        System.out.println("Response Message is "+message);

        InputStream inputStream = httpURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while((line =bufferedReader.readLine())!=null){
            stringBuffer.append(line);
        }
        System.out.println(stringBuffer);

    }

    public void postMethod() throws IOException {
        URL url = new URL("http://localhost:3000/employees");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application.json");
        httpURLConnection.setDoOutput(true);
        String jsonBody = "{\n" +
                "    \"id\": 30,\n" +
                "    \"firstname\": \"Harry\",\n" +
                "    \"lastname\": \"Potter\",\n" +
                "    \"email\": \"HarryPotter@hogwarts.com\"\n" +
                "  }";
        byte[]  inputJson = jsonBody.getBytes();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(inputJson);
        System.out.println("Response Code :"+httpURLConnection.getResponseCode());
        System.out.println("Response Message is: "+ httpURLConnection.getResponseMessage());
        InputStream inputStream = httpURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while((line =bufferedReader.readLine())!=null){
            stringBuffer.append(line);
        }
        System.out.println(stringBuffer);
    }

    public void putRequest() throws IOException {
        URL url = new URL("http://localhost:3000/employees/211");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("PUT");
        httpURLConnection.setRequestProperty("Content-Type", "application.json");
        httpURLConnection.setDoOutput(true);
        String jsonBody = "{\n" +
                "    \"firstname\": \"Steven\",\n" +
                "    \"lastname\": \"Speilberg\",\n" +
                "    \"email\": \"steven.speilberg@jurrasicpark.com\"\n" +
                "  }";
        byte[]  inputJson = jsonBody.getBytes();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(inputJson);
        System.out.println("Response Code :"+httpURLConnection.getResponseCode());
        System.out.println("Response Message is: "+ httpURLConnection.getResponseMessage());
        InputStream inputStream = httpURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while((line =bufferedReader.readLine())!=null){
            stringBuffer.append(line);
        }
        System.out.println(stringBuffer);
    }

    public void deleteRequest() throws IOException {
        URL url = new URL("http://localhost:3000/employees/211");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("DELETE");
        httpURLConnection.setRequestProperty("Content-Type", "application.json");
        httpURLConnection.setDoOutput(true);
        System.out.println("Response Code :"+httpURLConnection.getResponseCode());
        System.out.println("Response Message is: "+ httpURLConnection.getResponseMessage());
        InputStream inputStream = httpURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while((line =bufferedReader.readLine())!=null){
            stringBuffer.append(line);
        }
        System.out.println(stringBuffer);
    }
    public static void main(String[] args) throws IOException {
        HttpURLConnectionTest httpURLConnectionTest = new HttpURLConnectionTest();
        httpURLConnectionTest.getMethod();
//        httpURLConnectionTest.postMethod();
        httpURLConnectionTest.putRequest();
        httpURLConnectionTest.deleteRequest();
    }
}
