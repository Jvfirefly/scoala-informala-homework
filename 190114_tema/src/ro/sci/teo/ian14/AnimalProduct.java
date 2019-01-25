package ro.sci.teo.ian14;

/**
 * This class represents an animal product.
 *
 * @author Teo
 */
public class AnimalProduct extends Product {
    private int storageTemp;

    public AnimalProduct() {
    }

    public AnimalProduct(String id, String name, double price, String validityDate, double weight, int storageTemp) {
        super(id, name, price, validityDate, weight);
        this.storageTemp = storageTemp;
    }

    public int getStorageTemp() {
        return storageTemp;
    }

    public void setStorageTemp(int storageTemp) {
        this.storageTemp = storageTemp;
    }

    @Override
    public String toString() {
        return "AnimalProduct{" +
                "storageTemp=" + storageTemp +
                "} " + super.toString();
    }
}
