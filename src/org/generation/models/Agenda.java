package org.generation.models;
import org.generation.exceptions.InvalidDataInput;
import org.generation.models.Contact;

// Podría extender alguna estructura de datos como ArrayList, Array, etc.
public class Agenda {

    // Recibe contactos como objetos.
    private Contact[] contactos;
    //private HashMap<String, Contact> contactos;
    // Se crea de dos formas: Indicándole nosotros el tamaño:
    // O con un tamaño por defecto:
    public Agenda() {
        this.contactos = new Contact[10];
    }
    //}


    // Alexis añadirContacto: Añade un contacto a la agenda, si no se pueden
    public void agregarContacto(Contact nuevoContacto) {
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
