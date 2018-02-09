public class ListEmptyException extends RuntimeException{
    public ListEmptyException(){
        super("La lista esta vacía");
    }

    public ListEmptyException(String msj){
        super(msj);
    }
}
