import generation.models.Agenda;
import generation.models.Contact;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Inicializamos la agenda con un mapa vacío y el scanner para configurar el tamaño
        Agenda miAgenda = new Agenda(new HashMap<String, Contact>(), sc);

        int opcion;

        do {
            System.out.println("\n--- MENÚ AGENDA ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Ver espacios disponibles");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Validamos que la entrada sea un número
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    miAgenda.agregarContacto();
                    break;
                case 2:
                    System.out.println("\n--- LISTA DE CONTACTOS ---");
                    miAgenda.listaContactos();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBusqueda = sc.nextLine();
                    miAgenda.buscaContacto(nombreBusqueda);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    miAgenda.eliminaContacto(nombreEliminar);
                    break;
                case 5:
                    miAgenda.espaciosDisponibles();
                    break;
                case 0:
                    System.out.println("Saliendo de la agenda. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}