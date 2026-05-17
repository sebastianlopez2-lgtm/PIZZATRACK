/**
 * Clase que representa un pedido de pizza.
 * Usa un arreglo de tamaño fijo (3) para almacenar los ingredientes.
 */
public class Pizza {
    private final String nombre;
    private final String[] ingredientes; // Arreglo fijo de 3 ingredientes

    /**
     * Constructor que recibe el nombre y los 3 ingredientes de la pizza.
     */
    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;
        this.ingredientes = new String[3];
        System.arraycopy(ingredientes, 0, this.ingredientes, 0, 3);
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return "Pizza: " + nombre +
               " | Ingredientes: [" + ingredientes[0] +
               ", " + ingredientes[1] +
               ", " + ingredientes[2] + "]";
    }
}
