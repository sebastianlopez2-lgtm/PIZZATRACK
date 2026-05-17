/**
 * Clase principal de Pizza-Track.
 * Presenta un menú interactivo en consola para gestionar pedidos
 * usando un sistema Undo/Redo basado en pilas manuales con listas ligadas.
 */
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        GestionPedidos gestion = new GestionPedidos();
        int opcion;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║         PIZZA-TRACK          ║");
            System.out.println("║  Sistema de Gestión Pedidos  ║");
            System.out.println("╚══════════════════════════════╝");

            do {
                System.out.println("\n-------- MENÚ PRINCIPAL --------");
                System.out.println("1. Registrar Pizza (Escribir)");
                System.out.println("2. Deshacer último pedido (Undo)");
                System.out.println("3. Rehacer pedido deshecho (Redo)");
                System.out.println("4. Mostrar Pedido Actual");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = leerEntero(scanner);

                switch (opcion) {
                    case 1 -> registrarPizza(scanner, gestion);
                    case 2 -> gestion.deshacer();
                    case 3 -> gestion.rehacer();
                    case 4 -> gestion.mostrarPedidoActual();
                    case 0 -> System.out.println(" ¡Hasta luego! Cerrando Pizza-Track...");
                    default -> System.out.println(" Opción no válida. Intente de nuevo.");
                }

            } while (opcion != 0);
        }
    }

    /**
     * Solicita al usuario el nombre y los 3 ingredientes de la pizza,
     * crea el objeto Pizza y lo registra en la gestión de pedidos.
     */
    private static void registrarPizza(Scanner scanner, GestionPedidos gestion) {
        String nombre = leerTexto(scanner, "Ingrese el nombre de la pizza: ");

        String[] ingredientes = new String[3];
        for (int i = 0; i < 3; i++) {
            ingredientes[i] = leerTexto(scanner, "Ingrediente " + (i + 1) + ": ");
        }

        Pizza pizza = new Pizza(nombre, ingredientes);
        gestion.registrarPedido(pizza);
    }

    /**
     * Lee texto de entrada asegurándose de que no sea vacío.
     */
    private static String leerTexto(Scanner scanner, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("❌ No se puede dejar vacío. Intente de nuevo.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    /**
     * Lee un número entero de forma segura, evitando errores de entrada.
     */
    private static int leerEntero(Scanner scanner) {
        try {
            String linea = scanner.nextLine().trim();
            return Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            System.out.println(" Entrada inválida. Ingrese un número.");
            return -1; // Valor inválido
        }
    }
}
