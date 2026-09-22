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


}
