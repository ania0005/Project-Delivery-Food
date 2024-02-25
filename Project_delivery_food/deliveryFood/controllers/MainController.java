package deliveryFood.controllers;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private DishController dishController;
    private ClientController clientController;
    private OrderController orderController;

    public MainController(DishController dishController, ClientController clientController, OrderController orderController) {
        this.dishController = dishController;
        this.clientController = clientController;
        this.orderController = orderController;
    }

    public List<Object> sendRequest(String query) {

        // "2 3"
            String[] parts = query.split(" "); // "2 3" -> ["2", "3"]
            int objectNum = Integer.parseInt(parts[0]); // ["2", "3"] -> "2" -> 2
            int operationNum = Integer.parseInt(parts[1]); // ["2", "3"] -> "3" -> 3

            List<Object> result = new ArrayList<>();

            switch (objectNum) {
                case 1: // Эта ветка для работы с блюдами
                    switch (operationNum) {
                        case 1: // Эта ветка для операции сохранения
                            dishController.addDish();
                            return result;
                        case 2: // Эта ветка для операции возврата всех продуктов из БД
                            result.addAll(dishController.getAllDishes());
                            return result;
                        case 3:
                            result.addAll(dishController.getAllAvailableDishes());
                            return result;
                        case 4:
                            dishController.deleteDishById();
                            return result;
                        case 5:
                            dishController.deleteDishByName();
                            return result;
                        case 6:
                            dishController.restoreDishById();
                            return result;
                        case 7:
                            dishController.restoreDishByName();
                            return result;
                        case 8:
                            dishController.changeName();
                            return result;
                        case 9:
                            dishController.changePrice();
                            return result;
                        case 10:
                            int result1 = dishController.totalDishesQuantity();
                            result.add(result1);
                            return result;
                        default:
                            System.out.println("Incorrect input!");
                            break;
                    }

                case 2: // Эта ветка для работы с клиент // Здесь мы бы вызывали контроллер клиент
                    switch (operationNum){
                        case 1:
                            clientController.addClient();
                            return result;
                        case 2:
                            result.addAll(clientController.getAllClients());
                            return result;
                        case 3:
                            result.addAll(clientController.getAllAvailableClients());
                            return result;
                        case 4:
                            result.addAll(clientController.getAllVipClients());
                            return result;
                        case 5:
                            result.addAll(clientController.getAllOrdersByClientById());
                            return result;
                        case 6:
                            clientController.deleteClientById();
                            return result;
                        case 7:
                            clientController.deleteClientByName();
                            return result;
                        case 8:
                            clientController.restoreClientById();
                            return result;
                        case 9:
                            clientController.restoreClientByName();
                            return result;
                        case 10:
                            clientController.changeName();
                            return result;
                        case 11:
                            clientController.changeAddress();
                            return result;
                        case 12:
                            int result1 = clientController.totalClientQuantity();
                            result.add(result1);
                            return result;
                        case 13:
                            int result4 = clientController.totalVipClientQuantity();
                            result.add(result4);
                            return result;
                        case 14:
                            int result2 = clientController.totalOrderQuantity();
                            result.add(result2);
                            return result;
                        case 15:
                            int result3 = clientController.orderQuantityByClient();
                            result.add(result3);
                            return result;
                    }
                    break;

                case 3:
                switch (operationNum) {
                    case 1:
                        orderController.addOrder();
                        return result;

                    case 2:
                        orderController.deleteDishFromOrderByPosition();
                        return result;

                    case 3:
                        orderController.viewOrder();
                        return result;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
                break;
            }
            return result;
    }
}

