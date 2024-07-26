// File name: Main.java
// Author: kultaran singh
// Date: 26/07/2024
// Description: this is the Main class to run the retail store program. It allows the users to create, edit, delete, and display the products
// that are stored in the product list.

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    // this is a list to store all the products
    private static final ArrayList<Product> productList = new ArrayList<>();
    // scanner for user input
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = getUserChoice(); // display the main menu

            switch (choice) {
                case 1:
                    createProduct(); // create new product
                    break;
                case 2:
                    createPerishableProduct(); // create new perishable product
                    break;
                case 3:
                    editProductBySku(); // edit the existing product by SKU
                    break;
                case 4:
                    deleteProductBySku(); // delete the product SKU
                    break;
                case 5:
                    displayProductBySku(); // display the  details of product by SKU
                    break;
                case 6:
                    displayAllProducts(); // display the details of all the products by SKU
                    break;
                case 7:
                    System.out.println("Closing the code"); // exit the code
                    break;
                default:
                    System.out.println("The choice is invalid. Please try again."); // for the invalid inputs
            }
        } while (choice != 7); // continue with the input prompt until the user chooses to exit

        scanner.close(); // close the scanner
    }
// display the main options to the user
    private static void displayMenu() {
        System.out.println("1) Create Product");
        System.out.println("2) Create Perishable Product");
        System.out.println("3) Edit Product by SKU");
        System.out.println("4) Delete Product by SKU");
        System.out.println("5) Display Product by SKU");
        System.out.println("6) Display all Products");
        System.out.println("7) Exit");
        System.out.print("Enter your choice: ");
    }
// get the user input and validate it
    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("The input is invalid. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
// create a new product as per the user input and add it to the product list
    private static void createProduct() {
        try {
            scanner.nextLine();
            System.out.print("Enter SKU: ");
            String sku = scanner.nextLine();
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();
            double unitCost = getValidatedDouble("Enter unit cost: ");
            double salePrice = getValidatedDouble("Enter sale price: ");
            int quantity = getValidatedInt("Enter quantity: ");
            int quantityNeeded = getValidatedInt("Enter quantity needed: ");
            System.out.print("Enter special instructions: ");
            String specialInstructions = scanner.nextLine();

            Product product = new Product(sku, name, unitCost, salePrice, quantity, quantityNeeded, specialInstructions);
            productList.add(product);
            System.out.println("the product has been created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
// create a new perishable product as per the user input and add it to the product list
    private static void createPerishableProduct() {
        try {
            scanner.nextLine(); // Consume newline left-over
            System.out.print("Enter SKU: ");
            String sku = scanner.nextLine();
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();
            double unitCost = getValidatedDouble("Enter unit cost: ");
            double salePrice = getValidatedDouble("Enter sale price: ");
            int quantity = getValidatedInt("Enter quantity: ");
            int quantityNeeded = getValidatedInt("Enter quantity needed: ");
            System.out.print("Enter special instructions: ");
            String specialInstructions = scanner.nextLine();
            System.out.print("Enter expiry date (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);

            PerishableProduct perishableProduct = new PerishableProduct(sku, name, unitCost, salePrice, quantity, quantityNeeded, specialInstructions, expiryDate);
            productList.add(perishableProduct);
            System.out.println("the perishable product has been created successfully.");
        } catch (IllegalArgumentException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
// ask the user for the SKU and edit the details of that product as per the new details provided by the user.
    private static void editProductBySku() {
        System.out.print("Enter SKU: ");
        String sku = scanner.next();
        scanner.nextLine();

        for (Product product : productList) {
            if (product.getSku().equals(sku)) {
                try { // prompt the user for new values and update them.
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    double unitCost = getValidatedDouble("Enter new unit cost: ");
                    double salePrice = getValidatedDouble("Enter new sale price: ");
                    int quantity = getValidatedInt("Enter new quantity: ");
                    int quantityNeeded = getValidatedInt("Enter new quantity needed: ");
                    System.out.print("Enter new special instructions: ");
                    String specialInstructions = scanner.nextLine();

                    product.setName(name);
                    product.setUnitCost(unitCost);
                    product.setSalePrice(salePrice);
                    product.setQuantity(quantity);
                    product.setQuantityNeeded(quantityNeeded);
                    product.setSpecialInstructions(specialInstructions);

                    System.out.println("the product has been updated successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Product with SKU " + sku + " was not found.");
    }
// it deletes a product by SKU
    private static void deleteProductBySku() {
        System.out.print("Enter SKU: ");
        String sku = scanner.next();
        scanner.nextLine();

        for (Product product : productList) {
            if (product.getSku().equals(sku)) {
                productList.remove(product);
                System.out.println("the product has been deleted successfully.");
                return;
            }
        }
        System.out.println("the product with SKU " + sku + " was not found.");
    }
// it displays the details of the product by SKU
    private static void displayProductBySku() {
        System.out.print("Enter SKU: ");
        String sku = scanner.next();
        scanner.nextLine();

        for (Product product : productList) {
            if (product.getSku().equals(sku)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("the product with SKU " + sku + " was not found.");
    }
// it displays the details of all the products mentioned in the product list
    private static void displayAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("there are no products available.");
        } else {
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }
// it  validates the inputs provided by the user
    private static double getValidatedDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                if (value >= 0) {
                    scanner.nextLine();
                    return value;
                } else {
                    System.out.println("please enter a valid input. the number must be positive.");
                }
            } else {
                System.out.println("the input is invalid. please enter a valid number.");
                scanner.next();
            }
        }
    }

    private static int getValidatedInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= 0) {
                    scanner.nextLine();
                    return value;
                } else {
                    System.out.println("please enter a valid input. the number must be positive.");
                }
            } else {
                System.out.println("the input is invalid. please enter a valid number.");
                scanner.next();
            }
        }
    }
}
