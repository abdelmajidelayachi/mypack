package com.mypack.controller;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("navigationController")
public class navigationController {
    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();



    public String login() {
        return "login";
    }

    public String welcomeAdmin() {
        if(context.getSessionMap().get("role") != null && context.getSessionMap().get("role").equals("admin") && context.getSessionMap().get("getUser") != null) {
            return "admin/welcome";
        }
        return "auth/login";
    }

    public String welcomeManager() {
        if(context.getSessionMap().get("role") != null && context.getSessionMap().get("role").equals("manager") && context.getSessionMap().get("getUser") != null) {
            return "manager/welcome";
        }
        return "auth/login";
    }

    public String welcomeDriver() {
        if(context.getSessionMap().get("role") != null && context.getSessionMap().get("role").equals("driver") && context.getSessionMap().get("getUser") != null) {
            return "driver/welcome";
        }
        return "auth/login";
    }

}
