package deliveryFood.controllers;

import deliveryFood.domain.interfaces.Dish;
import deliveryFood.services.interfaces.DishService;

import java.util.List;
import java.util.Scanner;

public class DishController {
    private DishService service;
    public DishController(DishService service) {
        this.service = service;
    }
    public void addDish() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input dish name:");
            String name = scanner.nextLine();

            System.out.println("Input dish price:");
            double price = Double.parseDouble(scanner.nextLine());

            service.addDish(name, price);
    }

    public List<Dish> getAllDishes() {
        return service.getAllDishes();
    }

    public List<Dish> getAllAvailableDishes() {
        return service.getAllAvailableDishes();
    }

    public void deleteDishById() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input dish id:");
            int dishId = Integer.parseInt(scanner.nextLine());
            service.deleteDishById(dishId);
    }

    public void deleteDishByName() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input dish name:");
            String dishName = scanner.nextLine();
            service.deleteDishByName(dishName);
    }

    public void restoreDishById() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input dish id:");
            int dishId = Integer.parseInt(scanner.nextLine());
            service.restoreDishById(dishId);
    }

    public void restoreDishByName() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input dish name:");
            String dishName = scanner.nextLine();
            service.restoreDishByName(dishName);
    }

    public void changePrice() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input dish id:");
            int dishId = Integer.parseInt(scanner.nextLine());

            System.out.println("Input dish new price:");
            double price = Double.parseDouble(scanner.nextLine());

            service.changePrice(dishId, price);
    }

    public void changeName() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input dish id:");
            int dishId = Integer.parseInt(scanner.nextLine());

            System.out.println("Input dish new name:");
            String dishName = scanner.nextLine();
            service.changeName(dishId, dishName);
    }

    public int totalDishesQuantity() {
        return service.totalDishesQuantity();
    }
}
