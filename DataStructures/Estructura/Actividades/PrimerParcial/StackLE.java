public class StackLE<E>{
    private ListaEnlazada<E> lista;

    public StackLE(){
        this.lista = new ListaEnlazada<E>();
    }

    public boolean isEmpty(){
        return this.lista.estaVacia();
    }

    public int size(){
        return this.lista.size;
    }

    public void push(E dato){
        this.lista.insertarInicio(dato);
    }

    public E pop(){
        return this.lista.borrarInicio();
    }

    public E top(){
        return this.lista.inicio();
    }

    public void flush(){
        this.lista = new ListaEnlazada<>();
        System.gc();
    }
    public static void main(String[] args) {
        StackLE<String> pila = new StackLE<>();
        String[] nombres = {"juan", "Karen", "Doge", "Mandis", "Pulpish"};
        for (int i = 0; i < nombres.length; i++) {
            pila.push(nombres[i]);
        }
        pila.push("Doge3");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop()+",");
        }
        System.out.println();
    }
}
