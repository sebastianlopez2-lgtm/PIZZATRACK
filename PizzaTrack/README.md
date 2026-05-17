# Pizza-Track — Sistema de Gestión de Pedidos

## Objetivo
Simulador de gestión de pedidos para una pizzería que implementa **Undo/Redo** usando **pilas manuales** basadas en **listas ligadas** en Java.

## Estructura del Proyecto
```
PizzaTrack/
├── Pizza.java           → Modelo de datos (nombre + arreglo fijo de 3 ingredientes)
├── Nodo.java            → Nodo de la lista ligada
├── PilaManual.java      → Pila implementada manualmente con lista ligada
├── GestionPedidos.java  → Lógica Undo/Redo con dos pilas
└── Main.java            → Menú interactivo en consola
```

## Arquitectura
| Componente | Descripción |
|---|---|
| **Pila Principal** | Almacena pedidos activos. Soporta Deshacer (Undo). |
| **Pila Secundaria** | Almacena pedidos deshechos. Soporta Rehacer (Redo). |

## Métodos implementados en PilaManual
- `push(Pizza)` → Inserta en el tope
- `pop()` → Retira del tope y devuelve el objeto
- `peek()` → Consulta el tope sin retirarlo
- `isEmpty()` → Valida si la pila está vacía

## Instrucciones de Ejecución

### Requisitos
- JDK Eclipse Temurin 17+
- VS Code con extensión Java

### Pasos
1. Clonar el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   ```
2. Abrir la carpeta `PizzaTrack/` en VS Code.
3. Compilar todos los archivos:
   ```bash
   javac *.java
   ```
4. Ejecutar:
   ```bash
   java Main
   ```

## Ejemplo de Ejecución
```
╔══════════════════════════════╗
║        PIZZA-TRACK           ║
║  Sistema de Gestión Pedidos  ║
╚══════════════════════════════╝

-------- MENÚ PRINCIPAL --------
1. Registrar Pizza (Escribir)
2. Deshacer último pedido (Undo)
3. Rehacer pedido deshecho (Redo)
4. Mostrar Pedido Actual
0. Salir

Seleccione una opción: 1
Ingrese el nombre de la pizza: Hawaiana
Ingrediente 1: Jamón
Ingrediente 2: Piña
Ingrediente 3: Queso
  Pedido registrado: Pizza: Hawaiana | Ingredientes: [Jamón, Piña, Queso]

Seleccione una opción: 4
  Pedido actual (listo para producción): Pizza: Hawaiana | Ingredientes: [Jamón, Piña, Queso]

Seleccione una opción: 2
↩   Pedido deshecho: Pizza: Hawaiana | Ingredientes: [Jamón, Piña, Queso]

Seleccione una opción: 3
↪   Pedido rehecho: Pizza: Hawaiana | Ingredientes: [Jamón, Piña, Queso]
```
## Autor
- Nombre: Sebastian Lopez
- Universidad: IU Digital
- Materia: Estructuras de Datos
<img width="576" height="156" alt="Redo" src="https://github.com/user-attachments/assets/9d7eb277-b7b6-4857-989d-f38d0da1124a" />
<img width="556" height="153" alt="Undo" src="https://github.com/user-attachments/assets/f0f94373-750a-4e5c-8b0e-5b74d5e2eaa8" />
https://drive.google.com/file/d/1R7Zc3hyK4q8YFWjJ9Soc-u9ckzVk12Lt/view?usp=sharing

