/**
* Esta interfaz contiene todos los metodos que necesita un iterable
* @author: Jose Ramon Garcia Gonzalez y Juan Antonio Melendres Villa
* @version: 02/03/2017/
*/

public interface Iterable<E>{

    public boolean hasNext(); //Returns true if the iteration has more elements.

    public E next(); //Returns the next element in the iteration.

    public void remove(); //Removes from the underlying collection the las element returned by this iterator.

}
