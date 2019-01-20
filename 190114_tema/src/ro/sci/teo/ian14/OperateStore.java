package ro.sci.teo.ian14;

import java.util.List;

/**
 * The store´s interface.
 * <p>The doc comments for each method can be found in OperateStoreImpl.java.</p>
 *
 * @author Teo
 */
public interface OperateStore {
    void addAnimalProdsFromFileToStock(List<Item> stock);
    void addVeggiesFromFileToStock(List<Item> stock);
    void addOrdersFromFile(List<Order> orders);

    void addAnimalProdToStock(List<Item> stock);
    void addVeggieToStock(List<Item> stock);

    void addOrder(String productId, float qty, List<Order> orders);
    void updateStock(String productId, float qty, List<Item> stock);
}
