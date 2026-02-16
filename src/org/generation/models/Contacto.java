package org.generation.models;

import org.generation.exceptions.InvalidDataInput;

public class Contacto {
    // Nombre.
    public String name;
    // Teléfono.
    public String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidDataInput {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws InvalidDataInput  {
        this.phone = phone;
    }

    public Contacto(String name, String phone) {
        this.setName(name);
        this.setPhone(phone);
    }

    @Override
    public String toString(){
        return "Contacto{" +
                "Nombre: '" + name + '\'' +
                ", Teléfono: '" + phone + '\'' +
                '}';
    }

}
