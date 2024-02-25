package deliveryFood.services.interfaces;

import deliveryFood.domain.interfaces.Dish;

import java.util.List;

public interface DishService {
    void addDish(String name, double price);
    List<Dish> getAllAvailableDishes();
    List<Dish> getAllDishes();
    Dish getDishById(int id);
    void deleteDishById(int id);
    void deleteDishByName(String name);
    void restoreDishById(int id);
    void restoreDishByName(String name);
    void changePrice(int id, double newPrice);
    void changeName(int id, String newName);
    int totalDishesQuantity();
}
