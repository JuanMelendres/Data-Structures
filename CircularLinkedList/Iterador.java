import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
/**
* Esta clase crea un iterador
* @author: Jose Ramon Garcia Gonzalez y Juan Antonio Melendres Villa
* @version: 02/03/2017/
*/
public class Iterador<E> implements Iterable<E>{
    //Variables de la clase
    CLinkedList<E> first;
    boolean j = false;
    int pos = 0;
    /**
    * Constructor de la clase
    */
    public Iterador(CLinkedList<E> n){
        this.first = n;
    }
    /**
    * Método que devuelve si el iterador tiene mas elementos
    * @return Si tiene mas elementos devuelve un true
    */
    public boolean hasNext(){
        return this.pos < this.first.size();
    }
    /**
    * Método que devuelve el proximo elemento del iterador
    * @return Devuelve un dato que esta en un nodo
    */
    public E next(){
        E current;
        if (this.first == null) {
            throw new NoSuchElementException();
        }
        else{
            current = this.first.get(this.pos);
            this.pos++;
            this.j = true;
        }

        return current;
    }
    /**
    * Método que remueve
    */
    public void remove(){
        this.j = true;
        if(this.j = true) {
            this.first.remove(this.first.size()-1);
            this.j = false;
        }
    }

}













/*
protected class Iterador<E> implements Iterable<E>{

    private Node<E> first;
    private int current = 0;

    public Iterador(Node<E> n ){
        this.first = n;
    }

    public boolean hasNext(){  //Returns true if the iteration
                               //has more elements.
        return this.first != null;

    }

    public E next(){ //Returns the next element in the iteration.
        if (first == null) {
            throw new NoSuchElementException();
        }
        return this.first.data[this.current++];
    }

    public void remove(){//Removes from the underlying collection the last element returned by this iterator.
        Node<E> aux= new Node<E>();
        Node<E> ant=new Node<E>();
        E devolver=null;
        int i=0;
        if(index>this.size||index<0){
            throw new IndexOutOfBoundsException("Index invalido");
        }
        if(index==0){
            this.firstNode=this.firstNode.next;
            this.lastNode.next=this.firstNode;
            this.size--;
        }
        if(index<this.size){
            ant=this.firstNode;
            while(i<index&&index<=this.size){
                if(i==index-1){
                    aux=ant.next;
                    ant.next=aux.next;
                    devolver=aux.data;
                    aux.data=null;
                    aux.next=null;
                    this.size--;
                }
                ant=ant.next;
                i++;
            }
        }
        return devolver;
    }
}
*/
