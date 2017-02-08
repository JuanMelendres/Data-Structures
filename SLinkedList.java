import java.lang.* ;
import java.io.* ;
import java.util.NoSuchElementException;

public class SLinkedList<E> implements LinkedList<E> {

	private Node<E> firstNode;

	private int size;

	public SLinkedList(){
		this.firstNode = null;
		this.size = 0;
	}

	public SLinkedList(Node<E> firstNode, int size){
		this.size = size;
		this.firstNode = firstNode;
	}

	public int size(){
		return this.size();
	}

	public boolean isEmpty(){
		if(this.firstNode == null){
			return true;
		}
		else{
			return false;
		}
		//return this.firstNode = null;
	}

	public void add(int index, E data){
		if(index < 0 || index > this.size){
			throw new IndexOutOfBoundsException ("Index out of bounds");
		}
		if(index == 0){
			addFirst(data);
		}
		else{
			Node<E> ant;
			int aux = 0;
			ant = this.firstNode;
			while(aux < index - 1){
				ant = ant.getNext();
				aux++;
			}
			Node<E> nuevo = new Node(data, ant.getNext());
			ant.setNext(ant.getNext());
			size++;
		}
	}

	public void addFirst(E data){
		this.firstNode = new Node(data, this.firstNode);
		this.size++;
	}

	public boolean contains(E data){
		if(this.size == 0){
			return false;
		}
		else{
			int a = this.indexOf(data);
			return a > -1;
		}
	}

	public E get(int index){
		if(index < 0 || index < this.size) {
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

	public void addLast(E data) {
	}

	public E remove(int index){
		if(index==0){
			return removeFirst();
		}
		else{
			Node<E> borrar = get(index);
			Node<E> anterior = get(indexOf(borrar)-1);
			anterior.setNext(borrar.getNext());
			borrar.setNext(null);
			this.size--;
		}
		return borrar;
	}

	public E removeFirst() {
		return null;
	}

	public E removeLast() {
		return null;
	}

	public E getFirst(){
		if(this.firstNode != null){
			return this.firstNode.getData();
		}
		else {
			throw new NoSuchElementException ("Empty list!!");
		}
	}

	public E getLast() {
		return null;
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
				actual.getNext();
			}
			return sb.toString();
		}
	}
}
