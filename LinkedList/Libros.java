public class Libros{
    int id, cantidad;
    String nombre, autor, editorial;

    public Libros(int id, String n, String a, String e, int c) {
        this.id = id;
        this.nombre = n;
        this.autor = a;
        this.editorial = e;
        this.cantidad = c;
    }

    public String toString(){
        return this.id + " " + this.nombre + " " + this.autor + " " + this.editorial + " " + this.cantidad;
    }
}
