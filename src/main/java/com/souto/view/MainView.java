package com.souto.view;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.souto.controller.SystemController;
import com.souto.model.MenuItem;
import com.souto.model.Order;
import com.souto.model.OrderItem;

public class MainView {
    private final SystemController systemController = new SystemController();
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public MainView() {
        
    }

    public void run() {
        while(running){
            printCli();
            int option;
            
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }
            
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1: // See Menu
                    systemController.getMenuController().printMenuItems();
                    break;
                
                case 2: // Make Order
                    makeNewOrder();
                    break;
                    
                case 3: // See Orders
                    systemController.getOrderController().printAllOrders();
                    break;
                    
                case 4: // Exit
                    System.out.println("Exiting system...");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
        scanner.close();
    }

    private void printCli(){
        System.out.println("-------------");
        System.out.println("1. See Menu");
        System.out.println("2. Make Order");
        System.out.println("3. See Orders");
        System.out.println("4. Exit");
        System.out.println("-------------");
    }

    private void makeNewOrder(){
        Order newOrder = systemController.getOrderController().createNewOrder();
        boolean addingItems = true;
        
        while(addingItems){
            int dishId;
            int quantity;
            int nextOption = 1;
            
            systemController.getMenuController().printMenuItems();
            
            System.out.print("\nChoose dish ID: ");
            try {
                dishId = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }
            scanner.nextLine(); // Consume newline
            
            MenuItem menuItem = systemController.getMenuController().findById(dishId);
            
            System.out.print("Choose quantity: ");
            try{
                quantity = scanner.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine(); // Consume newline

            OrderItem orderItem = new OrderItem(menuItem, quantity);
            systemController.getOrderController().addItemToOrder(newOrder, orderItem);
            
            System.out.println(String.format("Added %dx %s to order", quantity, menuItem.getName()));
            
            System.out.print("\nAdd another item? (1:yes 2:no): ");
            try{
                nextOption = scanner.nextInt();
            } catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine(); // Consume newline
            
            if(nextOption != 1) {
                addingItems = false;
            }
        }
        
        if(newOrder.getItems().isEmpty()) {
            System.out.println("\nOrder cancelled - no items added.");
            systemController.getOrderController().getOrders().remove(newOrder);
        } else {
            System.out.println(String.format("\nOrder created successfully!"));
            System.out.println(String.format("Total: $%.2f\n", newOrder.getTotalPrice()));
        }
    }
}