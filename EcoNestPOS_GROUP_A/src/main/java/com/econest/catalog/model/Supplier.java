package com.econest.catalog.model;

/** Supplier contacts. Supplier rows are retained to preserve stock-in history. */
public class Supplier {
    private int supplierId;
    private String name;
    private String phone;
    private String email;

    public Supplier() { }
    public Supplier(String name, String phone, String email) {
        setName(name);
        updateContact(phone, email);
    }
    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) {
        if (supplierId < 0) throw new IllegalArgumentException("Supplier ID cannot be negative.");
        this.supplierId = supplierId;
    }
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank() || name.trim().length() > 150)
            throw new IllegalArgumentException("Supplier name must be 1 to 150 characters.");
        this.name = name.trim();
    }
    public String getPhone() { return phone; }
    public void setPhone(String phone) {
        if (phone != null && phone.trim().length() > 32)
            throw new IllegalArgumentException("Supplier phone is too long.");
        this.phone = phone == null || phone.isBlank() ? null : phone.trim();
    }
    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email != null && email.trim().length() > 255)
            throw new IllegalArgumentException("Supplier email is too long.");
        this.email = email == null || email.isBlank() ? null : email.trim();
    }
    /** Method required by FINAL UML. */
    public void updateContact(String phone, String email) {
        setPhone(phone);
        setEmail(email);
    }
    @Override public String toString() { return name + " (#" + supplierId + ")"; }
}
