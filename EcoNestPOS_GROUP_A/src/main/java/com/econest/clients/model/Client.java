package com.econest.clients.model;

/** Task 2 domain class from the finalized master UML diagram. */
public class Client {
    private int clientId;
    private String name;
    private ClientType type;
    private String email;
    private String phone;
    private String address;

    public Client() { }

    public Client(String name, ClientType type, String email, String phone, String address) {
        setName(name);
        setType(type);
        updateContact(email, phone, address);
    }

    public Client(int clientId, String name, ClientType type,
                  String email, String phone, String address) {
        this(name, type, email, phone, address);
        setClientId(clientId);
    }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) {
        if (clientId < 0) throw new IllegalArgumentException("Client ID cannot be negative.");
        this.clientId = clientId;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > 150) {
            throw new IllegalArgumentException("Client name is required (maximum 150 characters).");
        }
        this.name = name.trim();
    }

    public ClientType getType() { return type; }
    public void setType(ClientType type) {
        if (type == null) throw new IllegalArgumentException("Select a client type.");
        this.type = type;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || email.trim().length() > 255
                || !email.trim().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new IllegalArgumentException("Enter a valid email address (max 255 characters).");
        }
        this.email = email.trim();
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty() || phone.trim().length() > 32) {
            throw new IllegalArgumentException("Phone is required (maximum 32 characters).");
        }
        this.phone = phone.trim();
    }

    public String getAddress() { return address; }
    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Client address is required.");
        }
        this.address = address.trim();
    }

    /** Required UML business method; updates contact information together. */
    public void updateContact(String email, String phone, String address) {
        // Validate before replacing fields so a failed edit does not partly change the object.
        Client copy = new Client();
        copy.setEmail(email);
        copy.setPhone(phone);
        copy.setAddress(address);
        this.email = copy.email;
        this.phone = copy.phone;
        this.address = copy.address;
    }
}
