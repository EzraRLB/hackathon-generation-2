package org.generation.models;

// Podría extender alguna estructura de datos como ArrayList, Array, etc.
public class Agenda {

    // Recibe contactos como objetos.
    //private Contacto[] contactos;
    private HashMap<String, Contacto> contactos;
    // Se crea de dos formas: Indicándole nosotros el tamaño:
    //public Agenda(int tamaño) {
        //this.contactos = new Contacto[tamaño];
    //}
    public Agenda() {
        this.contactos = new HashMap<>();
    }

    // O con un tamaño por defecto:
    //public Agenda() {
        //this.contactos = new Contacto[10];
    //}


    // Alexis añadirContacto: Añade un contacto a la agenda, si no se pueden
    private static void agregarContacto(Contacto nuevoContacto) {
        System.out.println("Agregar nuevo contacto");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío");
            return;
        }

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine().trim();

        if (telefono.isEmpty()) {
            System.out.println("El teléfono no puede estar vacío");
            return;
        }

        Contacto nuevoContacto = new Contacto(nombre, telefono);
        Agenda.agregarContacto(nuevoContacto);
    }

    // añadir más a la agenda se indicará por pantalla indicando el motivo.


    // Zorayda existeContacto: Indica si un contacto existe en la agenda.
    public boolean existeContacto(Contacto c) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    // listaContactos: Muestra los contactos de la agenda.


    // Zorayda buscarContacto: Busca un contacto por su nombre y muestra su teléfono.
    public void buscaContacto(String nombre) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getNombre().equals(nombre)) {
                System.out.println("Teléfono de " + nombre + ": " + contactos[i].getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // eliminarContacto: Elimina un contacto de la agenda. Indica si se ha eliminado o no por pantalla.

    // agendaLlena: Indica si la agenda está llena. Debería mandarse a llamar cuando
    // se quiera añadir un contacto y
    // no haya espacio disponible.


    // espacioDisponible: Indica el espacio disponible en la agenda. Cuenta los contactos
    // que conforman la agenda y lo resta al tamaño total de la agenda.


}
