public class ArbolInventario {
    private Producto raiz;

    public boolean Insertar(int id, String nombre) {
        Producto nuevo = new Producto(id, nombre);

        if (raiz == null) {
            raiz = nuevo;
            return true;
        }

        return Insertar(raiz, nuevo);
    }

    private boolean Insertar(Producto actual, Producto nuevo) {
        if (nuevo.getId() == actual.getId()) {
            return false;
        }

        if (nuevo.getId() < actual.getId()) {
            if (actual.getIzquierdo() == null) {
                actual.setIzquierdo(nuevo);
                return true;
            }
            return Insertar(actual.getIzquierdo(), nuevo);
        }

        if (actual.getDerecho() == null) {
            actual.setDerecho(nuevo);
            return true;
        }
        return Insertar(actual.getDerecho(), nuevo);
    }

    public void RecorridoInorden() {
        if (raiz == null) {
            System.out.println("El inventario esta vacio.");
            return;
        }

        System.out.println("\n--- INVENTARIO ORDENADO ---");
        recorridoInorden(raiz);
    }

    private void recorridoInorden(Producto actual) {
        if (actual == null) {
            return;
        }

        recorridoInorden(actual.getIzquierdo());
        System.out.println("ID: " + actual.getId() + " | Nombre: " + actual.getNombre());
        recorridoInorden(actual.getDerecho());
    }

    public Producto Buscar(int id) {
        return Buscar(raiz, id);
    }

    private Producto Buscar(Producto actual, int id) {
        if (actual == null || actual.getId() == id) {
            return actual;
        }

        if (id < actual.getId()) {
            return Buscar(actual.getIzquierdo(), id);
        }
        return Buscar(actual.getDerecho(), id);
    }
}
