package com.mypack.controller;

import com.mypack.entity.Admin;
import com.mypack.entity.Driver;
import com.mypack.entity.Manager;
import com.mypack.service.AuthService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;

@Named("Auth")
@SessionScoped
public class AuthController implements Serializable {
    private String role;
    private String email;
    private String password;
    private Admin loggedAdmin = null;
    private Manager loggedManager = null;
    private Driver loggedDriver = null;

    public Manager getLoggedManager() {
        return loggedManager;
    }

    public void setLoggedManager(Manager loggedManager) {
        this.loggedManager = loggedManager;
    }

    public Driver getLoggedDriver() {
        return loggedDriver;
    }

    public void setLoggedDriver(Driver loggedDriver) {
        this.loggedDriver = loggedDriver;
    }

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

    public String auth() throws IOException {
        switch (role)
        {
            case "Admin":
            {
                try {
                    Admin admin = loginAdmin(email,password);
                    if (admin != null)
                    {
                        loggedAdmin = admin;
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.getExternalContext().getSessionMap().put("getUser", admin);
                        context.getExternalContext().getSessionMap().put("role", "Admin");
                        System.out.println("admin logged");
                        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                        externalContext.redirect("/admin/welcome.xhtml");
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
                        loggedManager = manager;
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.getExternalContext().getSessionMap().put("getUser", manager);
                        context.getExternalContext().getSessionMap().put("role", "Manager");
                        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                        externalContext.redirect("/manager/welcome.xhtml");
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
                        loggedDriver = driver;
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.getExternalContext().getSessionMap().put("getUser", driver);
                        context.getExternalContext().getSessionMap().put("role", "Driver");
                        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                        externalContext.redirect("/driver/welcome.xhtml");
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("/auth/login.xhtml");
        return null;

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