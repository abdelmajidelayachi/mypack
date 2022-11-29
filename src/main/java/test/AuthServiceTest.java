package test;

import com.mypack.dao.BaseDAOImpl;
import com.mypack.entity.Admin;
import com.mypack.service.AuthService;
import org.junit.jupiter.api.Test;

import java.util.List;

class AuthServiceTest {

    @Test
    void testLoginWithValidEmailAndPassword() {
        AuthService<Admin> authService = new AuthService<>(Admin.class);
        List<Admin> admins = authService.login("admin@gmail.com", "admin");
        System.out.println(admins.get(0).getFirstname());
    }

    @Test
    void testSave()
    {
        BaseDAOImpl<Admin> useDao = new BaseDAOImpl<>(Admin.class);

        Admin admin = new Admin();

        admin.setFirstname("firstName");
        admin.setLastname("lastName");
        admin.setEmail("email@mail.com");
        admin.setPassword("password");

        useDao.save(admin);
    }
}