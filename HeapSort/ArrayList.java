public interface ArrayList<E>{

    public int size(); //Devuelve el número de elementos (int)

    public boolean add(E data); //Añade el objeto X al final. Devuelve true.

    public void add(int index, E data); //Inserta el objeto X en la posición indicada.

    public E get(int index); //Devuelve el elemento que está en la posición indicada.

    public E remove(int index); //Elimina el elemento que se encuentra en la posición indicada. Devuelve el elemento eliminado.

    public boolean remove(E data); //Elimina la primera ocurrencia del objeto X. Devuelve true si el elemento está en la lista.

    public void clear(); //Elimina todos los elementos.

    public E set(int index, E data); //Sustituye el elemento que se encuentra en la posición indicada por el objeto X. Devuelve el elemento sustituido.

    public boolean contains(E data); //Comprueba si la colección contiene al objeto X. Devuelve true o false.

    public int indexOf(E data); //Devuelve la posición del objeto X. Si no existe devuelve -1
}
