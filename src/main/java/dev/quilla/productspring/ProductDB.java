package dev.quilla.productspring;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection connection = null;

    public ProductDB() throws SQLException {

        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
    }

    public void save(Product product) throws SQLException {

        String query =  "INSERT INTO products (name, type, place, warranty) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getType());
        preparedStatement.setString(3, product.getPlace());
        preparedStatement.setInt(4, product.getWarranty());
        preparedStatement.execute();
    }

    public List<Product> getAll() throws SQLException {

        List<Product> productList = new ArrayList<>();
        String query =  "SELECT name, type, place, warranty FROM products";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            Product product = new Product();
            product.setName(resultSet.getString("name"));
            product.setType(resultSet.getString("type"));
            product.setPlace(resultSet.getString("place"));
            product.setWarranty(resultSet.getInt("warranty"));
            productList.add(product);
        }
    }
}
