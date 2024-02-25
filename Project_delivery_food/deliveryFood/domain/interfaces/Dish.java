package deliveryFood.domain.interfaces;

public interface Dish {
    int getId();
    boolean isAvailable();
    void setAvailable(boolean available);
    String getName();
    void setName(String name);
    double getPrice();
    void setPrice(double price);
    String toStringOrder();
}
