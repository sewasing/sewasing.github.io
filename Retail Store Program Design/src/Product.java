// File name: Product.java
// Author: kultaran singh
// Date: 26/07/2024
// Description: The product class defines a product with various properties such as SKU, name, cost, price, quantity, and special instructions.

public class Product {
    private String sku;
    private String name;
    private double unitCost;
    private double salePrice;
    private int quantity;
    private int quantityNeeded;
    private String specialInstructions;

    // this is a default constructor that has meaningful default values
    public Product() {
        this.sku = "12345678";
        this.name = " ABC Product";
        this.unitCost = 0.0;
        this.salePrice = 0.0;
        this.quantity = 0;
        this.quantityNeeded = 0;
        this.specialInstructions = "ABC";
    }

    // constructor parameters along with validation
    public Product(String sku, String name, double unitCost, double salePrice, int quantity, int quantityNeeded, String specialInstructions) {
        setSku(sku);
        setName(name);
        setUnitCost(unitCost);
        setSalePrice(salePrice);
        setQuantity(quantity);
        setQuantityNeeded(quantityNeeded);
        this.specialInstructions = specialInstructions;
    }

    // getters and setters with validation
    public String getSku() {
        return sku;
    }

    public final void setSku(String sku) {
        if (sku != null && sku.matches("\\d{8,}")) {
            this.sku = sku;
        } else {
            throw new IllegalArgumentException("SKU should be at least 8 digits. ");
        }
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("name should not be blank.");
        }
    }

    public double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) {
        if (unitCost >= 0) {
            this.unitCost = unitCost;
        } else {
            throw new IllegalArgumentException("unit cost can not be negative.");
        }
    }

    public double getSalePrice() {
        return salePrice;
    }

    public final void setSalePrice(double salePrice) {
        if (salePrice >= 0) {
            this.salePrice = salePrice;
        } else {
            throw new IllegalArgumentException("sale price can not be negative.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("quantity can not be negative.");
        }
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    public final void setQuantityNeeded(int quantityNeeded) {
        if (quantityNeeded >= 0) {
            this.quantityNeeded = quantityNeeded;
        } else {
            throw new IllegalArgumentException("quantity needed can not be negative.");
        }
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    // this is a display function in order to show the product details
    @Override
    public String toString() {
        return "SKU: " + sku + "\n" +
                "Product Name: " + name + "\n" +
                "Unit Cost: $" + unitCost + "\n" +
                "Sale Price: $" + salePrice + "\n" +
                "Quantity on hand: " + quantity + "\n" +
                "Quantity Needed: " + quantityNeeded + "\n" +
                "Special Instructions: " + specialInstructions + "\n";
    }
}
