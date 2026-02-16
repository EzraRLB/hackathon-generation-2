package org.generation.models;

public class Contact {
    // Nombre.
    public String name;
    // Teléfono.
    public String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Contact(String name, String phone) {
        this.setName(name);
        this.setPhone(phone);
    }
}
