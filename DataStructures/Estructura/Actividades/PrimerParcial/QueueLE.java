public class QueueLE<E>{
    private ListaEnlazada<E> lista;

    public QueueLE(){
        this.lista = new ListaEnlazada<>();
    }

    public boolean isEmpty(){
        return this.lista.estaVacia();
    }

    public int size(){
        return this.lista.size;
    }

    public void enqueue(E dato){
        this.lista.insertarInicio(dato);
        //this.lista.insertarFin(dato);
    }

    public E dequeue(){
        return this.lista.borrarFin();
        //return this.lista.borrarInicio();
    }
    public E next(){
        return this.lista.inicio();
    }

    public void flush(){
        this.lista = new ListaEnlazada<>();
        System.gc();
    }

    public static void main(String[] args) {
    }
}
