package com.mypack.service;

import com.mypack.dao.BaseDAOImpl;
import com.mypack.entity.Driver;
import com.mypack.util.SoutError;

import java.util.List;

public class ManagerService {
    BaseDAOImpl<Driver> useDao = new BaseDAOImpl<>(Driver.class);

    public List<Driver> getAllDrivers() {
        try {
            return useDao.getAll();
        }catch (Exception e)
        {
            SoutError.print("orange", e.getMessage());
            return null;
        }
    }

    public Driver getDriverById(int id) {
        try {
            List<Driver> drivers = useDao.getAllWhere("id", id);
            return drivers.get(0);
        } catch (Exception e) {
            SoutError.print("orange", e.getMessage());
            return null;
        }
    }

    public boolean deleteDriver(int id) {
        try {
            useDao.delete(id);
            return true;
        } catch (Exception e) {
            SoutError.print("orange", e.getMessage());
            return false;
        }
    }

    public boolean addDriver(int center_id,String email,String firstname,String lastname,String password) {
        try {
            Driver driver = new Driver();
            driver.setCenter_id(center_id);
            driver.setEmail(email);
            driver.setFirstname(firstname);
            driver.setLastname(lastname);
            driver.setPassword(password);
            useDao.save(driver);
            return true;
        } catch (Exception e) {
            SoutError.print("orange", e.getMessage());
            return false;
        }
    }

    public boolean updateDriver(int id,int center_id,String email,String firstname,String lastname,String password) {
        try {
            Driver driver = useDao.findById(id);
            driver.setCenter_id(center_id);
            driver.setEmail(email);
            driver.setFirstname(firstname);
            driver.setLastname(lastname);
            driver.setPassword(password);
            useDao.update(driver);
            return true;
        } catch (Exception e) {
            SoutError.print("orange", e.getMessage());
            return false;
        }
    }
}
