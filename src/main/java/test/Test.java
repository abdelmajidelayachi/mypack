package test;

import com.mypack.controller.AuthController;
import com.mypack.entity.Admin;
import com.mypack.service.AuthService;

public class Test {
    public static void main(String[] args) {
//        AuthService<Admin> adminAuthService = new AuthService<>(Admin.class);
//        Admin admin = adminAuthService.login("email@mail.com", "password");
//        System.out.println(admin.getFirstname());
        AuthController authController = new AuthController();

    }
}