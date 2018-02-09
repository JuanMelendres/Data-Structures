/*
    Autor: A00369017 Juan Antonio Melendres Villa
    Nombre de la clase: QuickSort
    Fecha: 28/01/18
    Comentarios: none
*/
public class QuickSort{
    public static <E extends Comparable<E>> void quickSort(E[] arr, int a, int b){
        if(a < b){
            int i = a, j = b;
            E x = arr[(i + j) / 2];
            do{
                while (arr[i].compareTo(x) < 0){
                    i++;
                }
                while (x.compareTo(arr[j]) < 0){
                    j--;
                }
                if( i <= j){
                    E tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }
            }while (i <= j);
            quickSort(arr, a, j);
            quickSort(arr, i, b);
        }
    }

    public static void main(String[] args){
        Integer[] ia = {30, 20, 10, 5, 6, 99};
        System.out.println("Unsort");
        for(int i = 0; i < ia.length; i++) {
            System.out.print(ia[i]);
        }
        quickSort(ia, 0, (ia.length / 2));
        System.out.println("\nSort");
        for(int i = 0; i < ia.length; i++) {
            System.out.print(ia[i]);
        }
        System.out.println("");
    }
}
