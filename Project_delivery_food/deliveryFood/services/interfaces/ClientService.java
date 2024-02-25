package deliveryFood.services.interfaces;

import deliveryFood.domain.interfaces.Client;
import deliveryFood.domain.interfaces.Dish;
import deliveryFood.domain.interfaces.Order;

import java.util.List;

public interface ClientService {
    void addClient(String name, String adress);
    List<Client> getAllAvailableClients();
    List<Client> getAllClients();
    List<Client> getAllVipClients();
    List<Order> getAllOrdersByClientById(int id);
    Client getClientByName(String name);
    void deleteClientById(int id);
    void deleteClientByName(String name);
    void restoreClientById(int id);
    void restoreClientByName(String name);
    void changeName(int id, String newName);
    void changeAddress(int id, String newAdress);
    int totalClientQuantity();
    int totalVipClientQuantity();
    int totalOrderQuantity();
    int orderQuantityByClient(int id);
    List <Dish> makeOrder(int id);
    void deleteDishFromLastOrderByPosition(int clientId, int position);
    Order getLastOrder(int clientId);

}
