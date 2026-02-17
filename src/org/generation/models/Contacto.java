package org.generation.models;

public class Contacto {
    // Atributos privados
    private String name;
    private String phone;

    // Constructor
    public Contacto(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // equals(): Dos contactos son iguales si tienen el mismo nombre
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contacto) {
            Contacto otro = (Contacto) obj;
            return this.name.equalsIgnoreCase(otro.name);
        }
        return false;
    }

    // toString(): Para mostrar el contacto
    @Override
    public String toString() {
        return "Nombre: " + name + ", Telefono: " + phone;
    }
}