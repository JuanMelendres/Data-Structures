/*
    Autor: A00369017 Juan Antonio Melendres Villa
    Nombre de la clase: MergeSort
    Fecha: 28/01/18
    Comentarios: none
*/
public class MergeSort{

    public static void mergeSort(int[] datos){
        mergeSort(datos, 0, datos.length - 1);
    }

    private static void mergeSort(int[] datos, int primero, int ultimo){
        if(primero < ultimo) {
            int mid = (primero + ultimo) / 2;
            mergeSort(datos, primero, mid);
            mergeSort(datos, mid + 1, ultimo);
            mezcla(datos, primero, ultimo);
        }
    }

    private static void mezcla(int[] datos, int primero, int ultimo){
        int[] aux = new int[datos.length];
        int mid = (primero + ultimo) / 2,
            i = primero,
            j = mid + 1,
            c = primero;
        for(int a = primero; a <= ultimo; a++){
            aux[a] = datos[a];
        }
        while(i <= mid && j <= ultimo){
            if(aux[i] <= aux[j]){
                datos[c] = aux[i];
                i++;
            }
            else{
                datos[c] = aux[j];
                j++;
            }
            c++;
        }
        while(i <= mid){
            datos[c] = aux[i];
            c++;
            i++;
        }
    }

    /* Generico */

    public static <E extends Comparable <E>> void mergeSortGen(E[] datos){
        mergeSortGen(datos, 0, datos.length - 1);
    }

    private static <E extends Comparable <E>> void mergeSortGen(E[] datos, int primero, int ultimo){
        if (primero < ultimo) {
            int mid = (primero + ultimo) / 2;
            mergeSortGen(datos, primero, mid);
            mergeSortGen(datos, mid + 1, ultimo);
            mezclaGen(datos, primero, ultimo);
        }
    }

    @SuppressWarnings("unchecked")
    private static <E extends Comparable <E>> void mezclaGen(E[] datos, int primero, int ultimo){
        Object[] aux = new Object[datos.length];
        int mid = (primero + ultimo) / 2,
            i = primero,
            j = mid + 1,
            k = 0;
        for(int a = primero; a <= ultimo; a++){
            aux[a] = datos[a];
        }
        while(i <= mid && j <= ultimo){
            if(datos[i].compareTo(datos[j]) > 0){
                datos[k] = (E) aux[i];
                i++;
            }
            else{
                datos[k] = (E) aux[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            datos[k] = (E) aux[i];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 4, 8, 25, 0};
        System.out.println("Unsort");
        for(int i : a) {
            System.out.print(i);
        }
        mergeSort(a);
        System.out.println("\nSort");
        for(int i : a) {
            System.out.print(i);
        }
        System.out.println("");
        Integer[] b = {10, 20, 4, 8, 25, 0};
        System.out.println("Unsort");
        for(int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
        mergeSortGen(b);
        System.out.println("\nSort");
        for(int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
        System.out.println("");
    }
}
