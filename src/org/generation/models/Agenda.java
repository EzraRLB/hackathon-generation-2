package org.generation.models;
import org.generation.models.Contacto;
import java.util.Scanner;
import org.generation.exceptions.InvalidDataInput;



public class Agenda {
    // Recibe contactos como objetos.
    private Contacto[] contactos;
    
    public Agenda() {
        this.contactos = new Contacto[10];
    }


    // Alexis añadirContacto: Añade un contacto a la agenda, si no se pueden
    public void agregarContacto(Contacto nuevoContacto) {
        for(int i = 0; i < contactos.length; i++){
            if (contactos[i] == null){
                contactos[i] =nuevoContacto;
                System.out.println("Se añadió correctamente el contacto.");
                return;
            }
        }
        System.out.println("Agenda llena, no se puede añadir.");
    }

    // añadir más a la agenda se indicará por pantalla indicando el motivo.


    // Zorayda existeContacto: Indica si un contacto existe en la agenda.
    public boolean existeContacto(String nombre) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getName().equals(nombre)) {/**contactos esta en la posicion i, get name obitne el nombre, equals compara lo que se busca*/
                return true;
            }
        }
        return false;
    }

    // listaContactos: Muestra los contactos de la agenda.


    // Zorayda buscarContacto: Busca un contacto por su nombre y muestra su teléfono.
    public void buscaContacto(String nombre) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getName().equals(nombre)) {
                System.out.println("Teléfono de " + nombre + ": " + contactos[i].getPhone());
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

    //Genaro de Leon

    public void eliminarContacto(String nombre) throws InvalidDataInput {

        System.out.println("Ingresa el nombre del contacto que deseas eliminar");
        if(nombre==null || nombre.trim().isEmpty()){
            throw new InvalidDataInput("El nombre no debe estar en blanco");
        }
        boolean find = false;

        for (int i = 0; i < contactos.length; i++){
            if(contactos[i] != null && contactos[i].getName().equals(nombre)){
                for(int j = i; j < contactos.length -1; j++){
                    contactos[j] = contactos[j+1];
                }
                contactos[contactos.length -1] = null;
                System.out.println("El contacto " + nombre + "ha sido eliminado.");
                find = true;
                break;
            }
        }
        if(!find){
            throw new InvalidDataInput("El contacto no está registrado");
        }

    }

    // agendaLlena: Indica si la agenda está llena. Debería mandarse a llamar cuando
    // se quiera añadir un contacto y
    // no haya espacio disponible.

    public void agendaLlena(){

        for (int i= 0; i < contactos.length; i++){

            if(contactos[i] != null ){

                System.out.println("No hay más espacio disponible");
            }
        }
    }


    // espacioDisponible: Indica el espacio disponible en la agenda. Cuenta los contactos
    // que conforman la agenda y lo resta al tamaño total de la agenda.
    public String espaciosDisponibles(){

        int contactosDisponibles = 0;
        //En un array de tipo String las posiciones vacías se cuentan como "null"
        for(int i= 0; i < contactos.length; i++){
            if (contactos[i] == null){
                contactosDisponibles++;
            }

        }
        return "En este directorio hay " + contactosDisponibles;
    }

}
