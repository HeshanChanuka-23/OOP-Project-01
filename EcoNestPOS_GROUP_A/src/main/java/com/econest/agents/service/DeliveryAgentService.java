package com.econest.agents.service;

import com.econest.agents.dao.DeliveryAgentDAO;
import com.econest.agents.model.DeliveryAgent;
import java.sql.SQLException;
import java.util.List;

/** Service methods match the Task 4 section of the final Master Class Diagram. */
public class DeliveryAgentService {
    private final DeliveryAgentDAO dao;

    public DeliveryAgentService() { this(new DeliveryAgentDAO()); }
    public DeliveryAgentService(DeliveryAgentDAO dao) {
        if (dao == null) throw new IllegalArgumentException("DeliveryAgentDAO is required.");
        this.dao = dao;
    }

    public int addAgent(DeliveryAgent agent) throws SQLException {
        validate(agent);
        return dao.addAgent(agent);
    }

    public void updateAgent(DeliveryAgent agent) throws SQLException {
        validate(agent);
        if (agent.getAgentId() <= 0) throw new IllegalArgumentException("Select an agent to update.");
        if (!dao.updateAgent(agent) && dao.getAgent(agent.getAgentId()) == null) {
            throw new IllegalArgumentException("Agent no longer exists. Refresh the list.");
        }
    }

    public void deleteAgent(int agentId) throws SQLException {
        if (agentId <= 0) throw new IllegalArgumentException("Invalid agent ID.");
        if (dao.hasActiveDeliveries(agentId)) {
            throw new IllegalStateException("Reassign or complete active deliveries before deleting this agent.");
        }
        // This may still be rejected by the database trigger if an assignment changes meanwhile.
        if (!dao.deleteAgent(agentId)) {
            throw new IllegalArgumentException("Agent no longer exists. Refresh the list.");
        }
    }

    public DeliveryAgent getAgent(int agentId) throws SQLException {
        if (agentId <= 0) throw new IllegalArgumentException("Invalid agent ID.");
        return dao.getAgent(agentId);
    }

    public List<DeliveryAgent> listAgents() throws SQLException { return dao.listAgents(); }

    private static void validate(DeliveryAgent agent) {
        if (agent == null) throw new IllegalArgumentException("Agent details are required.");
        // Validate even when caller used the empty constructor.
        new DeliveryAgent(agent.getName(), agent.getEmail(), agent.getPhone(),
                agent.getVehicleType(), agent.getVehicleNumber());
    }
}
