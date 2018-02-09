import java.lang.* ;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

public class ListaEnlazada<E>{

    private Nodo<E> inicio;
    private Nodo<E> fin;
    private int size;

    public ListaEnlazada(){
        this.size = 0;
        this.inicio = this.fin = null;
    }

    public ListaEnlazada(E[] datos){
        this.size = datos.length;
        this.inicio = new Nodo<E>(datos[0], this.inicio);
        for(int i = 0; i < datos.length - 1; i++){
            E d = (E) datos[i];
            this.insertarEn(i, d);
        }
        this.fin = new Nodo<E>(datos[datos.length - 1], this.fin);
    }

    public ListaEnlazada(int s, Nodo<E> n){
        this.size = s;
        this.inicio = n;
        this.fin = null;
    }

    public ListaEnlazada(int s, Nodo<E> nI, Nodo<E> nF){
        this.size = s;
        this.inicio = nI;
        this.fin = nF;
    }

    public E inicio(){
        if(estaVacia()) {
            throw new NoSuchElementException();
        }
        return this.inicio.getData();
    }

    public E fin(){
        if(estaVacia()) {
            throw new NoSuchElementException();
        }
        return this.fin.getData();
    }

    public int getSize(){
        return this.size;
    }

    public boolean estaVacia(){
        return this.size == 0;
        //return this.inicio == null;
        //return this.fin == null;
    }

    public void insertarInicio(E d){
        //Nodo<E> tmp = new Nodo<E>(d, this.inicio);
        //this.inicio = tmp;
        this.inicio = new Nodo<>(d, this.inicio);
        if(estaVacia()){
            this.fin = this.inicio;
            //this.lact = tmp;
        }
        this.size++;
    }

    public void insertarFin(E d){
        if(estaVacia()){
            this.insertarInicio(d);
        }
        else {
            Nodo<E> tmp = new Nodo<E>(d);
            this.fin.setNext(tmp);
            this.fin = tmp;
            this.size++;
        }
    }

    public void insertarEn(int pos, E d){
        if(pos < 0 || pos > this.size){
            throw new ListaVaciaException("No se insertar en esa posicion, esta fuera del rango");
        }
        else if(pos == 0){
            this.insertarInicio(d);
        }
        else if(pos == size - 1){
            this.insertarFin(d);
        }
        else{
            Nodo<E> ant;
            int aux = 0;
            ant = this.inicio;
            while(aux < pos -1){
                ant = ant.getNext();
                aux++;
            }
            Nodo<E> nuevo = new Nodo<E>(d, ant.getNext());
            ant.setNext(nuevo);
            this.size++;
        }
    }

    public E borrarInicio(){
        try{
            E tmp = this.inicio.getData();
            this.inicio = this.inicio.getNext();
            this.size--;
            if(size == 0){ // caso cuando solo hay un elemento
                this.fin = null;
            }
            return tmp;
        }
        catch (NullPointerException e) {
            throw new ListaVaciaException("No se puede borrar el inicio de una lista vacia");
        }
    }

    public E borrarFin(){
        try{
            if(this.size == 1){
                this.borrarInicio();
                return;
            }
            else{
                E tmp = this.fin.getData();
                Nodo<E> current = this.inicio;
                for(int i = 0; i < this.size-2; i++){
                    current = current.getNext();
                }
                current.setNext(null);
                this.fin = current;
                this.size--;
                return tmp;
            }
        }
        catch (NullPointerException ex){
            throw new ListaVaciaException("No se puede borrar el fin de una lista vacia");
        }
    }

    public E borrarEn(int index){
        Nodo<E> ant = new Nodo<E>();
        Nodo<E> eliminar = new Nodo<E>();
        int i = 0;
        try{
            if(index == 0){
                this.inicio = this.inicio.getNext();
                this.size--;
            }
            else{
                ant = this.inicio;
                while(i < index && index <= this.size){
                    if(i == index - 1){
                        eliminar = ant.getNext();
                        ant.setNext(eliminar.getNext());
                        eliminar.setData(null);
                        eliminar.setNext(null);
                        this.size--;
                    }
                    ant = ant.getNext();
                    i++;
                }
            }
        }
        catch(NullPointerException e){
            throw new ListaVaciaException("No se puede borrar el fin de una lista vacia");
        }
        return null;
    }

    public void setAt(int pos, E d) throws IndexOutOfBoundsException{
        Nodo<E> current = this.inicio;
        if(pos < 0 || pos > this.size){
            throw new IndexOutOfBoundsException("No se puede remplazar el dato en la posicion " + pos + "en una lista de tamaño " + this.size);
        }
        else{
            for(int i = 0; i < pos; i++) {
                current = current.getNext();
            }
            current.setData(d);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.size == 0) {
            return "{ vacía }";
        }
        else{
            Nodo<E> actual = this.inicio;
            for(int i = 0; i < this.size; i++){
                sb.append(actual.getData() + ",");
                actual = actual.getNext();
            }
        }
        return sb.toString();
        /*
            String res = "";
            Nodo<E> current = this.inicio;
            for(int i = 0;  i < this.size ; i++){
                res+=current.getData()+",";
                current = current.getNext();
            }
            return res;
        */
    }

    public static void main(String[] args){
        /*try {
            p.borrarInicio();
            System.out.println(p.toString() + "\n");
        }
        catch (ListEmptyException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
    }
}

class Nodo<E>{
    private E dato;
    private Nodo<E> next;

    Nodo(){
        this.dato = null;
        this.next = null;
    }

    Nodo(E d){
        this(d, null);
    }

    Nodo(E d, Nodo<E> n){
        this.dato = d;
        this.next = n;
    }

    public E getData(){
        return this.dato;
    }

    public void setData(E d){
        this.dato = d;
    }

    public Nodo<E> getNext(){
        return this.next;
    }

    public void setNext(Nodo<E> n){
        this.next = n;
    }

    public String toString(){
        return dato.toString();
    }
}
