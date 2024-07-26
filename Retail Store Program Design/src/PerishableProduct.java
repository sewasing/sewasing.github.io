// File name: PerishableProduct.java
// Author: kultaran singh
// Date: 26/07/2024
// Description: The perishable product class defines a perishable product by extending the product class with another property of expiry date.

import java.util.Date;

public class PerishableProduct extends Product {
    private Date expiryDate;

    // this is a default constructor with a meaningful default value
    public PerishableProduct() {
        super();
        this.expiryDate = new Date();
    }

    // constructor parameter along with validation
    public PerishableProduct(String sku, String name, double unitCost, double salePrice, int quantity, int quantityNeeded, String specialInstructions, Date expiryDate) {
        super(sku, name, unitCost, salePrice, quantity, quantityNeeded, specialInstructions);
        this.expiryDate = expiryDate;
    }

    // getter and setter for expiry date
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    // this is a display function to show perishable product details along with the expiry date
    @Override
    public String toString() {
        return super.toString() +
                "Expiry Date: " + expiryDate + "\n";
    }
}
