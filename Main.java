import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArbolInventario inventario = new ArbolInventario();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero(scanner, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    registrarProducto(inventario, scanner);
                    break;
                case 2:
                    inventario.RecorridoInorden();
                    break;
                case 3:
                    buscarProducto(inventario, scanner);
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== GESTION DE INVENTARIO ===");
        System.out.println("1. Registrar Producto");
        System.out.println("2. Mostrar Inventario");
        System.out.println("3. Buscar Producto");
        System.out.println("0. Salir");
    }

    private static void registrarProducto(ArbolInventario inventario, Scanner scanner) {
        int id = leerEntero(scanner, "Ingrese el ID del producto: ");
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
            return;
        }

        if (inventario.Insertar(id, nombre)) {
            System.out.println("Producto registrado correctamente.");
        } else {
            System.out.println("No se registro: ya existe un producto con ese ID.");
        }
    }

    private static void buscarProducto(ArbolInventario inventario, Scanner scanner) {
        int id = leerEntero(scanner, "Ingrese el ID que desea buscar: ");
        Producto producto = inventario.Buscar(id);

        if (producto == null) {
            System.out.println("El producto no existe en el inventario.");
        } else {
            System.out.println("Producto encontrado: ID " + producto.getId()
                    + " | Nombre: " + producto.getNombre());
        }
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException exception) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }
}
