package com.thabo.services;

import org.springframework.stereotype.Component;

@Component
public class UserDepartmentService {

    public String getUserDepartment(){

        System.out.println("Coming from getUserDepartment method in the UserDepartment service class");
        return "Accounts Department";
    }
}
