//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.generation.exceptions.InvalidDataInput;
import org.generation.models.Agenda;
import org.generation.models.Contact;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Agenda agenda = new Agenda();/*creamos el arreglo*/

        int opc = 0;
        /*hacemos el bucle para entrar al menu y seleccionar*/
        while (opc != 7) {
            System.out.println("Bienvenido al Menú Agenda 😊");
            System.out.println("Selecciona un opción por favor: ");
            System.out.println("1° Añadir contacto");
            System.out.println("2° Buscar contacto por nombre");
            System.out.println("3° Ver si existe mi contacto");
            System.out.println("4° Eliminar contacto");
            System.out.println("5° Saber si la agenda es llena");
            System.out.println("6° Saber si la agenda tiene espacios libres");
            System.out.println("7° Salir");
            System.out.println("Esperando tu respuesta: ");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc){
                case 1: //añadir contacto
                    System.out.println("Nombre: ");
                    String name = scanner.nextLine();

                    System.out.println("Teléfono: ");
                    String phone = scanner.nextLine();

                    /**se crea el contacto nuevo manejando las exepciones, si hay datos invalidos*/

                    try{
                        Contact nuevo = new Contact(name,phone);
                        agenda.agregarContacto(nuevo);
                    }catch (InvalidDataInput e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;


                case 2: /**EXISTE CONTACTO*/
                    System.out.println("¿Qué nombre quieres saber si existe? ");
                    name = scanner.nextLine();
                    agenda.existeContacto(name);
                    break;

                case 3: /**BUSCA CONTACTO*/
                    System.out.println("Introduce el nombre del contacto a buscar: ");
                    name = scanner.nextLine();
                    agenda.buscaContacto(name);
                    break;

                    /**ELIMINA CONTACTO*/
                case 4:
                    System.out.println("¿Qué  quieres eliminar de la agenda? ");
                    name = scanner.nextLine();
                    agenda.eliminarContacto(name);
                    break;

                    /**AGENDA LLENA*/
                case 5:
                    agenda.agendaLlena();


                    /**ESPACIOS LIBRES*/
                case 6:
                    agenda.espaciosDisponibles();



            }
        }


    }
}