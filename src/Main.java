//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Agenda agenda = new Agenda(10);/*creamos el arreglo*/

        int opc = 0;
        /*hacemos el bucle para entrar al emnu y seleccionar*/
        while (opc !=7){
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
            scanner = scanner.nextInt();
            scanner.nextLine();
        }
        


    }
