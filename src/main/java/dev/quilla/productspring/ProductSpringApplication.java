package dev.quilla.productspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductSpringApplication.class, args);

        List<Product> products = service.getAllProducts();
        for(Product p : products) {
            System.out.println(p);
        }
    }

}
