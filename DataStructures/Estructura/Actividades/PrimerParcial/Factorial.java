/*
    Autor: A00369017 Juan Antonio Melendres Villa
    Nombre de la clase: Factorial
    Fecha: 10/01/18
    Comentarios: none
*/

public class Factorial{
    /*
        Factorial: Se crea un stack en el cual se van guardando los llamados para poder resolver el problema,
        hasta llegar al caso base y ya teninedo ese resultado se empiezan a obtener los demas resultados.
    */
    public static long factorial(long n){
        if (n <= 1) {
            return 1;
        }
        else {
            return n*factorial(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
