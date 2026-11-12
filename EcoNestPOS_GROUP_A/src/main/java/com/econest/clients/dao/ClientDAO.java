package com.econest.clients.dao;

import com.econest.clients.model.Client;
import com.econest.clients.model.ClientType;
import com.econest.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** SQL operations are confined to this DAO; all supplied values are parameterized. */
public class ClientDAO {
    public int addClient(Client client) throws SQLException {
        String sql = "INSERT INTO clients (name, client_type, email, phone, address) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            fillClientValues(statement, client);
            if (statement.executeUpdate() != 1) throw new SQLException("Unable to insert client.");
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
                throw new SQLException("Client inserted, but no generated ID was returned.");
            }
        }
    }

    public boolean updateClient(Client client) throws SQLException {
        String sql = "UPDATE clients SET name = ?, client_type = ?, email = ?, phone = ?, address = ? "
                + "WHERE client_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            fillClientValues(statement, client);
            statement.setInt(6, client.getClientId());
            return statement.executeUpdate() == 1;
        }
    }

    public boolean deleteClient(int clientId) throws SQLException {
        // ON DELETE SET NULL on orders.client_id retains historic order snapshots.
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM clients WHERE client_id = ?")) {
            statement.setInt(1, clientId);
            return statement.executeUpdate() == 1;
        }
    }

    public Client getClient(int clientId) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT client_id, name, client_type, email, phone, address "
                     + "FROM clients WHERE client_id = ?")) {
            statement.setInt(1, clientId);
            try (ResultSet results = statement.executeQuery()) {
                return results.next() ? readClient(results) : null;
            }
        }
    }

    public List<Client> listClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT client_id, name, client_type, email, phone, address "
                + "FROM clients ORDER BY client_id DESC";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) clients.add(readClient(results));
        }
        return clients;
    }

    private void fillClientValues(PreparedStatement statement, Client client) throws SQLException {
        statement.setString(1, client.getName());
        statement.setString(2, client.getType().name());
        statement.setString(3, client.getEmail());
        statement.setString(4, client.getPhone());
        statement.setString(5, client.getAddress());
    }

    private Client readClient(ResultSet results) throws SQLException {
        return new Client(results.getInt("client_id"), results.getString("name"),
                ClientType.valueOf(results.getString("client_type")),
                results.getString("email"), results.getString("phone"),
                results.getString("address"));
    }
}
