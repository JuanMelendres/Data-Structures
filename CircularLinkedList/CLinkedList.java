/**
* Esta clase crea una lista ligada simple circular
* @author: Jose Ramon Garcia Gonzalez y Juan Antonio Melendres Villa
* @version: 02/03/2017/
*/
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

public class CLinkedList<E> implements LinkList<E>{
	//Variables de la clase
    private Node<E> firstNode;
   private Node<E> lastNode;
   private int size;
/**
* Constructor para el primer nodo de la lista
*/
   public CLinkedList(){
       this.firstNode=null;
       this.lastNode=null;
       this.size=0;
   }
/**
* Método que devuelve si la lista esta vacia o no
* @return Si la lista tiene algun elemento
*/
   public boolean isEmpty(){
       return this.firstNode==null;

   }
/**
* Método que devuelve el tamaño de la lista
* @return El número de ítems en la lista
*/
   public int size(){
       return this.size;

   }
/**
* Método que devuelve si un elemetno se encuentra en la lista
* @return Devuelve true si el elemento si encuentra en la lista y flase si no
*/
   public boolean contains(E item){
       boolean var=false;
       if(this.size==0){
           throw new IndexOutOfBoundsException ("Index out of bounds");

       }
       else{
           Node <E> aux=this.firstNode;
           int i=0;
           while(aux.data.equals(item)!=true&&i<this.size){
           aux=aux.next;
           }

       }
       return var;

   }
/**
* Método que devuelve la posicion de un elemento
* @return Devuelve el numero de la posicion en la que se encuentra un elemento y si no esta devuelve -1
*/
   public int indexOf(E item){
       int i=0;
       boolean encontrado=false;
       if(this.isEmpty()==true){
           System.out.println("Esta vacio");

       }
       else{
           Node<E> aux=this.firstNode;
           do{
               if(aux.data.equals(item)||aux.next.data.equals(item)){
                   encontrado=true;
               }
               aux=aux.next;
               i++;
           }while(i<this.size-1&&encontrado!=true);
           if(encontrado==false){
               i=-1;
           }
       }

       return i;
   }
/**
* Método que devuelve el elemento en la posicion n
* @return Devuelve el dato que esta en la posicion n
*/
   public E get(int index) {
       Node <E> aux=new Node<E>();
       aux=this.firstNode;
       if(index>this.size-1||index<0){
           throw new IndexOutOfBoundsException("Index invalido");
       }
       if(index==0){
           return aux.data;
       }
       if(index<this.size){
           for(int i=0;i<index-1;i++){
               aux=aux.next;
           }
       }
       return aux.next.data;

   }
/**
* Método que remueve el elemento en la posicion n
* @return Devuelve el elemento eliminado
*/
   public E remove(int index){
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
/**
* Método que agrega un elemento en la posicion n
*/
   public void add(int index,E data){
           if(index<0){
               throw new IndexOutOfBoundsException("Index out of bounds");
           }
           if(index==0){
               addFirst(data);
               this.size++;
           }
           /*if(index==this.size-1||index==this.size){
               this.addLast(data);
               this.size++;
           }*/
           else{
               int i=0;
               Node <E> ant=firstNode;
               while(i<index-1){
                   ant=ant.next;
                   i++;
               }
               Node<E> nodo=new Node<E>(data,ant.next);
               ant.next=nodo;
               size++;
           }
   }
/**
* Método que añade un elemento al principio de la lista
*/
   public void addFirst(E data){
       if(this.size==0){
       this.firstNode=new Node<E>(data,this.firstNode);
       this.lastNode=new Node<E>(data,this.firstNode);
       this.size++;
       }
       else{
           Node<E> nodo=new Node<E>(data,this.firstNode);
           this.lastNode.next=nodo;
           this.firstNode=nodo;
           this.size++;
       }
   }
/**
* Método que agrega un elemento al final de la lista
*/
   public void addLast(E data){
       if(size==0){
           this.addFirst(data);
           this.size++;
       }
       else{
           Node<E> nodo=new Node<E>(data,this.lastNode.next);
           this.lastNode.next=nodo;
           this.lastNode=nodo;
           this.size++;
       }
   }
/**
* Método que recopila todos los datos de los nodos en un solo String
* @return Devuelve el String de los datos en la lista
*/
   public String toString(){
       StringBuilder sb= new StringBuilder();
       Node <E> aux=this.firstNode;
       for(int i=0;i<this.size;i++){
           sb.append(aux.data+"\n");
           aux=aux.next;
       }
       return sb.toString();
   }
/*
* Método que obtiene el dato del primer nodo
* @return Devuelve el dato del primer nodo
*/
   public E getFirst(){
       return this.firstNode.data;
   }
/*
* Método que obtiene el dato del ultimo nodo
* @return Devuelve el dato del ultimo nodo
*/
   public E getLast(){
       return this.lastNode.data;
   }
/*
* Método que obtiene un iteraodr
* @return Devuelve un iterador
*/
   public Iterador<E> iterador(){
       return new Iterador(this);
   }
/**
* Esta clase genera nodos que son utilizados para la clase circular
* @author: Jose Ramon Garcia Gonzalez y Juan Antonio Melendres Villa
* @version: 02/03/2017/
*/
    private class Node<E>{

        E data;
        Node<E> next;

        Node(){
            this(null, null);
        }

        Node(E data){
            this.data = data;
            this.next = null;
        }

        Node(E data, Node<E> n){
            this.data = data;
            this.next = n;
        }

    }

    // protected class Iterador<E> implements Iterable<E>{
    //
    //     CLinkedList<E> first;
    //     boolean j = false;
    //
    //     public Iterador(CLinkedList<E> n){
    //         this.first = n;
    //     }
    //
    //     public boolean hasNext(){  //Returns true if the iteration
    //                                //has more elements.
    //         return this.first != null;
    //
    //     }
    //
    //     public E next(){ //Returns the next element in the iteration.
    //         if (first == null) {
    //             throw new NoSuchElementException();
    //         }
    //
    //         CLinkedList<E> current = this.first;
    //
    //         this.first = current;
    //         this.j = false;
    //
    //         return current.getLast();
    //     }
    //
    //     public void remove(){//Removes from the underlying collection the las element returned by this iterator.
    //
    //     }
    //
    // }

}
