public class Node<E>{

    E data;
    Node<E> next;

    public Node(){
		data = null;
		next = null;
	}

    public Node(E data){
        this.data = data;
        this.next = null;
    }

    public Node(E data, Node<E> n){
        this.data = data;
        this.next = n;
    }

    public Node<E> getNext(){
        return this.next;
    }

    public void setNext(Node<E> n){
        this.next = n;
    }

    public E getData(){
        return data;
    }

    public void setData(E data){
        this.data = data;
    }

    public String toString(){
        return this.data + " ";
    }

}
