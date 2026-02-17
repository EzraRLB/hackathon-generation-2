import java.util.Scanner;
import org.generation.models.Agenda;
import org.generation.models.Contacto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opc = 0;
        
        while (opc != 8) {
            System.out.println("\n========================================");
            System.out.println("       Bienvenido al Menu Agenda");
            System.out.println("========================================");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto por nombre");
            System.out.println("3. Ver si existe un contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Listar todos los contactos");
            System.out.println("6. Ver si la agenda esta llena");
            System.out.println("7. Ver espacios libres");
            System.out.println("8. Salir");
            System.out.println("----------------------------------------");
            System.out.print("Selecciona una opcion: ");
            
            opc = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opc) {
                case 1: // Agregar contacto
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();

                    System.out.print("Telefono: ");
                    String phone = scanner.nextLine();

                    Contacto nuevo = new Contacto(name, phone);
                    agenda.agregarContacto(nuevo);
                    break;

                case 2: // Buscar contacto
                    System.out.print("Nombre del contacto a buscar: ");
                    name = scanner.nextLine();
                    agenda.buscaContacto(name);
                    break;

                case 3: // Existe contacto
                    System.out.print("Nombre del contacto: ");
                    name = scanner.nextLine();
                    if (agenda.existeContacto(name)) {
                        System.out.println("Si, el contacto " + name + " existe en la agenda.");
                    } else {
                        System.out.println("No, el contacto " + name + " no existe en la agenda.");
                    }
                    break;

                case 4: // Eliminar contacto
                    System.out.print("Nombre del contacto a eliminar: ");
                    name = scanner.nextLine();
                    agenda.eliminarContacto(name);
                    break;

                case 5: // Listar contactos
                    agenda.listarContactos();
                    break;

                case 6: // Agenda llena
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda esta LLENA.");
                    } else {
                        System.out.println("La agenda NO esta llena, aun hay espacio.");
                    }
                    break;

                case 7: // Espacios libres
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;

                case 8: // Salir
                    System.out.println("Gracias por usar la Agenda. Hasta pronto!");
                    break;

                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
                    break;
            }
        }
        
        scanner.close();
    }
}