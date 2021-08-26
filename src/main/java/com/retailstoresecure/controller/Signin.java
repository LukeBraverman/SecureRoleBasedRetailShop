package com.retailstoresecure.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Signin {


    //All user should be able to access
    @GetMapping()
    public String home() {

        return "home";
    }


    //Only authenticated users can acess this
    @GetMapping("employee/timetable")
    public String employeeSchedule() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getAuthorities());
        return "employeeSchedule";
    }

    //Only users with the "Admin" role can access this page
    @GetMapping("admin/workerpay")
    public String workerPay() {

        return "employeeSchedule";
    }






}
