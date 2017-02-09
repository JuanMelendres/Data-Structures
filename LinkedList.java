public interface LinkedList<E> {

	public boolean isEmpty(); // Devuelve true si la lista está vacía, false de lo contrario.

	public int size(); //Devuelve la cantidad de elementos de la lista.

	public boolean contains(E data); //Devuelve true si el ítem se encuentra en la lista, falso en caso contrario.

	public E get(int index); //Devuelve el elemento en la posición índex de la lista si el índice es válido.

	public int indexOf(E data); //Devuelve el entero que representa la posición de ítem en la lista. Si no existe en la lista devuelve -1.

	public void add(int index, E data); //Agrega el ítem a la lista en la posición índex si éste es válido.

	public E remove(int index); //Remueve el elemento que está en la posición índex de la lista, si el índice es válido.

 	public String toString(); //Devuelve el contenido de la lista en un String. Utiliza StringBuilder para construir el String.

}
