package deliveryFood.domain.interfaces;
import java.util.List;

public interface Client {
    int getClientId();
    boolean isAvailable();
    boolean isVip();
    void setAvailable(boolean available);
    String getName();
    List <Order> getOrders();
    List <Dish> makeOrder();
    void setAddress(String address);
    void setName(String name);
    void addDishToOrder(Dish dish);
    Order getCurrentOrder();

}
