public class Node<E>{

    private E data;
    private Node<E> next;

    public Node(){
        this(null,null);
	}

    public Node(E data){
        this(data, null);
    }

    public Node(E data, Node<E> n){
        this.data = data;
        this.next = n;
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
