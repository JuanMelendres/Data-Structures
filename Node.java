public class Node<E>{

    E data;
    Node<E> next;

    public Node (){
		data = null;
		next = null;
	}

    public Node(E data){
        this.data = data;
        this.next = null;
    }

    public Node(Node<E> n, E data){
        this.data = data;
        this.next = n;
    }

    public E getData(){
        return data;
    }
    /**
        * Obtiene el nodo que le sigue
        * @return El nodo siguiente
    */
    public Node getNext(){
        return this.next;
    }

    public void setData(E data){
        this.data = data;
    }

    public void setNext(Node<E> n){
        this.next = n;
    }

    public String toString(){
        return this.data + "";
    }

    /*public static void main(String[] args) {
        Node<Integer> n1 = new Node<Integer>(12);
        Node<Integer> n2 = new Node<Integer>(2367);
        Node<Integer> n3 = new Node<Integer>(0);
        Node<Integer> n4 = new Node<Integer>(423675);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(null);

        System.out.println(n1.getData());
        System.out.println(n1.getNext());
        System.out.println();
        System.out.println(n2.getData());
        System.out.println(n2.getNext());
        System.out.println();
        System.out.println(n3.getData());
        System.out.println(n3.getNext());
        System.out.println();
        System.out.println(n4.getData());
        System.out.println(n4.getNext());
    }*/
}
