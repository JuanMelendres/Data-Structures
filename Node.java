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

}
