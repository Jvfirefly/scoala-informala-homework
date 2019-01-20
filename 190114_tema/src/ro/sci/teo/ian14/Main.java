package ro.sci.teo.ian14;

import java.util.*;

/**
 * This is the main class, where all the program parts are put together.
 *
 * @author Teo
 */
public class Main {
    public static void main(String[] args) {
        //QUESTIONS:
        //How do i make the product´s id unique? I considered it unique by default.
        //How would you use an interface here?

        OperateStore operateStore = new OperateStoreImpl();
        //Here I populate the store.
        List<Item> stock = new ArrayList<>();
        operateStore.addAnimalProdsFromFileToStock(stock);
        operateStore.addVeggiesFromFileToStock(stock);
        //Here I populate the orders list.
        List<Order> orders = new ArrayList<>();
        operateStore.addOrdersFromFile(orders);

        System.out.println("-----------------------------------------------");
        System.out.println("1. Create product and add it to stock (press 1)");
        System.out.println("2. Sell product (press 2)");
        System.out.println("3. Display daily sales report (press 3)");
        System.out.println("4. Exit (press 4)");
        System.out.print("\nChose an option: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("-----------------------------------------------");

        boolean exit = false;
        while (!exit) {
            switch (n) {
                case 1:
                    //create a product and add it to stock
                    System.out.print("Product type (1 - animal; 2 - vegetable): ");
                    int prodType = sc.nextInt();
                    System.out.println("-----------------------------------------------");
                    if (prodType == 1)
                        operateStore.addAnimalProdToStock(stock);
                    else if (prodType == 2)
                        operateStore.addVeggieToStock(stock);
                    else
                        System.out.println("Error: Only 1 or 2 were possible options!");
                    break;
                case 2:
                    //sell product
                    System.out.println("Here is the list of products we have in stock:");
                    System.out.println("-----------------------------------------------");
                    for (Item item : stock)
                        System.out.println(item);
                    System.out.print("Insert the id of the product you´ve chosen: ");
                    String productId = sc.next();
                    System.out.print("Input the quantity you want to order:");
                    float qty = sc.nextFloat();
                    if (orderIsValid(productId, qty, stock)) {
                        operateStore.addOrder(productId, qty, orders);
                        operateStore.updateStock(productId, qty, stock);
                    } else
                        System.out.println("We are sorry. This isn´t a valid order.");
                    break;
                case 3:
                    //sales report form a specific date
                    System.out.print("Input a specific date (format: yyyy-MM-dd): ");
                    String date = sc.next();
                    boolean orderExists = false;
                    for (Order order : orders)
                        if (date.equals(order.getOrderDate())) {
                            System.out.println(order);
                            orderExists = true;
                        }
                    if (!orderExists)
                        System.out.println("There were no orders placed on this date or you´ve entered the date in a " +
                                "wrong format.");
                    break;
                case 4:
                    //Exit
                    exit = true;
                    System.out.println("Have a nice day!");
                    break;
                default:
                    // code to be executed if n doesn't match any constant
                    System.out.println("You should have entered a number between 1 and 4.");
            }
            if (!exit) {
                System.out.println("What would you like to do next? (press 1,2,3 or 4 - exit)");
                n = sc.nextInt();
            }

        }
    }

    /**
     * This method checks if the user´s order is valid.
     * @param productId id of the product to be added to the order
     * @param qty       quantity of the product the user wants to order
     * @param stock     list of items available in the store
     * @return boolean  This returns true if the order is valid and false if not.
     */
    private static boolean orderIsValid(String productId, float qty, List<Item> stock) {
        for (Item item : stock)
            if (productId.equals(item.getProduct().getId()) && qty == item.getStockNumber())
                return true;
        return false;
    }
}
