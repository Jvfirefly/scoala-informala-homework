package ro.sci.teo.ian14;

/**
 * This class represents an item available in the store.
 *
 * @author Teo
*/
public class Item {
    private Product product;
    private float stockNumber; //e.g. 20.30 kg of rice

    public Item() {
    }

    public Item(Product product, float stockNumber) {
        this.product = product;
        this.stockNumber = stockNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(float stockNumber) {
        this.stockNumber = stockNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", stockNumber=" + stockNumber +
                '}';
    }
}
