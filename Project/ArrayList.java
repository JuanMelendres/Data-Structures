import java.lang.* ;

public class ArrayList<E> implements ArrayListI<E>{

    private E[] data;
    private int size = 0;
    private int capacity = 0;
    private static final int initCap = 10;

    //Constructors
    public ArrayList(){
        this(initCap);
    }

    public ArrayList(E[] data){
        this.capacity = this.initCap;
        this.data = data;
    }

    public ArrayList(int capacity){
        this.capacity = this.initCap;
        this.data = (E[]) new Object[this.capacity];
    }

    public ArrayList(int capacity, int size) {
        this.capacity = size;
        this.data = (E[]) new Object[capacity];
    }

    //Methods
    public int size() {
        return this.size;
    }

    public boolean add(E data) {
       if(data == null) {
           throw new NullPointerException();
       }
       if(this.size == this.capacity) {
           reallocate();
       }
       this.data[this.size] = data;
       this.size++;
       return true;
   }

   public void add(int index, E data) {
        if(index < 0 || index > this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if(data == null) {
            throw new NullPointerException();
        }
        if(this.size == this.capacity) {
            reallocate();
        }
        for(int i = this.size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = data;
        this.size++;
    }

    public boolean addAll(E data){
        return addAll(this.size, data);
    }

    public void clear() {
        this.data = (E[]) new Object[this.capacity];
        this.size = 0;
    }

    public boolean equals(Object data) {
        if(data == null) {
            return false;
        }
        if(getClass() != data.getClass()) {
            return false;
        }
        ArrayList<E> al = (ArrayList<E>) data;
        if(this.size != al.size) {
            return false;
        }
        for(int i = 0; i < this.size; i++) {
            if(!this.data[i].equals(al.data[i])) {
                return false;
            }
        }
        return true;
    }

    public E get(int index) {
        if(index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.data[index];
    }

    public int indexOf(Object data) {
        if(data == null) {
            throw new NullPointerException();
        }
        for(int i = 0; i < this.size; i++) {
            if(this.data[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E remove(int index) {
        if(index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E temp = this.data[index];
        for(int i = index + 1; i < this.size; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.size--;
        return temp;
    }

    public boolean remove(Object data) {
        int indOf = indexOf(data);
        if(indOf == -1) {
            return false;
        }
        remove(indOf);
        return true;
    }

    public E set(int index, E data) {
        if(index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if(data == null) {
            throw new NullPointerException();
        }
        E temp = this.data[index];
        this.data[index] = data;
        return temp;
    }

    public boolean contains(E data){
        return false;
    }

    private void reallocate() {
        this.capacity *= 2;
        E[] newArraylist = (E[]) new Object[this.capacity];
        for(int i = 0; i < this.size; i++) {
            newArraylist[i] = this.data[i];
        }
        this.data = newArraylist;
    }

}
