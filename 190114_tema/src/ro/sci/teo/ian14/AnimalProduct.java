package ro.sci.teo.ian14;

import java.util.Date;

public class AnimalProduct extends Product {
    private int storageTemp;

    public AnimalProduct() {
    }

    public AnimalProduct(String id, String name, double price, String validityDate, double weight, int stock, int storageTemp) {
        super(id, name, price, validityDate, weight, stock);
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
