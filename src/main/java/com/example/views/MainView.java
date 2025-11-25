package com.example.views;

import java.util.List;

import com.example.models.Product;

public class MainView {
    public void showProducts(List<Product> productList) {
        System.out.printf(
            "%3s%10s%10s%10s\n",
            "Id", "Név", "Ár", "Mennyiség"
        );
        productList.forEach((product) -> {
            System.out.printf("%3d %10s %6.2f %4d\n",
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity()
            );
        });
    }
}
