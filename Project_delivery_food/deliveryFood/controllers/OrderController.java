package deliveryFood.controllers;


import deliveryFood.domain.interfaces.Client;
import deliveryFood.domain.interfaces.Dish;
import deliveryFood.domain.interfaces.Order;
import deliveryFood.services.interfaces.ClientService;
import deliveryFood.services.interfaces.DishService;

import java.util.List;
import java.util.Scanner;

public class OrderController {
    private ClientService serviceClient;
    private DishService serviceDish;
    double cost = 0;

    public OrderController(ClientService serviceClient, DishService serviceDish) {
        this.serviceClient = serviceClient;
        this.serviceDish = serviceDish;
    }

    public void addOrder() {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input client name:");
            String name = scanner.nextLine();

            Client client = serviceClient.getClientByName(name);
            if(!client.isAvailable()) {
                throw new IllegalArgumentException("Client not available");
            } else {

             if (client == null) {
                System.out.println("Input client address:");
                String address = scanner.nextLine();
                serviceClient.addClient(name, address);
                client = serviceClient.getClientByName(name);
                }
                while (true) {
                    List<Dish> availableDishes = serviceDish.getAllAvailableDishes();
                    System.out.println("Type number to select a dish:\n");
                    availableDishes.forEach(System.out::println);
                    System.out.println("Type 0 to exit and show order cost");

                    int dishId = Integer.parseInt(scanner.nextLine());
                    if (dishId != 0) {
                        int dishAmount;
                        System.out.println("Type dish amount:");
                        dishAmount = Integer.parseInt(scanner.nextLine());

                        while (dishAmount >= 1) {
                            client.addDishToOrder(serviceDish.getDishById(dishId));
                            --dishAmount;
                        }
                    } else {
                        cost = client.getCurrentOrder().getTotalPrice();
                        System.out.printf("Your order: \n" + client.getCurrentOrder() + "\n\n");
                        if(client.isVip()){
                            cost = cost * 0.8;
                            System.out.printf("Congratulations! You make more 5 orders!\nYou have discount 20%%\n" + "Total amount -20%% : %.2f", cost);
                            System.out.println("\n");
                        }
                        break;
                    }
                }
            }
            serviceClient.makeOrder(client.getClientId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteDishFromOrderByPosition() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the client id:");
            int clientId = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter number position of order:");
            int position = Integer.parseInt(scanner.nextLine());
            serviceClient.deleteDishFromLastOrderByPosition(clientId, position);
    }
    public void viewOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the client id:");
        int clientId = Integer.parseInt(scanner.nextLine());
        Order lastOrder = serviceClient.getLastOrder(clientId);
        System.out.println(lastOrder);
    }
}
