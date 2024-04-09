package com.employee.pojo;

import java.util.List;

public class Employee {

    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private List skills;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id =id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public List getSkills(){
        return skills;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setSkills(List skills){
        this.skills = skills;
    }
}
