package com.example.controllers;

import java.util.List;

import com.example.models.Product;
import com.example.models.ProductSource;
import com.example.models.Sqlite;
import com.example.views.MainView;

public class MainController {
    ProductSource productSource = new ProductSource(new Sqlite());
    public void start() {
        List<Product> productList = productSource.index();
        MainView mainView = new MainView();
        mainView.showProducts(productList);
    }
}
