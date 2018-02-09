/**
* Esta clase crea Heap
* @author: Juan Antonio Melendres Villa
* @version: 09/03/2017/
*/
import java.util.NoSuchElementException;

public class Heap<E extends Comparable<E>> {
    //Creamos un ArrayList
    private ArrayListG<E> arrG;

    /**
    * Constructor para el primer nodo de la lista
    */
    public Heap() {
        this.arrG = new ArrayListG<E>();
    }
    /**
    * Método que hace un swap entre los elementos (solo los acomoda)
    */
    private void swapUp() {
        int d = this.arrG.size() - 1;
        while (d > 0) {
            int p = (d-1)/2;
            E data = this.arrG.get(d);
            E padre = this.arrG.get(p);
            if (data.compareTo(padre) > 0) {
                // swap
                this.arrG.set(d, padre);
                this.arrG.set(p, data);
                // movemos un nivel
                d = p;
            } else {
                break;
            }
        }
    }
    /**
    * Método que hace un swap al elemento mas grande (Acomoda de mayor a menor)
    */
    private void swapDown() {
        int a = 0;
        int l = 2*a+1;
        while (l < this.arrG.size()) {
            int max = l,
                r = l+1;
            if (r < this.arrG.size()) { // checamos al hijo derecho
                if (this.arrG.get(r).compareTo(this.arrG.get(l)) > 0) {
                    max++;
                }
            }
            if (this.arrG.get(a).compareTo(this.arrG.get(max)) < 0) {
                    // switch
                    E temp = this.arrG.get(a);
                    this.arrG.set(a, this.arrG.get(max));
                    this.arrG.set(max, temp);
                    a = max;
                    l = 2*a+1;
            } else {
                break;
            }
        }
    }
    /**
    * Método que inserta un elemento
    * @override de ArrayListG
    */
    public void insert(E data) {
        this.arrG.add(data);
        swapUp();
    }
    /**
    * Método que elimina un elemento del ArrayList
    * @return el valor(dato) eliminado
    * @override de ArrayListG
    */
    public E delete()throws NoSuchElementException {
        if (this.arrG.size() == 0) {
            throw new NoSuchElementException();
        }
        if (this.arrG.size() == 1) {
            return this.arrG.remove(0);
        }
        E data = this.arrG.get(0);
        this.arrG.set(0, this.arrG.remove(this.arrG.size()-1));
        swapDown();
        return data;
    }
    /**
    * Método que nos regresa el tamaño del ArrayList
    * @override de ArrayListG
    */
    public int size() {
        return this.arrG.size();
    }
    /**
    * Método que nos regresa si el ArrayList esta vacio
    * @override de ArrayListG
    */
    public boolean isEmpty() {
        return this.arrG.isEmpty();

    }
    /**
    * Método toString que nos regresa los elementos del ArrayList
    * @override de ArrayListG
    */
    public String toString() {
        return this.arrG.toString();
    }

}
