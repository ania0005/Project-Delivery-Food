package deliveryFood.services;

import deliveryFood.domain.interfaces.Dish;
import deliveryFood.repositories.interfaces.DishRepository;
import deliveryFood.services.interfaces.DishService;

import java.util.List;
import java.util.stream.Collectors;

public class GeneralDishService implements DishService {
    private DishRepository repository;
    public GeneralDishService (DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addDish(String name, double price) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name of the dish cannot be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("The price cannot be negative and equal to zero");
        }
        repository.addDish(name, price);
    }
    public Dish getDishById(int id){
        Dish dish = repository.getDishById(id);
        if (dish == null) throw new IllegalArgumentException("Dish not found");
        return repository.getDishById(id);
    }

    @Override
    public List<Dish> getAllAvailableDishes() {
        return repository.getAllDishes()
                .stream()
                .filter(x -> x.isAvailable())
                .collect(Collectors.toList());
    }

    @Override
    public List<Dish> getAllDishes() {
        return repository.getAllDishes();
    }

    @Override
    public void deleteDishById(int id) {
        Dish dish = repository.getDishById(id);
        if (dish == null) throw new IllegalArgumentException("Dish not found");
        dish.setAvailable(false);
    }
    @Override
    public void deleteDishByName(String name) {
        Dish dish = repository.getDishByName(name);
        if (dish == null) throw new IllegalArgumentException("Dish not found");
        dish.setAvailable(false);
    }
    @Override
    public void restoreDishById(int id) {
        Dish dish = repository.getDishById(id);
        if (dish == null) throw new IllegalArgumentException("Dish not found");
        dish.setAvailable(true);
    }

    @Override
    public void restoreDishByName(String name) {
        Dish dish = repository.getDishByName(name);
        if (dish == null) throw new IllegalArgumentException("Dish not found");
        dish.setAvailable(true);

    }
    @Override
    public void changePrice(int id, double newPrice) {
        Dish dish = repository.getDishById(id);
        if (dish == null) throw new IllegalArgumentException("Dish not found");
        dish.setPrice(newPrice);
    }
    @Override
    public void changeName(int id, String newName) {
        Dish dish = repository.getDishById(id);
        if (dish == null) throw new IllegalArgumentException("Dish not found");
        dish.setName(newName);
    }
    @Override
    public int totalDishesQuantity() {
        return repository.getAllDishes().size();
    }
}
