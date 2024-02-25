package deliveryFood.services;

import deliveryFood.domain.interfaces.Client;
import deliveryFood.domain.interfaces.Dish;
import deliveryFood.domain.interfaces.Order;
import deliveryFood.repositories.interfaces.ClientRepository;
import deliveryFood.services.interfaces.ClientService;

import java.util.List;
import java.util.stream.Collectors;

public class GeneralClientService implements ClientService {
    private ClientRepository repository;

    public GeneralClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addClient(String name, String address) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address can't be empty");
        }
        repository.addClient(name, address);
    }
    public Client getClientByName(String name) {
        return repository.getClientByName(name);
    }

    public Order getLastOrder(int clientId) {
        List<Order> orders = repository.getClientById(clientId).getOrders();
        Client client = repository.getClientById(clientId);
        if (client == null) throw new IllegalArgumentException("Client not found");
        return orders.get(orders.size() - 1);
    }

    @Override
    public List<Client> getAllAvailableClients() {
        return repository.getAllClients()
                .stream()
                .filter(x -> x.isAvailable())
                .collect(Collectors.toList());
    }
    @Override
    public List<Client> getAllVipClients() {
        List<Client> vip =  repository.getAllClients()
                .stream()
                .filter(x -> x.isVip())
                .collect(Collectors.toList());
        if(vip.isEmpty()){
            System.out.println("VIP clients are absent \n");
        }
        return vip;
    }

    @Override
    public List<Client> getAllClients() {
        return repository.getAllClients();
    }

    @Override
    public List<Order> getAllOrdersByClientById(int id) {
        Client client = repository.getClientById(id);
        if (client == null) throw new IllegalArgumentException("Client not found");
        return client.getOrders();
    }
    public void deleteDishFromLastOrderByPosition(int clientId, int position) {
        List<Order> orders = repository.getClientById(clientId).getOrders();
        Client client = repository.getClientById(clientId);
        if (client == null) throw new IllegalArgumentException("Client not found");
        orders.get(orders.size()-1).getDishesInOrder().remove(position-1);

    }

    @Override
    public void deleteClientById(int id) {
        Client client = repository.getClientById(id);
        if (client == null) throw new IllegalArgumentException("Client not found");
        client.setAvailable(false);
    }

    @Override
    public void deleteClientByName(String name) {
        Client client = repository.getClientByName(name);
        if (client == null) throw new IllegalArgumentException("Client not found");
        client.setAvailable(false);
        }

    @Override
    public void restoreClientById(int id) {
        Client client = repository.getClientById(id);
        if (client == null) throw new IllegalArgumentException("Client not found");
        client.setAvailable(true);
    }

    @Override
    public void restoreClientByName(String name) {
        Client client = repository.getClientByName(name);
        if (client == null) throw new IllegalArgumentException("Client not found");
        client.setAvailable(true);
    }

    @Override
    public void changeName(int id, String newName) {
        Client client = repository.getClientById(id);
        if (client == null) throw new IllegalArgumentException("Client not found");
        client.setName(newName);
    }
    @Override
    public void changeAddress(int id, String newAddress) {
        Client client = repository.getClientById(id);
        if (client == null) throw new IllegalArgumentException("Client not found");
        client.setAddress(newAddress);
    }
    @Override
    public int totalClientQuantity() {
        return repository.getAllClients().size();
    }
    @Override
    public int totalVipClientQuantity() {
        return getAllVipClients().size();
    }
    @Override
    public int totalOrderQuantity() {
        return repository.getAllClients().stream()
                .mapToInt(x -> x.getOrders().size())
                .sum();
    }
    @Override
    public int orderQuantityByClient(int id) {
        Client client = repository.getClientById(id);
        if (client == null) throw new IllegalArgumentException("Client not found");
        return getAllOrdersByClientById(id).size();
    }

    @Override
    public List<Dish> makeOrder(int clientId) {
        Client client = repository.getClientById(clientId);
        if (client == null) throw new IllegalArgumentException("Client not found");
        return repository.getClientById(clientId).makeOrder();
    }
}
