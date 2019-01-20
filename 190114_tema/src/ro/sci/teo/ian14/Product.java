package ro.sci.teo.ian14;

/**
 * The purpose of this class is to hold the common representation of AnimalProduct.java and of VegetalProduct.java.
 *
 * @author Teo
 */
public class Product {
    private String id;
    private String name;
    private double price;
    private String validityDate;
    private double weight;

    public Product() {
    }

    public Product(String id, String name, double price, String validityDate, double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.validityDate = validityDate;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", validityDate=" + validityDate +
                ", weight=" + weight +
                '}';
    }
}
