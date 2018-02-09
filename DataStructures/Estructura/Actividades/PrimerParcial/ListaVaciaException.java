public class ListaVaciaException extends RuntimeException{
    public ListaVaciaException(){
        super("La lista esta vacía");
    }

    public ListaVaciaException(String msj){
        super(msj);
    }
}
