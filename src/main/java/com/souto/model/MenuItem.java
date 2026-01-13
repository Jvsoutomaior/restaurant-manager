package com.souto.model;

public class MenuItem{
    private static int nextId = 0;
    private final int id;
    private String name;
    private float price;
    private String description;
    private MenuItemType itemType;
    

    public MenuItem(String name, float price, String description, MenuItemType itemType){
        this.id = ++nextId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float setPrice(float price) {
        this.price = price;
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription(String description) {
        this.description = description;
        return description;
    }

    public MenuItemType getItemType() {
        return itemType;
    }

    public MenuItemType setItemType(MenuItemType itemType) {
        this.itemType = itemType;
        return itemType;
    }
}
