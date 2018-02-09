import java.lang.* ;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;
// CAMBIAR LOS NOMBRES DE LOS METODOS
// HAZ OTRA CLASE SOLO CON LOS NOMBRES CAMBIADOS
public class LinkedList<E>{

    private Node<E> first; // inicio
    private Node<E> last;   // fin
    private int size;

    public LinkedList(){
        this.size = 0;
        this.first = this.last = null;
    }

    public LinkedList(E[] datos){
        // constructor de tarea
    }

    public LinkedList(int s, Node<E> n){
        this.size = s;
        this.first = n;
        this.last = null;
    }

    public LinkedList(int s, Node<E> nI, Node<E> nF){
        this.size = s;
        this.first = nI;
        this.last = nF;
    }
    //Tarea que pasa si la lista esta vacia??
    public E first(){
        return this.first.getData();
    }
    //Tarea que pasa si la lista esta vacia??
    public E last(){
        return this.last.getData();
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
        //return this.first == null;
        //return this.last == null;
    }

    public void addFirst(E d){
        //Node<E> tmp = new Node<E>(d, this.first);
        //this.first = tmp;
        this.first = new Node<>(d, this.first);
        if(isEmpty()){
            this.last = this.first;
            //this.lact = tmp;
        }
        this.size++;
    }

    public void addLast(E d){
        if(isEmpty()){
            this.addFirst(d);
        }
        else {
            Node<E> tmp = new Node<E>(d);
            this.last.setNext(tmp);
            this.last = tmp;
            this.size++;
        }
    }
    //Tarea
    public void addEn(int pos, E d){
        if(pos < 0 || pos > this.size){
            throw new IndexOutOfBoundsException ("Index out of bounds!!!!!");
        }
        else if(pos == 0){
            addFirst(d);
        }
        else{
            Node<E> ant;
            int aux = 0;
            ant = this.first;
            while(aux < pos -1){
                ant = ant.getNext();
                aux++;
            }
            Node<E> nuevo = new Node<E>(d, ant.getNext());
            ant.setNext(nuevo);
            this.size++;
        }
    }
    //si la lista esta vacia, si solo tienes uno
    public E deleteFirst(){
        try{
            E tmp = this.first.getData();
            this.first = this.first.getNext();
            this.size--;
            if(size == 0){ // caso cuando solo hay un elemento
                this.last = null;
            }
            return tmp;
        }
        catch (NullPointerException e) {
            throw new ListEmptyException("No se puede borrar el inicio de una lista vacia");
            //System.exit(0);
        }
    }

    public E deleteLast(){
        E tmp = this.last.getData();
        Node<E> current = this.first;
        for(int i = 0; i < this.size-2; i++){
            current = current.getNext();
        }
        current.setNext(null);
        this.last = current;
        this.size--;
        return tmp;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.size == 0) {
            return "{ vacía }";
        }
        else {
            Node<E> actual = this.first;
            for(int i = 0; i < this.size; i++) {
                sb.append("[" + actual.getData() + "]");
                actual = actual.getNext();
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        LinkedList<String> palabras = new LinkedList<>();
        //palabras.addFirst("Juan");
        //palabras.addFirst("Karen");
        //palabras.addFirst("Doge");
        //System.out.println(palabras.toString() + "\n");
        try {
            palabras.deleteFirst();
            System.out.println(palabras.toString() + "\n");
        }
        catch (ListEmptyException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //palabras.deleteFirst();
        //System.out.println(palabras.toString() + "\n");
        //palabras.deleteFirst();
        //System.out.println(palabras.toString() + "\n");
    }
}

class Node<E>{
    private E data;
    private Node<E> next;

    Node(){
        this.data = null;
        this.next = null;
    }

    Node(E d){
        this(d, null);
    }

    Node(E d, Node<E> n){
        this.data = d;
        this.next = n;
    }

    public E getData(){
        return this.data;
    }

    public void setData(E d){
        this.data = d;
    }

    public Node<E> getNext(){
        return this.next;
    }

    public void setNext(Node<E> n){
        this.next = n;
    }

    public String toString(){
        return data.toString();
    }
}
