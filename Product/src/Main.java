//filename: Main.java
//author: kultaran singh
//date: 19/06/2024
//description: this code file validates the product class by developing examples and also prints them.


public class Main {
    public static void main(String[] args) {
        try {
            Product product1 = new Product(
                    "9417993664",
                    "Apple",
                    1.5,
                    2.0,
                    500,
                    100,
                    "none but eat with caution"
            );
            Product product2 = new Product(
                    "9814871057",
                    "Banana",
                    2.2,
                    2.5,
                    250,
                    75,
                    "it is the favourite fruit of monkeys"
            );

            System.out.println(product1);
            System.out.println("----------------------------");
            System.out.println(product2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
