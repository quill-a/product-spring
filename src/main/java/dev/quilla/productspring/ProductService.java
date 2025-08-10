package dev.quilla.productspring;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {

        db.save(p);
    }

    public List<Product> getAllProducts() {
        return db.getAll();
    }

    public Product getProduct(String name) {
        for(Product p : products) {
            if(p.getName().equals(name)) return p;
        }

        return null;
    }

//    public List<Product> getProductWithText(String text) {
//
//        String str = text.toLowerCase();
//        List<Product> products = new ArrayList<>();
//
//        for(Product p : products) {
//
//            String name = p.getName().toLowerCase();
//            String type = p.getType().toLowerCase();
//            String place = p.getPlace().toLowerCase();
//
//            if(name.contains(str) || type.contains(str) || place.contains(str)) products.add(p);
//        }
//
//        return products;
//    }
}
