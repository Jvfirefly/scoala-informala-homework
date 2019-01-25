package ro.sci.teo.ian14;

import java.util.*;

/**
 * This class represents a vegetable product.
 *
 * @author Teo
 */
public class VegetalProduct extends Product{
    private List<String> vitamins = new ArrayList<>();

    public VegetalProduct() {
    }

    public VegetalProduct(String id, String name, double price, String validityDate, double weight, List<String> vitamins) {
        super(id, name, price, validityDate, weight);
        this.vitamins = vitamins;
    }

    public List<String> getVitamins() {
        return vitamins;
    }

    public void setVitamins(List<String> vitamins) {
        this.vitamins = vitamins;
    }

    @Override
    public String toString() {
        return "VegetalProduct{" +
                "vitamins=" + vitamins +
                "} " + super.toString();
    }
}
