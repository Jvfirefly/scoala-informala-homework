package ro.sci.teo.ian14;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * This class implements the methods in OperateStore.java.
 *
 * @author Teo
 */
public class OperateStoreImpl implements OperateStore {
    /**
     * This method adds some items of the type AnimalProduct from the file AnimalProdsWithStockNr.txt
     * into the stock list.
     * @param stock list of items available in the store
     */
    @Override
    public void addAnimalProdsFromFileToStock(List<Item> stock) {
        File AnimalProdsFile = new File("C:\\Users\\Teodora\\IdeaProjects\\scoala-informala-homework" +
                "\\190114_tema\\src\\ro\\sci\\teo\\ian14\\AnimalProdsWithStockNr.txt");
        try {
            // Create a new Scanner object which will read the data
            // from the file passed in. To check if there are more
            // lines to read from it we check by calling the
            // scanner.hasNextLine() method. We then read line one
            // by one till all lines are read.
            Scanner sc = new Scanner(AnimalProdsFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] slice = line.split("\\s");
                Product p = new AnimalProduct();
                p.setId(slice[0]);
                p.setName(slice[1]);
                p.setPrice(Double.parseDouble(slice[2]));
                p.setValidityDate(slice[3]);
                p.setWeight(Double.parseDouble(slice[4]));
                ((AnimalProduct) p).setStorageTemp(Integer.parseInt(slice[5]));

                stock.add(new Item(p, Integer.parseInt(slice[slice.length - 1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see public void addAnimalProdsFromFileToStock(List<Item>stock) {...} - similar method
     */
    @Override
    public void addVeggiesFromFileToStock(List<Item> stock) {
        File VeggiesFile = new File("C:\\Users\\Teodora\\IdeaProjects\\scoala-informala-homework" +
                "\\190114_tema\\src\\ro\\sci\\teo\\ian14\\VeggiesWithStockNr.txt");
        try {
            Scanner sc = new Scanner(VeggiesFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] slice = line.split("\\s"); //splits String based on whitespace
                Product p = new VegetalProduct();
                p.setId(slice[0]);
                p.setName(slice[1]);
                p.setPrice(Double.parseDouble(slice[2]));
                p.setValidityDate(slice[3]);
                p.setWeight(Double.parseDouble(slice[4]));
                List<String> vitaminList = new ArrayList<>();
                for (int i = 5; i < slice.length - 1; i++)
                    vitaminList.add(slice[i]);
                ((VegetalProduct) p).setVitamins(vitaminList);

                stock.add(new Item(p, Integer.parseInt(slice[slice.length - 1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method adds some orders from the file Orders.txt into the orders list.
     * @param orders list of orders
     */
    @Override
    public void addOrdersFromFile(List<Order> orders) {
        File OrdersFile = new File("C:\\Users\\Teodora\\IdeaProjects\\scoala-informala-homework" +
                "\\190114_tema\\src\\ro\\sci\\teo\\ian14\\Orders.txt");
        try {
            Scanner sc = new Scanner(OrdersFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] slice = line.split("\\s"); //splits String based on whitespace
                Order order = new Order();
                order.setOrderDate(slice[0]);
                order.setProductID(slice[1]);
                order.setQuantity(Float.parseFloat(slice[2]));
                orders.add(order);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method adds an animal product into the stock.
     * The required values are read from keyboard.
     * @param stock list of items available in the store
     */
    @Override
    public void addAnimalProdToStock(List<Item> stock) {
        Scanner sc = new Scanner(System.in);
        Product p = new VegetalProduct();
        System.out.println("Input the following data related to the product:");
        System.out.print("id: ");
        p.setId(sc.next());
        System.out.print("name: ");
        p.setName(sc.next());
        System.out.print("price: ");
        p.setPrice(sc.nextDouble());
        System.out.print("validity date (format: yyyy-MM-dd): ");
        p.setValidityDate(sc.next());
        System.out.print("weight: ");
        p.setWeight(sc.nextDouble());
        List<String> vitaminList = new ArrayList<>();
        System.out.println("How many vitamins has this product?");
        int vitaminNumber = sc.nextInt();
        System.out.print("Please insert the vitamins (each followed by an ENTER): ");
        for (int i = 0; i < vitaminNumber; i++)
            vitaminList.add(sc.next());
        ((VegetalProduct) p).setVitamins(vitaminList);
        System.out.print("stock_number: ");
        stock.add(new Item(p, sc.nextInt()));
    }

    /**
     *
     * @see public void addAnimalProdToStock(List<Item> stock) {...} - similar method
     */
    @Override
    public void addVeggieToStock(List<Item> stock) {
        Scanner sc = new Scanner(System.in);
        Product p = new AnimalProduct();
        System.out.println("Input the following data related to the product:");
        System.out.print("id: ");
        p.setId(sc.next());
        System.out.print("name: ");
        p.setName(sc.next());
        System.out.print("price: ");
        p.setPrice(sc.nextDouble());
        System.out.print("validity date (format: yyyy-MM-dd): ");
        p.setValidityDate(sc.next());
        System.out.print("weight: ");
        p.setWeight(sc.nextDouble());
        System.out.print("storage temperature: ");
        ((AnimalProduct) p).setStorageTemp(sc.nextInt());
        System.out.print("stock_number: ");
        stock.add(new Item(p, sc.nextInt()));
    }

    /**
     * This method adds an order into the orders list.
     * @param productId id of the product to be added to the order
     * @param qty       quantity of the product the user wants to order
     * @param orders    list of orders
     */
    @Override
    public void addOrder(String productId, float qty, List<Order> orders) {
        Order order = new Order();
        order.setOrderDate(new SimpleDateFormat("YYYY-MM-dd").format(new Date())); //date taken from PC´s date
        order.setProductID(productId);
        order.setQuantity(qty);
        orders.add(order);
        System.out.println("Your order was successfully submitted.");
    }

    /**
     * This method updates the stock after the user placed an order.
     * @param productId id of the product to be added to the order
     * @param qty       quantity of the product the user wants to order
     * @param stock     list of items available in the store
     */
    @Override
    public void updateStock(String productId, float qty, List<Item> stock) {
        for (Item item : stock)
            if (productId.equals(item.getProduct().getId()))
                item.setStockNumber(item.getStockNumber() - qty);
    }
}
