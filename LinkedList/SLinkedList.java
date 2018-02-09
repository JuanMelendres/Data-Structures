import java.lang.* ;
import java.util.NoSuchElementException;

public class SLinkedList<E> implements LinkedList<E> {

	private Node<E> firstNode = null;
	private int size;

	public SLinkedList(){
		this.firstNode = null;
		this.size = 0;
	}

	public SLinkedList(int size, Node<E> firstNode){
		this.size = size;
		this.firstNode = firstNode;
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		if(this.size == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public void add(int index, E data){
		if(index < 0 || index > this.size){
			throw new IndexOutOfBoundsException ("Index out of bounds!!!!!");
		}
		else if(index == 0){
			addFirst(data);
		}
		else{
			Node<E> ant;
			int aux = 0;
			ant = this.firstNode;
			while(aux < index -1){
				ant = ant.getNext();
				aux++;
			}
			Node<E> nuevo = new Node<E>(data, ant.getNext());
			ant.setNext(nuevo);
			this.size++;
		}
	}

	public void addFirst(E data){
		this.firstNode = new Node<E>(data, this.firstNode);
        this.size++;
	}

	public boolean contains(E data){
		boolean contains = false;
        Node<E> temp = this.firstNode;
        for (int i = 0; i < size; i++) {
            temp = temp.getNext();
            if (temp.getData() == data){
				contains = true;
			}
        }
        return contains;
	}

	public int indexOf(E data){
		if(this.size > 0) {
			Node<E> ant;
			int aux = 0;
			ant = this.firstNode;
			while(aux <= this.size){
				if(data.equals(ant.getData())) {
					return aux;
				}
				ant = ant.getNext();
				aux++;
			}
		}
		return -1;
	}

	public E remove(int index) throws NullPointerException{
		Node<E> ant = new Node<E>();
		Node <E> eliminar = new Node<E>();
		int i = 0;
		try{
			if(index == 0){
				this.firstNode = this.firstNode.getNext();
				this.size--;
			}
			else{
				ant = this.firstNode;
				while(i < index&&index <= this.size){
					if(i == index-1){
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
			System.out.println(e);
		}
		return null;
	}

	public E removeFirst() { // falta por terminar
		return null;
	}

	public E removeLast() { // falta por terminar
		return null;
	}

    public E get(int index){
		if(index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException ("Indice no valido");
		}
		Node<E> ant;
		int aux = 0;
		ant = this.firstNode;
		while(aux < index){
			ant = ant.getNext();
			aux++;
		}
		return ant.getData();
	}

	public E getFirst(){
		if(this.firstNode != null){
			return this.firstNode.getData();
		}
		else {
			throw new NoSuchElementException ("Empty list!!");
		}
	}

	public E getLast() { // falta por terminar
		if(this.firstNode == null){
			throw new NoSuchElementException("No Such Element");
		}
		Node<E> tmp = this.firstNode;
      	while(tmp.getNext() != null){
			tmp = tmp.getNext();
		}
		return tmp.getData();
	}

	public String toString(){
		if(this.size == 0) {
			return "{ }";
		}
		else {
			StringBuilder sb = new StringBuilder();
			Node<E> actual = this.firstNode;
			for(int i = 0; i < this.size; i++) {
				sb.append("[" + actual.getData() + "]");
				actual = actual.getNext();
			}
			return sb.toString();
		}
	}
}
