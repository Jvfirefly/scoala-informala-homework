package ro.sci.teo.ian14;

/**
 * This class represents an order (date when it was placed, productID,
 * quantity of the ordered product).
 *
 * @author Teo
 */
public class Order {
    private String orderDate;
    private String productID;
    private float quantity;

    public Order() {
    }

    public Order(String orderDate, String productID, float quantity) {
        this.orderDate = orderDate;
        this.productID = productID;
        this.quantity = quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDate='" + orderDate + '\'' +
                ", productID='" + productID + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

