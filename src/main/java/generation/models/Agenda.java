package generation.models;

import java.util.HashMap;
import java.util.Scanner;

// Podría extender alguna estructura de datos como ArrayList, Array, etc.
public class Agenda {

    private HashMap<String, Contact> contactos = new HashMap<String, Contact>();
    private int agendaMaxSize = 10;

    // Recibe contactos como objetos.

    // Se crea de dos formas: Indicándole nosotros el tamaño:
    // O con un tamaño por defecto:
    public HashMap<String, Contact> getContactos() { return contactos; }
    public void setContactos(HashMap<String, Contact> contactos) { this.contactos = contactos; }

    public int getAgendaMaxSize() { return agendaMaxSize; }
    public void setAgendaMaxSize(int agendaSize) { this.agendaMaxSize = agendaSize; }

    public Agenda(HashMap<String, Contact> contactos, Scanner sc) {
        System.out.println("Se creará una nueva agenda con [tamaño por defecto = 10] contactos disponibles.");
        System.out.println("Si desea un número específico, ingrese un número a continuación.");
        System.out.println("De ser cero, un número menor a cero, o letra, se usará tamaño por defecto.");


        if (sc.hasNextInt()) {
            int input = sc.nextInt();
            if (input > 0) this.agendaMaxSize = input;
            sc.nextLine();
        } else {
            System.out.println("Usando tamaño por defecto.");
        }

        System.out.println("La agenda tiene un total de " + agendaMaxSize + " contactos disponibles.");

        this.contactos = contactos;
    }

    // añadirContacto: Añade un contacto a la agenda, si no se pueden
    // añadir más a la agenda se indicará por pantalla mencionando el motivo.
    public void agregarContacto() throws main.java.generation.exceptions.InvalidDataInput {
        if (agendaLlena()) {
            return;
        } else {
            System.out.println("Usando un espacio de contacto...");
            Scanner sc = new Scanner(System.in);

            System.out.println("Introducir datos del nuevo contacto.");
            try {
                System.out.print("Nombre: ");
                String nombreContacto = sc.nextLine().trim();
                System.out.print("Teléfono: ");
                String telefonoContacto = sc.nextLine().trim().replaceAll("\\s+", "");

                Contact nuevoContacto = new Contact(nombreContacto, telefonoContacto);

                if (existeContacto(nuevoContacto)) {
                    System.out.println("El contacto " + nuevoContacto.getName() + " ya existe.");
                    return;
                } else {
                    contactos.put(nuevoContacto.getName(), nuevoContacto);
                    System.out.println("Contacto agregado correctamente.");
                }

            } catch (main.java.generation.exceptions.InvalidDataInput e) {
                System.out.println(e.getMessage());
            }
            espaciosDisponibles();
        }
    }

    // existeContacto: Indica si un contacto existe en la agenda.
    public boolean existeContacto(Contact c) {
        if (contactos.containsKey(c.getName())) {
            System.out.println("El contacto " + c.getName() + " ya existe.");
            return true;
        } else {
            return false;
        }
    }

    // eliminarContacto: Elimina un contacto de la agenda. Indica si se ha eliminado o no por pantalla.
    public void eliminaContacto(String nombre) {
        if (contactos.containsKey(nombre)) {
            contactos.remove(nombre);
            System.out.println("El contacto '" + nombre + "' ha sido eliminado.");
        } else {
            System.out.println("No se pudo eliminar: El nombre '" + nombre + "' no existe.");
        }
    }

    // listaContactos: Muestra los contactos de la agenda.
    public void listaContactos() {
        for (Contact c : contactos.values()) {
            System.out.println(c);
        }
    }

    // buscarContacto: Busca un contacto por su nombre y muestra su teléfono.
    public void buscaContacto(String nombre) {
        if (contactos.containsKey(nombre)) {
            Contact c = contactos.get(nombre);
            System.out.println("Datos de " + nombre + ": " + c.getPhone());
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    // agendaLlena: Indica si la agenda está llena. Debería mandarse a llamar cuando
    // se quiera añadir un contacto y no haya espacio disponible.
    public boolean agendaLlena() {
        if (contactos.size() == getAgendaMaxSize()) {
            System.out.println("La agenda está llena. No es posible agregar más contactos.");
            return true;
        } else {
            espaciosDisponibles();
            return false;
        }
    }

    // espacioDisponible: Indica el espacio disponible en la agenda. Cuenta los contactos
    // que conforman la agenda y lo resta al tamaño total de la agenda.
    public void espaciosDisponibles() {
        System.out.println("Quedan " + (getAgendaMaxSize() - contactos.size()) + " espacios disponibles.");
    }
}
