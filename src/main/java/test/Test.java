package test;

import com.mypack.controller.AuthController;
import com.mypack.entity.Admin;
import com.mypack.service.AuthService;
import com.mypack.service.ProductService;

public class Test {
    public static void main(String[] args) {
        System.out.println(new ProductService().updateProductDelivery(1));

    }
}