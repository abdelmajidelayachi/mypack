package com.mypack.controller;

import jakarta.inject.Named;

@Named("navigationController")
public class navigationController {

    public String login() {
        return "login";
    }

    public String welcomeAdmin() {
        return "welcome";
    }
    public String dashboardCustomer() {
        return "customer/dashboard";
    }
}