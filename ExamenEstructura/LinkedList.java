import java.util.*;

public class LinkedList<E> implements Iterable<E>{
   private Node<E> head;

 /**
   *  Constructs an empty list
   */
   public LinkedList() {
      this.head = null;
   }
 /**
   *  Returns true if the list is empty
   *
   */
   public boolean isEmpty(){
      return this.head == null;
   }
 /**
   *  Inserts a new node at the beginning of this list.
   *
   */
   public void addFirst(E data){
      this.head = new Node<E>(data, head);
   }
 /**
   *  Returns the first element in the list.
   *
   */
   public E getFirst(){
      if(head == null) {
          throw new NoSuchElementException();
      }
      return head.data;
   }
 /**
   *  Removes the first element in the list.
   *
   */
   public E removeFirst(){
      E tmp = getFirst();
      this.head = head.next;
      return tmp;
   }
 /**
   *  Inserts a new node to the end of this list.
   *
   */
   public void addLast(E data)
   {
      if(this.head == null)
         addFirst(data);
      else
      {
         Node<E> tmp = this.head;
         while(tmp.next != null) tmp = tmp.next;

         tmp.next = new Node<E>(data, null);
      }
   }
 /**
   *  Returns the last element in the list.
   *
   */
   public E getLast()
   {
      if(this.head == null) {
          throw new NoSuchElementException();
      }
      Node<E> tmp = this.head;
      while(tmp.next != null) tmp = tmp.next;

      return tmp.data;
   }
 /**
   *  Removes all nodes from the list.
   *
   */
   public void clear(){
      this.head = null;
   }
 /**
   *  Returns true if this list contains the specified element.
   *
   */
   public boolean contains(E data){
      for(E tmp : this){
         if(tmp.equals(data)){
             return true;
         }
     }
      return false;
   }
 /**
   *  Returns the data at the specified position in the list.
   *
   */
   public E get(int pos){
      if (this.head == null){
        throw new IndexOutOfBoundsException();
      }

      Node<E> tmp = this.head;
      for (int k = 0; k < pos; k++){
         tmp = tmp.next;
      }

      if(tmp == null){
          throw new IndexOutOfBoundsException();
      }

      return tmp.data;
   }
 /**
   *  Returns a string representation
   *
   */
   public String toString(){
      StringBuffer result = new StringBuffer();
      for(Object x : this)
      	result.append(x + " ");

      return result.toString();
   }
 /**
   *  Inserts a new node after a node containing the key.
   *
   */
   public void insertAfter(E key, E toInsert){
      Node<E> tmp = this.head;

      while(tmp != null && !tmp.data.equals(key)){
           tmp = tmp.next;
       }
      if(tmp != null){
         tmp.next = new Node<E>(toInsert, tmp.next);
     }
   }
 /**
   *  Inserts a new node before a node containing the key.
   *
   */
   public void insertBefore(E key, E toInsert){
      if(this.head == null) return;

      if(head.data.equals(key)){
         addFirst(toInsert);
         return;
      }

      Node<E> prev = null;
      Node<E> cur = this.head;

      while(cur != null && !cur.data.equals(key))
      {
         prev = cur;
         cur = cur.next;
      }
      //insert between cur and prev
      if(cur != null){
         prev.next = new Node<E>(toInsert, cur);
     }
   }
 /**
   *  Removes the first occurrence of the specified element in this list.
   *
   */
   public void remove(E key){
      if(this.head == null){
         throw new RuntimeException("cannot delete");
      }

      if(this.head.data.equals(key) ){
         this.head = head.next;
         return;
      }

      Node<E> cur  = head;
      Node<E> prev = null;

      while(cur != null && !cur.data.equals(key)){
         prev = cur;
         cur = cur.next;
      }

      if(cur == null){
         throw new RuntimeException("cannot delete");
     }
      //delete cur node
      prev.next = cur.next;
   }
 /**
   *  Returns a deep copy of the list
   *  Complexity: O(n^2)
   */
   public  LinkedList<E> copy1(){
      LinkedList<E> twin = new LinkedList<E>();
      Node<E> tmp = this.head;
      while(tmp != null){
         twin.addLast( tmp.data );
         tmp = tmp.next;
      }

      return twin;
   }
 /**
   *  Returns a deep copy of the list
   *  Complexity: O(n)
   */
   public LinkedList<E> copy2(){
      LinkedList<E> twin = new LinkedList<E>();
      Node<E> tmp = this.head;
      while(tmp != null){
         twin.addFirst(tmp.data);
         tmp = tmp.next;
      }

      return twin.reverse();
   }
 /**
   *  Reverses the list
   *  Complewxity: O(n)
   */
   public LinkedList<E> reverse(){
      LinkedList<E> list = new LinkedList<E>();
      Node<E> tmp = this.head;
      while(tmp != null){
         list.addFirst(tmp.data);
         tmp = tmp.next;
      }
      return list;
   }
 /**
   *  Returns a deep copy of the immutable list
   *  It uses a tail reference.
   *  Complexity: O(n)
   */
   public LinkedList<E> copy3()
   {
      LinkedList<E> twin = new LinkedList<E>();
      Node<E> tmp = this.head;
      if(this.head==null){
        return null;
      }
      twin.head = new Node<E>(this.head.data, null);
      Node<E> tmpTwin = twin.head;
      while(tmp.next != null)
      {
         tmp = tmp.next;
         tmpTwin.next = new Node<E>(tmp.data, null);
         tmpTwin = tmpTwin.next;
      }

      return twin;
   }

