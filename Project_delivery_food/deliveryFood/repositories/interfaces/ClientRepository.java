package deliveryFood.repositories.interfaces;

import deliveryFood.domain.interfaces.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> getAllClients();
    void addClient(String name, String address);
    Client getClientById(int clientId);
    Client getClientByName(String clientName);
}
