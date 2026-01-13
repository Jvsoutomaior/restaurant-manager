package com.souto.controller;

import com.souto.model.MenuItem;
import com.souto.model.MenuItemType;

// functions of this class,
// 1. have the menuItemController and OrderController
// 2. Put dishes in the menuItemController
// create menuItem and add to menuItemController
public class SystemController {
    private final MenuItemController menuItemController;
    private final OrderController orderController;
    
    public MenuItemController getMenuController() {
        return menuItemController;
    }

    public OrderController getOrderController(){
        return orderController;
    }

    public SystemController(){
        menuItemController = new MenuItemController(new java.util.ArrayList<>());
        orderController = new OrderController();

        MenuItem menuItem1 = new MenuItem("Pães", (float) 17.90, "Cesta de pães", MenuItemType.STARTER);
        MenuItem menuItem2 = new MenuItem("Salada Caesar", (float) 29.90, "Alface americana, croutons, parmesão e molho caesar", MenuItemType.STARTER);
        MenuItem menuItem3 = new MenuItem("Lasanha Bolonhesa", (float) 45.90, "Lasanha com molho bolonhesa e queijo gratinado", MenuItemType.MAIN);
        MenuItem menuItem4 = new MenuItem("Risoto de Camarão", (float) 59.90, "Risoto com camarões frescos e ervas finas", MenuItemType.MAIN);
        MenuItem menuItem5 = new MenuItem("Refrigerante", (float) 8.90, "Lata de refrigerante 350ml", MenuItemType.DRINK);
        MenuItem menuItem6 = new MenuItem("Suco Natural", (float) 12.90, "Copo de suco natural 300ml", MenuItemType.DRINK);
        MenuItem menuItem7 = new MenuItem("Pudim de Leite", (float) 15.90, "Pudim de leite condensado com calda de caramelo", MenuItemType.DESSERT);
        MenuItem menuItem8 = new MenuItem("Brownie com Sorvete", (float) 18.90, "Brownie quente com sorvete de creme", MenuItemType.DESSERT);
        MenuItem menuItem9 = new MenuItem("Nuggets", (float) 22.90, "Nuggets de frango com batata frita", MenuItemType.KIDS);
        MenuItem menuItem10 = new MenuItem("Macarrão com Almôndegas", (float) 25.90, "Macarrão ao molho de tomate com almôndegas", MenuItemType.KIDS);

        menuItemController.addMenuItem(menuItem1);
        menuItemController.addMenuItem(menuItem2);
        menuItemController.addMenuItem(menuItem3);
        menuItemController.addMenuItem(menuItem4);
        menuItemController.addMenuItem(menuItem5);
        menuItemController.addMenuItem(menuItem6);
        menuItemController.addMenuItem(menuItem7);
        menuItemController.addMenuItem(menuItem8);
        menuItemController.addMenuItem(menuItem9);
        menuItemController.addMenuItem(menuItem10);

    }

}
