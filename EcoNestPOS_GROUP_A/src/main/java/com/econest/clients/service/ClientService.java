package com.econest.clients.service;

import com.econest.clients.dao.ClientDAO;
import com.econest.clients.model.Client;
import java.sql.SQLException;
import java.util.List;

/** Business layer: exact five methods required by the final master UML. */
public class ClientService {
    private final ClientDAO clientDAO;

    public ClientService() { this(new ClientDAO()); }
    public ClientService(ClientDAO clientDAO) {
        if (clientDAO == null) throw new IllegalArgumentException("ClientDAO is required.");
        this.clientDAO = clientDAO;
    }

    public int addClient(Client client) throws SQLException {
        validate(client);
        return clientDAO.addClient(client);
    }

    public void updateClient(Client client) throws SQLException {
        validate(client);
        if (client.getClientId() <= 0) throw new IllegalArgumentException("Select an existing client.");
        if (!clientDAO.updateClient(client) && clientDAO.getClient(client.getClientId()) == null) {
            throw new IllegalArgumentException("Client no longer exists. Refresh the list.");
        }
    }

    public void deleteClient(int clientId) throws SQLException {
        if (clientId <= 0) throw new IllegalArgumentException("Invalid client ID.");
        if (!clientDAO.deleteClient(clientId)) {
            throw new IllegalArgumentException("Client does not exist. Refresh the list.");
        }
    }

    public Client getClient(int clientId) throws SQLException {
        if (clientId <= 0) throw new IllegalArgumentException("Invalid client ID.");
        return clientDAO.getClient(clientId);
    }

    public List<Client> listClients() throws SQLException { return clientDAO.listClients(); }

    private static void validate(Client client) {
        if (client == null) throw new IllegalArgumentException("Client details are required.");
        // New and edited objects are valid at construction and setter time.
        // Revalidate to reject a partially initialized default-constructed object.
        new Client(client.getName(), client.getType(), client.getEmail(),
                client.getPhone(), client.getAddress());
    }
}
