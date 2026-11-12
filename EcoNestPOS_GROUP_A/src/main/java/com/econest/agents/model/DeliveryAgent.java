package com.econest.agents.model;

/** Task 4: domain entity matching the final Master Class Diagram. */
public class DeliveryAgent {
    private int agentId;
    private String name;
    private String email;
    private String phone;
    private String vehicleType;
    private String vehicleNumber;

    public DeliveryAgent() { }

    public DeliveryAgent(String name, String email, String phone,
                         String vehicleType, String vehicleNumber) {
        setName(name);
        setEmail(email);
        setPhone(phone);
        updateVehicle(vehicleType, vehicleNumber);
    }

    public DeliveryAgent(int agentId, String name, String email, String phone,
                         String vehicleType, String vehicleNumber) {
        this(name, email, phone, vehicleType, vehicleNumber);
        setAgentId(agentId);
    }

    public int getAgentId() { return agentId; }
    public void setAgentId(int agentId) {
        if (agentId < 0) throw new IllegalArgumentException("Agent ID cannot be negative.");
        this.agentId = agentId;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = required(name, 150, "Agent name");
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        String cleaned = required(email, 255, "Email");
        if (!cleaned.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new IllegalArgumentException("Enter a valid email address.");
        }
        this.email = cleaned;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) {
        this.phone = required(phone, 32, "Phone");
    }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = required(vehicleType, 60, "Vehicle type");
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = required(vehicleNumber, 40, "Vehicle number");
    }

    /** UML business method: update both vehicle attributes atomically in memory. */
    public void updateVehicle(String type, String number) {
        String newType = required(type, 60, "Vehicle type");
        String newNumber = required(number, 40, "Vehicle number");
        this.vehicleType = newType;
        this.vehicleNumber = newNumber;
    }

    private static String required(String value, int limit, String field) {
        if (value == null || value.trim().isEmpty() || value.trim().length() > limit) {
            throw new IllegalArgumentException(field + " is required (maximum " + limit + " characters).");
        }
        return value.trim();
    }
}
