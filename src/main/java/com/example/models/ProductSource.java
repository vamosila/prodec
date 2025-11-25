package com.example.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductSource implements DataAccessible<Product> {
    Database database;
    public ProductSource(Database database) {
        this.database = database;
    }

    @Override
    public List<Product> index() {
        try {
            return tryIndex();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    private List<Product> tryIndex() throws SQLException {
        Connection conn = database.connect();
        String sql = "select * from products";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Product> products = new ArrayList<>();
        while(rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setQuantity(rs.getInt("quantity"));
            product.setDescription(rs.getString("description"));
            products.add(product);
        }
        return products;
    }

    @Override
    public void store(Product data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'store'");
    }

    @Override
    public void update(Product data, int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void destroy(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }
    
}
