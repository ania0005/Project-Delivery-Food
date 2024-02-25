package application;

import deliveryFood.controllers.ClientController;
import deliveryFood.controllers.DishController;
import deliveryFood.controllers.MainController;
import deliveryFood.controllers.OrderController;
import deliveryFood.repositories.GeneralClientRepository;
import deliveryFood.repositories.GeneralDishRepository;
import deliveryFood.repositories.interfaces.ClientRepository;
import deliveryFood.repositories.interfaces.DishRepository;
import deliveryFood.services.GeneralClientService;
import deliveryFood.services.GeneralDishService;
import deliveryFood.services.interfaces.ClientService;
import deliveryFood.services.interfaces.DishService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        DishRepository dishRepository = new GeneralDishRepository();
        DishService dishService = new GeneralDishService(dishRepository);
        DishController dishController = new DishController(dishService);
        ClientRepository clientRepository = new GeneralClientRepository();
        ClientService clientService = new GeneralClientService(clientRepository);
        ClientController clientController = new ClientController(clientService);
        OrderController orderController = new OrderController(clientService, dishService);
        MainController mainController = new MainController(dishController, clientController, orderController);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Choose an object:\n" +
                        "1. Dish. \n" +
                        "2. Client. \n" +
                        "3. Order. \n" +
                        "0. Exit. \n");
                int objectNum = Integer.parseInt(scanner.nextLine());

                switch (objectNum) {
                    case 1:
                        System.out.println("Choose an operation:\n" +
                                "1. Create new dish \n" +
                                "2. Get list all dishes \n" +
                                "3. Get list all available dishes \n"+
                                "4. Delete dish by id \n" +
                                "5. Delete dish by name \n" +
                                "6. Restore dish by id \n" +
                                "7. Restore dish by name \n" +
                                "8. Change dish name \n" +
                                "9. Change dish price \n" +
                                "10. Get total dishes quantity \n");

                        int operationNum = Integer.parseInt(scanner.nextLine());

                        mainController.sendRequest(objectNum + " " + operationNum)
                                .forEach(System.out :: println);
                        System.out.println();
                        break;
                    case 2: //ветка для работы с клиентом
                        System.out.println("Choose an operation:\n" +
                                "1. Create new client \n" +
                                "2. Get list all clients \n" +
                                "3. Get list all available clients \n"+
                                "4. Get list all VIP clients \n"+
                                "5. Get list all orders by client \n"+
                                "6. Delete client by id \n" +
                                "7. Delete client by name \n" +
                                "8. Restore client by id \n" +
                                "9. Restore client by name \n" +
                                "10. Change client name \n" +
                                "11. Change client address \n" +
                                "12. Get total clients quantity \n" +
                                "13. Get total VIP clients quantity \n" +
                                "14. Get total orders quantity \n"  +
                                "15. Get total orders by client \n");

                        int operationNum1 = Integer.parseInt(scanner.nextLine());

                        mainController.sendRequest(objectNum + " " + operationNum1)
                                .forEach(System.out :: println);
                        System.out.println();
                        break;
                    case 3: //ветка для работы с заказом

                        System.out.println("Choose an operation:\n" +
                                "1. Create new order \n" +
                                "2. Delete dish from order \n"+
                                "3. View order \n");

                        int operationNum2 = Integer.parseInt(scanner.nextLine());

                        mainController.sendRequest(objectNum + " " + operationNum2)
                                .forEach(System.out :: println);
                        System.out.println();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Incorrect input");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error!!! " + e.getMessage());
            }
        }
    }
}













