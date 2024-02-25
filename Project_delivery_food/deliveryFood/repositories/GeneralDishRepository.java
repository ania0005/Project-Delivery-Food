package deliveryFood.repositories;

import deliveryFood.domain.GeneralDish;
import deliveryFood.domain.interfaces.Dish;
import deliveryFood.repositories.interfaces.DishRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralDishRepository implements DishRepository {
    private Map<Integer, Dish> dishes = new HashMap<>();
    private int currentId;

    public GeneralDishRepository() {
        addDish("Pizza", 40);
        addDish("Kebab", 35.5);
        addDish("King Burger", 38.40);
        addDish("Hamburger", 18.20);
        addDish("Cheeseburger", 21.50);
        addDish("Chicken Roll", 23.80);
        addDish("French fries", 15.00);
        addDish("Hamburger menu", 40.40);
        addDish("Cheeseburger menu", 43.50);
        addDish("Cola", 8.00);
        addDish("Fanta", 8.00);
        addDish("Sprite", 8.00);
    }
    @Override
    public List<Dish> getAllDishes() {
        return new ArrayList<>(dishes.values());
    }

    @Override
    public void addDish(String name, double price) {
        GeneralDish dish = new GeneralDish(name, price);
        dish.setId(++currentId);
        dishes.put(currentId, dish);
    }

    @Override
    public Dish getDishById(int id) {
        return dishes.get(id);
    }

    @Override
    public Dish getDishByName(String name) {
       return dishes.values().stream()
               .filter(x-> x.getName().equalsIgnoreCase(name))
               .findFirst()
               .orElse(null);
    }
}
