package org.generation.models;

public class Agenda {
    
    // Array de contactos
    private Contacto[] contactos;

    // Constructor con tamaño personalizado
    public Agenda(int tamanio) {
        this.contactos = new Contacto[tamanio];
    }

    // Constructor con tamaño por defecto (10)
    public Agenda() {
        this.contactos = new Contacto[10];
    }

    // ========== MÉTODOS REQUERIDOS POR LA RÚBRICA ==========

    // añadirContacto: Añade un contacto a la agenda
    public void agregarContacto(Contacto nuevoContacto) {
        if (agendaLlena()) {
            System.out.println("No se puede agregar: la agenda esta llena.");
            return;
        }
        
        if (existeContacto(nuevoContacto)) {
            System.out.println("No se puede agregar: el contacto ya existe.");
            return;
        }
        
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                contactos[i] = nuevoContacto;
                System.out.println("Contacto agregado exitosamente.");
                return;
            }
        }
    }

    // existeContacto(Contacto c): Indica si el contacto existe o no
    public boolean existeContacto(Contacto c) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    // existeContacto por nombre (para consola)
    public boolean existeContacto(String nombre) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getName().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    // listarContactos(): Lista toda la agenda
    public void listarContactos() {
        System.out.println("=== LISTA DE CONTACTOS ===");
        boolean hayContactos = false;
        
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                System.out.println(contactos[i].toString());
                hayContactos = true;
            }
        }
        
        if (!hayContactos) {
            System.out.println("La agenda esta vacia.");
        }
    }

    // buscaContacto(String nombre): Busca por nombre y muestra su teléfono
    public void buscaContacto(String nombre) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getName().equalsIgnoreCase(nombre)) {
                System.out.println("Telefono de " + nombre + ": " + contactos[i].getPhone());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // eliminarContacto(Contacto c): Elimina el contacto de la agenda
    public boolean eliminarContacto(Contacto c) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                contactos[i] = null;
                System.out.println("Contacto eliminado exitosamente.");
                return true;
            }
        }
        System.out.println("No se encontro el contacto para eliminar.");
        return false;
    }

    // eliminarContacto por nombre (para consola)
    public boolean eliminarContacto(String nombre) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getName().equalsIgnoreCase(nombre)) {
                contactos[i] = null;
                System.out.println("Contacto " + nombre + " eliminado exitosamente.");
                return true;
            }
        }
        System.out.println("No se encontro el contacto para eliminar.");
        return false;
    }

    // agendaLlena(): Indica si la agenda está llena
    public boolean agendaLlena() {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                return false;
            }
        }
        return true;
    }

    // espacioLibres(): Indica cuántos contactos más podemos tener
    public int espacioLibres() {
        int espacios = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                espacios++;
            }
        }
        return espacios;
    }

    // ========== MÉTODOS PARA LA GUI ==========

    // Retorna el teléfono de un contacto (para GUI)
    public String obtenerTelefono(String nombre) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getName().equalsIgnoreCase(nombre)) {
                return contactos[i].getPhone();
            }
        }
        return null;
    }

    // Retorna la lista completa como String (para GUI)
    public String obtenerListaContactos() {
        StringBuilder lista = new StringBuilder();
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                lista.append(contactos[i].toString()).append("\n");
            }
        }
        return lista.toString();
    }
}