package com.restaurantmanager.controller;
import java.util.List;

import com.restaurantmanager.model.MenuItem;

public class MenuItemController {
    private List<MenuItem> menu;

    public MenuItemController(List<MenuItem> menu) {
        this.menu = menu;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public void addMenuItem(MenuItem item) {
        this.menu.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        this.menu.remove(item);
    }

    public void printMenuItems() {
        System.out.println("##### MENU #####");
        for (MenuItem item : menu) {    
            System.out.println(String.format("%d. %s : %s : %.2f", 
                item.getId(), 
                item.getName(), 
                item.getDescription(), 
                item.getPrice()));
        }
        System.out.println("################");
    }

    public MenuItem findById(int id) {
        for (MenuItem item : menu) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
