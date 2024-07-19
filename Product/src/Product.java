//filename: Product.java
//author: kultaran singh
//date: 19/06/2024
//description: this code file contains the class that defines a product
// with different properties and methods to reach and change them.

public class Product {
    private String SKU;
    private String productName;
    private double unitCost;
    private double salePrice;
    private int quantity;
    private int quantityNeeded;
    private String specialInstructions;

    public Product() {
        this.SKU = "00000000";
        this.productName = "Default Product";
        this.unitCost = 0.0;
        this.salePrice = 0.0;
        this.quantity = 0;
        this.quantityNeeded = 0;
        this.specialInstructions = "None";
    }

    public Product(String SKU, String productName, double unitCost, double salePrice, int quantity, int quantityNeeded, String specialInstructions) {
        setSKU(SKU);
        setProductName(productName);
        setUnitCost(unitCost);
        setSalePrice(salePrice);
        setQuantity(quantity);
        setQuantityNeeded(quantityNeeded);
        this.specialInstructions = specialInstructions;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        if (SKU.matches("\\d{8,}")) {
            this.SKU = SKU;
        } else {
            throw new IllegalArgumentException("SKU must be at least 8 digits.");
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (!productName.isBlank()) {
            this.productName = productName;
        } else {
            throw new IllegalArgumentException("Product name cannot be blank.");
        }
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        if (unitCost >= 0) {
            this.unitCost = unitCost;
        } else {
            throw new IllegalArgumentException("Unit cost must be >= 0.");
        }
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        if (salePrice >= 0) {
            this.salePrice = salePrice;
        } else {
            throw new IllegalArgumentException("Sale price must be >= 0.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity must be >= 0.");
        }
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(int quantityNeeded) {
        if (quantityNeeded >= 0) {
            this.quantityNeeded = quantityNeeded;
        } else {
            throw new IllegalArgumentException("Quantity needed must be >= 0.");
        }
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    @Override
    public String toString() {
        return "SKU: " + SKU + "\n" +
                "Product Name: " + productName + "\n" +
                "Unit Cost: $" + unitCost + "\n" +
                "Sale Price: $" + salePrice + "\n" +
                "Quantity on hand: " + quantity + "\n" +
                "Quantity Needed: " + quantityNeeded + "\n" +
                "Special Instructions: " + specialInstructions;
    }
}
