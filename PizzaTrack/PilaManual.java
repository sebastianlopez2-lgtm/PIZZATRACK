/**
 * Implementación manual de una Pila (Stack) usando Lista Ligada (Nodos).
 * NO se usa java.util.Stack ni ninguna colección de Java.
 */
public class PilaManual {
    private Nodo tope; // Puntero al nodo en la cima de la pila

    /**
     * Constructor: inicializa la pila vacía.
     */
    public PilaManual() {
        this.tope = null;
    }

    /**
     * push(): Inserta un objeto Pizza en el tope de la pila.
     * El nuevo nodo pasa a ser el nuevo tope y apunta al antiguo tope.
     * @param pizza Objeto Pizza a insertar.
     */
    public void push(Pizza pizza) {
        Nodo nuevoNodo = new Nodo(pizza); // Crear nuevo nodo
        nuevoNodo.siguiente = tope;       // El nuevo nodo apunta al tope actual
        tope = nuevoNodo;                 // El tope ahora es el nuevo nodo
    }

    /**
     * pop(): Retira el nodo del tope y devuelve el objeto Pizza.
     * El puntero tope avanza al siguiente nodo.
     * @return Pizza del tope, o null si la pila está vacía.
     */
    public Pizza pop() {
        if (isEmpty()) {
            return null; // Pila vacía, no hay nada que retirar
        }
        Pizza pizzaRetirada = tope.dato; // Guardar el dato del tope
        tope = tope.siguiente;           // Mover tope al siguiente nodo
        return pizzaRetirada;
    }

    /**
     * peek(): Retorna el objeto Pizza del tope sin retirarlo de la pila.
     * @return Pizza del tope, o null si la pila está vacía.
     */
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.dato;
    }

    /**
     * isEmpty(): Verifica si la pila no tiene elementos.
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return tope == null;
    }
}
