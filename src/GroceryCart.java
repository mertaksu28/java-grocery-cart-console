import java.util.Scanner;
public class GroceryCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] productNames = new String[5];
        double[] productPrices = new double[5];
        int[] productQuantities = new int[5];
        int productCount = 0;

        while (true) {
            System.out.println("\n=== MARKET BASKET MENU ===");
            System.out.println("1- Add Product");
            System.out.println("2- Show Basket");
            System.out.println("3- Search Product");
            System.out.println("4- Quit");
            System.out.print("Please make a selection: ");

            int choose = scanner.nextInt();

            if (choose == 1) {
                scanner.nextLine();
                productCount = addProduct(productNames, productPrices, productQuantities, productCount, scanner);
            } else if (choose == 2) {
                showBasket(productNames, productPrices, productQuantities, productCount);
            } else if (choose == 3) {
                searchProduct(productNames, productPrices, productQuantities, productCount, scanner);
            } else if (choose == 4) {
                System.out.println("Exiting....");
                break;
            } else {
                System.out.println("Invalid selection!");
            }

        }
    }

    public static int addProduct(String[] productNames, double[] productPrices, int[] productQuantities, int productCount, Scanner scanner) {
        if (productCount < 5) {
            System.out.print("Enter the product name: ");
            String productName = scanner.nextLine();
            productName = productName.trim();
            if (!productName.isEmpty()) {
                productName = productName.substring(0, 1).toUpperCase() + productName.substring(1).toLowerCase();
            }
            productNames[productCount] = productName;

            System.out.print("Please enter the product price: ");
            productPrices[productCount] = scanner.nextDouble();
            System.out.print("Enter the product quantity: ");
            productQuantities[productCount] = scanner.nextInt();
            System.out.println("The product has been added successfully....");
            productCount++;
        } else {
            System.out.println("Cart is full!");
        }
        return productCount;
    }

    public static void showBasket(String[] productNames, double[] productPrices, int[] productQuantities, int productCount) {
        if (productCount > 0) {
            System.out.println("===Cart Contents===");

            System.out.printf("%-20s | %12s | %5s | %12s%n",
                    "Product Name", "Price", "Qty", "Total");
            System.out.println("------------------------------------------------------------");

            for (int i = 0; i < productCount; i++) {
                double itemTotal = productPrices[i] * productQuantities[i];

                String displayName = productNames[i];
                if (displayName.length() > 20) {
                    displayName = displayName.substring(0, 17) + "...";
                }

                String priceStr = String.format("%10.2f $", productPrices[i]);
                String totalStr = String.format("%10.2f $", itemTotal);

                System.out.printf("%-20s | %12s | %5d | %12s%n",
                        displayName, priceStr, productQuantities[i], totalStr);
            }
        } else {
            System.out.println("Cart is empty!");
        }
    }

    public static void searchProduct(String[] productNames, double[] productPrices, int[] productQuantities, int productCount, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter the product name you want to search for: ");
        String searchProductName = scanner.nextLine().toLowerCase().trim();

        if (searchProductName.isEmpty()) {
            System.out.println("The search term cannot be empty!");
            return;
        }

        int foundCount = 0;

        for (int i = 0; i < productCount; i++) {
            if (productNames[i].toLowerCase().contains(searchProductName)) {
                System.out.println("\n--- Product Found ---");
                System.out.println("Product Name: " + productNames[i]);
                System.out.println("Price: " + String.format("%.2f $", productPrices[i]));
                System.out.println("Quantity: " + productQuantities[i]);
                System.out.println("Total: " + String.format("%.2f $", productPrices[i] * productQuantities[i]));
                foundCount++;
            }
        }

        if (foundCount == 0) {
            System.out.println("Product not found!!");
        } else {
            System.out.println("\nTotal " + foundCount + " The product was found..");
        }
    }
}


