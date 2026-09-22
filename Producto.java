public class Producto {
    private final int id;
    private final String nombre;
    private Producto izquierdo;
    private Producto derecho;

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Producto izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Producto getDerecho() {
        return derecho;
    }

    public void setDerecho(Producto derecho) {
        this.derecho = derecho;
    }
}
