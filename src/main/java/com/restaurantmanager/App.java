package com.restaurantmanager;

import com.restaurantmanager.view.MainView;

public class App {
    private final MainView mainView = new MainView();

    public static void main(String[] args) {
        new App().mainView.run();
    }
}