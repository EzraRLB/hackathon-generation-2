package generation.models;

import main.java.generation.exceptions.InvalidDataInput;

public class Contact {

    // Nombre.
    private String name;
    // Teléfono.
    private String phone;

    public String getName() { return name; }

    public void setName(String name) throws InvalidDataInput {
        if (name == null || name.trim().isEmpty()) throw new InvalidDataInput("El nombre no puede estar vacío.");
        this.name = name;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) throws InvalidDataInput  {
        this.phone = phone;
    }

    public Contact(String name, String phone) {
        this.setName(name);
        this.setPhone(phone);
    }

    public String toString(){
        return "Contacto {" +
                "Nombre: '" + name + '\'' +
                ", Teléfono: '" + phone + '\'' +
                '}';
    }
}
