package test;

import com.mypack.dao.BaseDAOImpl;
import com.mypack.entity.Admin;
import com.mypack.util.SoutError;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        BaseDAOImpl<Admin> useDao = new BaseDAOImpl<>(Admin.class);
        Admin admin = new Admin();

        admin.setFirstname("firstName");
        admin.setLastname("lastName");
        admin.setEmail("email@mail.com");
        admin.setPassword("password");

        useDao.save(admin);
    }
}
