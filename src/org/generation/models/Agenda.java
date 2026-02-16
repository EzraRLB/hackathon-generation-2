package org.generation.models;
import org.generation.models.Contacto;
import java.util.Scanner;

// Podría extender alguna estructura de datos como ArrayList, Array, etc.
public class Agenda {

    // Recibe contactos como objetos.
    private Contacto[] contactos;
    // Se crea de dos formas: Indicándole nosotros el tamaño:
    public Agenda(int tamaño) {
        this.contactos = new Contacto[tamaño];
    }
    
    // O con un tamaño por defecto:
    public Agenda() {
        this.contactos = new Contacto[10];
    }


    // Alexis añadirContacto: Añade un contacto a la agenda, si no se pueden
    public void agregarContacto(Contact nuevoContacto) {
        contactos.put(nuevoContacto.getName(),nuevoContacto);
        System.out.println("Contacto añadido correctamente!");

    }

    // añadir más a la agenda se indicará por pantalla indicando el motivo.


    // Zorayda existeContacto: Indica si un contacto existe en la agenda.
    public boolean existeContacto(Contact) {
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
//    public void eliminarContacto(String nombre) throws invaidDataInput {
//
//        System.out.println("Ingresa el nombre del contacto que deseas eliminar");
//
//        if(nombre==null || nombre.trim().isEmpty()){throw new invaidDataInput("El nombre no debe estar en blanco");}
//        else
//        if (contactos.containsKey(nombre)){
//            contactos.remove(nombre);
//            System.out.println("El contacto "+nombre +" ha sido eliminado.");
//        }
//        else
//            throw new invalidData("El contacto no esta registrado.");
//
//    }
    public void eliminarContacto(String nombre) {
        System.out.println("Ingresa el nombre que deseas eliminar");
        Scanner scanner = new Scanner(System.in);
        nombre = scanner.nextLine();
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Nombre inválido.");
            return;
        }

        String nombreBuscado = nombre.trim();

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null &&
                    contactos[i].getNombre() != null &&
                    contactos[i].getNombre().equalsIgnoreCase(nombreBuscado)) {

                for (int j = i; j < contactos.length - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }

                contactos[contactos.length - 1] = null;

                System.out.println("Contacto eliminado correctamente.");
                return;
            }
        }

        System.out.println("Contacto no encontrado.");
    }
    //Genaro de Leon

    // agendaLlena: Indica si la agenda está llena. Debería mandarse a llamar cuando
    // se quiera añadir un contacto y
    // no haya espacio disponible.

    public void agendaLlena(){

        for(int = 0; i < contactos.lengh; i++){

            if( contactos[i] != null ){

                System.out.println("No hay más espacio disponible");
            }
        }
    }


    // espacioDisponible: Indica el espacio disponible en la agenda. Cuenta los contactos
    // que conforman la agenda y lo resta al tamaño total de la agenda.

    public int espaciosDisponibles(){

        int contactosDisponibles;
        //En un array de tipo String las posiciones vacías se cuentan como "null"
        for(int = 0; i < contactos.lenght; i++){
            if (contactos[i] == null){
                contactosDisponibles += i;
            }

        }
        return "En este directorio hay " + contactosDisponibles;
    }





}
