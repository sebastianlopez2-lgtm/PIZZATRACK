/**
 * Clase de control que coordina las dos pilas manuales
 * para implementar el sistema Undo/Redo de pedidos de pizza.
 *
 * Pila Principal: almacena pedidos activos (permite Deshacer).
 * Pila Secundaria: almacena pedidos deshechos (permite Rehacer).
 */
public class GestionPedidos {
    private final PilaManual pilaPrincipal;   // Pedidos activos
    private final PilaManual pilaSecundaria;  // Pedidos deshechos (para redo)

    /**
     * Constructor: inicializa ambas pilas vacías.
     */
    public GestionPedidos() {
        pilaPrincipal  = new PilaManual();
        pilaSecundaria = new PilaManual();
    }

    /**
     * Registrar un nuevo pedido (Escribir / push en pila principal).
     * Al registrar un nuevo pedido, se limpia la pila secundaria,
     * ya que el historial de "rehacer" queda invalidado.
     * @param pizza Objeto Pizza a registrar.
     */
    public void registrarPedido(Pizza pizza) {
        pilaPrincipal.push(pizza);
        // Limpiar pila secundaria: nueva acción invalida el historial redo
        while (!pilaSecundaria.isEmpty()) {
            pilaSecundaria.pop();
        }
        System.out.println(" Pedido registrado: " + pizza);
    }

    /**
     * Deshacer (Undo): elimina el último pedido de la pila principal
     * y lo mueve a la pila secundaria para poder rehacerlo.
     */
    public void deshacer() {
        if (pilaPrincipal.isEmpty()) {
            System.out.println(" No hay pedidos para deshacer.");
            return;
        }
        Pizza pizzaDesecha = pilaPrincipal.pop(); // Sacar de pila principal
        pilaSecundaria.push(pizzaDesecha);        // Guardar en pila secundaria
        System.out.println("↩️  Pedido deshecho: " + pizzaDesecha);
    }

    /**
     * Rehacer (Redo): recupera el último pedido deshecho de la pila
     * secundaria y lo devuelve a la pila principal.
     */
    public void rehacer() {
        if (pilaSecundaria.isEmpty()) {
            System.out.println(" No hay pedidos para rehacer.");
            return;
        }
        Pizza pizzaRecuperada = pilaSecundaria.pop(); // Sacar de pila secundaria
        pilaPrincipal.push(pizzaRecuperada);          // Devolver a pila principal
        System.out.println("↪️  Pedido rehecho: " + pizzaRecuperada);
    }

    /**
     * Mostrar el pedido actual (peek en pila principal).
     */
    public void mostrarPedidoActual() {
        Pizza actual = pilaPrincipal.peek();
        if (actual == null) {
            System.out.println(" No hay pedidos activos en este momento.");
        } else {
            System.out.println(" Pedido actual (listo para producción): " + actual);
        }
    }
    // Fin de la clase GestionPedidos - Sistema Undo/Redo Pizza-Track
}