 /*******************************************************
 *
 *  The Node class
 *
 ********************************************************/
   private static class Node<E>{
      private E data;
      private Node<E> next;

      public Node(){
          this(null,null);
    }
      public Node(E data){
          this(data, null);
      }
      public Node(E data, Node<E> next){
         this.data = data;
         this.next = next;
      }
      public E getData(){
          return data;
      }
      public Node<E> getNext(){
          return this.next;
      }
      public void setNext(Node<E> n){
          this.next = n;
      }
      public void setData(E data){
          this.data = data;
      }
   }
 /*******************************************************
 *
 *  The Iterator class
 *
 ********************************************************/
   public Iterator<E> iterator(){
      return new LinkedListIterator();
   }

   private class LinkedListIterator  implements Iterator<E>{
      private Node<E> nextNode;

      public LinkedListIterator(){
         nextNode = head;
      }

      public boolean hasNext(){
         return nextNode != null;
      }

      public E next(){
         if (!hasNext()){
             throw new NoSuchElementException();
         }
         E res = nextNode.data;
         nextNode = nextNode.next;
         return res;
      }

      public void remove() {
          throw new UnsupportedOperationException();
      }
   }
/*****   Include the main() for testing and debugging  *****/
   public static void main(String[] args){
      LinkedList<String> list = new LinkedList <String>();
      list.addFirst("p");
      list.addFirst("a");
      list.addFirst("e");
      list.addFirst("h");
      System.out.println("List!!");
      System.out.println(list);
      LinkedList<String> twin = list.copy3();
      System.out.println("copy3!!");
      System.out.println(twin);
      System.out.println("position 0");
      System.out.println(list.get(0));
//		System.out.println(list.get(4));   //exception
      System.out.println("addLast");
      list.addLast("s");
      System.out.println(list);
      System.out.println("iterator");
      Iterator itr = list.iterator();
      while(itr.hasNext()){
        System.out.print(itr.next() + " ");
      }
      System.out.println();
      System.out.println("iterator2");
      for(Object x : list){
        System.out.print(x + " ");
      }
      System.out.println();
      System.out.println("insertAfter");
      list.insertAfter("e", "ee");
      System.out.println(list);
      System.out.println(list.getLast());
      System.out.println("insertBefore");
      list.insertBefore("h", "yy");
      System.out.println(list);
      System.out.println("remove");
      list.remove("p");
      System.out.println(list);
	}
}
