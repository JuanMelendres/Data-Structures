/*
    Autor: A00369017 Juan Antonio Melendres Villa
    Nombre de la clase: BinarySearch
    Fecha: 22/01/18
    Comentarios: none
*/
public class BinarySearch{

    public static int BinarySearch(int valor, int[] valores){
        int min = 0,
            max = valores.length - 1,
            avg;

        while(min <= max) {
            avg = (min + max) / 2;
            if(valores[avg] == valor) {
                return avg;
            }
            else if (valor < valores[avg]) {
                max = avg - 1;
            }
            else {
                min = avg + 1;
            }
        }
        return -1;
    }

    public static <E extends Comparable <E>> int BinarySearchGen(E valor, E[] valores){
        int min = 0;
        int max = valores.length - 1;
        while (min <= max) {
            int avg = (min + max) / 2;
            E avgVal = valores[avg];
            int res = valor.compareTo(avgVal);
            if(res < 0) {
                max = avg - 1;
            }
            else if(res > 0 ) {
                min = avg + 1;
            }
            else {
                return avg;
            }
        }
        return -1;
    }

    public static <E extends Comparable <E>> int BinarySearchRec(E valor, E[] valores){
        return BinarySearchRec(valor, valores, 0, valores.length - 1);
    }

    private static <E extends Comparable <E>> int BinarySearchRec(E valor, E[] valores, int min, int max){
        if(valor == null) {
            return -1;
        }
        if(min > max) {
            return -1;
        }
        int avg = (min + max) / 2;
        if(valor.compareTo(valores[avg]) > 0) {
            return BinarySearchRec(valor, valores, avg + 1, max);
        }
        else if(valor.compareTo(valores[avg]) < 0) {
            return BinarySearchRec(valor, valores, min, avg - 1);
        }
        else {
            return avg;
        }
    }

    public static void main(String[] args) {
        Integer a = 2;
        Integer[] b = {2, 5, 8, 10, 20, 21, 23, 25, 27, 29, 123, 243, 345, 456, 567, 678, 789, 890};
        String[] d = {"Hola", "Bebe", "Santa", "Escuela"};
        String c = "Santa";
        System.out.println("No Recursivo");
        System.out.println(BinarySearchGen(a, b)); // Integer
        System.out.println(BinarySearchGen(c, d)); // String
        System.out.println("Recursivo");
        System.out.println(BinarySearchRec(a, b)); // Integer
        System.out.println(BinarySearchRec(c, d)); // String

    }
}
