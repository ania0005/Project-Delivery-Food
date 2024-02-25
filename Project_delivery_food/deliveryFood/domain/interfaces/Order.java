package deliveryFood.domain.interfaces;

import java.util.List;

public interface Order {
    List<Dish> getDishesInOrder();
    boolean addDishToOrder(Dish dish);
    double getTotalPrice();
}
