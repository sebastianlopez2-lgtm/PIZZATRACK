/**
 * Nodo de la lista ligada que compone la pila manual.
 * Cada nodo almacena un objeto Pizza y un puntero al siguiente nodo.
 */
public class Nodo {
    Pizza dato;       // Dato almacenado en el nodo
    Nodo siguiente;   // Puntero al siguiente nodo en la lista

    /**
     * Constructor del nodo.
     * @param dato Objeto Pizza que almacenará este nodo.
     */
    public Nodo(Pizza dato) {
        this.dato = dato;
        this.siguiente = null; // Por defecto no apunta a ningún nodo
    }
}
