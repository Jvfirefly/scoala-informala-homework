package ro.sci.teo.ian14;

import java.util.Arrays;
import java.util.Date;

public class VegetalProduct extends Product{
    private String[] vitamins=new String[20];

    public VegetalProduct() {
    }

    public VegetalProduct(String id, String name, double price, String validityDate, double weight, int stock, String[] vitamins) {
        super(id, name, price, validityDate, weight, stock);
        this.vitamins = vitamins;
    }

    public String[] getVitamins() {
        return vitamins;
    }

    public void setVitamins(String[] vitamins) {
        this.vitamins = vitamins;
    }

    @Override
    public String toString() {
        return "VegetalProduct{" +
                "vitamins=" + Arrays.toString(vitamins) +
                "} " + super.toString();
    }
}
