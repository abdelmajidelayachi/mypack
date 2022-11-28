package test;

import com.mypack.entity.Admin;
import com.mypack.util.SoutError;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypack");
        EntityManager entityManager = emf.createEntityManager();
        try {
            //        String email = "user@gmail.com";
            //        String password = "user0029+0";
            entityManager.getTransaction().begin();

            Admin admin = new Admin();

            admin.setFirstname("yyy");
            admin.setLastname("yyy");
            admin.setEmail("yyy@gmail.com");
            admin.setPassword("yyy");

            //        BaseDAOImpl<Admin> adminBaseDAO = new BaseDAOImpl<>(Admin.class);
            entityManager.persist(admin);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            SoutError.print("blue", e.getMessage());
        }
    }
}
