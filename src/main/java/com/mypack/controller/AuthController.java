package com.mypack.controller;

import com.mypack.entity.Admin;
import com.mypack.entity.Driver;
import com.mypack.entity.Manager;
import com.mypack.service.AuthService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("Auth")
@RequestScoped
public class AuthController {
    private String role;
    private String email;
    private String password;
    private Admin loggedAdmin = null;

    public Admin getLoggedAdmin() {
        return loggedAdmin;
    }

    public void setLoggedAdmin(Admin loggedAdmin) {
        this.loggedAdmin = loggedAdmin;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String auth()
    {
        switch (role)
        {
            case "Admin":
            {
                try {
                    Admin admin = loginAdmin(email,password);
                    if (admin != null)
                    {
                        loggedAdmin = admin;
//                        FacesContext context = FacesContext.getCurrentInstance();
//                        context.getExternalContext().getSessionMap().put("getUser", admin);
                        return "admin/welcome";
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            }
            case "Manager":
            {
                try {
                    Manager manager = loginManager(email,password);
                    if (manager != null)
                    {
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.getExternalContext().getSessionMap().put("getUser", manager);
                        return "manager/welcome";
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            }
            case "Driver":
            {
                try {
                    Driver driver = loginDriver(email,password);
                    if (driver != null)
                    {
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.getExternalContext().getSessionMap().put("getUser", driver);
                        return "driver/welcome";
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
        return "index";
    }

    private  Admin loginAdmin(String email, String password){
        try{
            AuthService<Admin> adminAuthService = new AuthService<>(Admin.class);
            System.out.println("adminAuthService");
            System.out.println("email: "+email);
            System.out.println("password: "+password);
            Admin loggedAdmin = adminAuthService.login(email, password);
            System.out.println(loggedAdmin);
            return loggedAdmin;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Manager loginManager(String email, String password){
        try{
            AuthService<Manager> authService = new AuthService<>(Manager.class);
            System.out.println("adminAuthService");
            System.out.println("email: "+email);
            System.out.println("password: "+password);
            Manager loggedUser = authService.login(email, password);
            System.out.println(loggedUser);
            return loggedUser;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Driver loginDriver(String email, String password) {
        try {
            AuthService<Driver> authService = new AuthService<>(Driver.class);
            System.out.println("adminAuthService");
            System.out.println("email: " + email);
            System.out.println("password: " + password);
            Driver loggedUser = authService.login(email, password);
            System.out.println(loggedUser);
            return loggedUser;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}