/*
    Autor: A00369017 Juan Antonio Melendres Villa
    Nombre de la clase: Fibonacci
    Fecha: 10/01/18
    Comentarios: none
*/

public class Fibonacci{
    /*
        Fibonacci iterativo
    */
    public static long fibonacci(long n){
        if (n == 0 || n == 1) {
            return n;
        }
        else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    /*
        Fibonacci dinamico
    */
    public static long fibonacciTabla(int n){
        long[] tabla = new long[n+1];
        tabla[0] = tabla[1] = 1;
        fibonacciTabla(n, tabla);
        n = n-1;
        return tabla[n];
    }

    private static long fibonacciTabla(int n, long[] valores){
        if (valores[n] > 0) {
            return valores[n];
        }
        else {
            valores[n] = fibonacciTabla(n-1, valores) + fibonacciTabla(n-2, valores);
            return valores[n];
        }
    }


    public static void main(String[] args) {
        System.out.println(fibonacci(6));
        System.out.println();
        System.out.println(fibonacciTabla(6));
    }
}
