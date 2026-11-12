package com.econest.agents.dao;

import com.econest.agents.model.DeliveryAgent;
import com.econest.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** Task 4 JDBC DAO. SQL column names match econest.sql exactly. */
public class DeliveryAgentDAO {
    public int addAgent(DeliveryAgent agent) throws SQLException {
        String sql = "INSERT INTO delivery_agents (name, email, phone, vehicle_type, vehicle_number) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            bindAgent(statement, agent);
            if (statement.executeUpdate() != 1) throw new SQLException("Could not add agent.");
            try (ResultSet ids = statement.getGeneratedKeys()) {
                if (ids.next()) return ids.getInt(1);
                throw new SQLException("Agent added, but generated ID was not returned.");
            }
        }
    }

    public boolean updateAgent(DeliveryAgent agent) throws SQLException {
        String sql = "UPDATE delivery_agents SET name = ?, email = ?, phone = ?, "
                + "vehicle_type = ?, vehicle_number = ? WHERE agent_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            bindAgent(statement, agent);
            statement.setInt(6, agent.getAgentId());
            return statement.executeUpdate() == 1;
        }
    }

    public boolean deleteAgent(int agentId) throws SQLException {
        // MariaDB trg_agent_guard_delete also rejects deletion of active assignments.
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM delivery_agents WHERE agent_id = ?")) {
            statement.setInt(1, agentId);
            return statement.executeUpdate() == 1;
        }
    }

    /** User-friendly precheck; the database trigger remains the final protection. */
    public boolean hasActiveDeliveries(int agentId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM deliveries WHERE agent_id = ? "
                + "AND status IN ('ASSIGNED', 'SCHEDULED', 'DISPATCHED')";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, agentId);
            try (ResultSet result = statement.executeQuery()) {
                result.next();
                return result.getInt(1) > 0;
            }
        }
    }

    public DeliveryAgent getAgent(int agentId) throws SQLException {
        String sql = "SELECT agent_id, name, email, phone, vehicle_type, vehicle_number "
                + "FROM delivery_agents WHERE agent_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, agentId);
            try (ResultSet result = statement.executeQuery()) {
                return result.next() ? mapAgent(result) : null;
            }
        }
    }

    public List<DeliveryAgent> listAgents() throws SQLException {
        String sql = "SELECT agent_id, name, email, phone, vehicle_type, vehicle_number "
                + "FROM delivery_agents ORDER BY agent_id DESC";
        List<DeliveryAgent> agents = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {
            while (result.next()) agents.add(mapAgent(result));
        }
        return agents;
    }

    private static void bindAgent(PreparedStatement statement, DeliveryAgent agent) throws SQLException {
        statement.setString(1, agent.getName());
        statement.setString(2, agent.getEmail());
        statement.setString(3, agent.getPhone());
        statement.setString(4, agent.getVehicleType());
        statement.setString(5, agent.getVehicleNumber());
    }

    private static DeliveryAgent mapAgent(ResultSet result) throws SQLException {
        return new DeliveryAgent(result.getInt("agent_id"), result.getString("name"),
                result.getString("email"), result.getString("phone"),
                result.getString("vehicle_type"), result.getString("vehicle_number"));
    }
}
