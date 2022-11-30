package test;

import com.mypack.entity.Admin;
import com.mypack.service.AuthService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    @Test
    void testLoginWithValidEmailAndPassword() {
        AuthService<Admin> adminAuthService = new AuthService<>(Admin.class);
        Admin loggedAdmin = adminAuthService.login("email@mail.com", "password");
        assertNotNull(loggedAdmin);
    }
}