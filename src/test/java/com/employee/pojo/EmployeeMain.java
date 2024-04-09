package com.employee.pojo;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class EmployeeMain {
    public static void main(String[] args) throws JsonProcessingException {
        Employee employee = new Employee();
        employee.setId(19);
        employee.setFirstName("Lucy");
        employee.setLastName("Pevensie");
        employee.setEmail("lucy@narnia.com");
        employee.setSkills(Arrays.asList("Sword Fighting", "Healing"));
        System.out.println(employee.getId());
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getEmail());
        System.out.println(employee.getSkills());

        ObjectMapper objectMapper = new ObjectMapper();
        String employeeJson = objectMapper.writerWithDefaultPrettyPrinter()
                               .writeValueAsString(employee);

        System.out.println(employeeJson);
    }
}
