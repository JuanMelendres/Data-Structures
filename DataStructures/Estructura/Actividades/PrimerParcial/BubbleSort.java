/*
    Autor: A00369017 Juan Antonio Melendres Villa
    Nombre de la clase: BubbleSort
    Fecha: 22/01/18
    Comentarios: none
*/
public class BubbleSort{

    private static void bubbleSort(int[] datos){
        for (int i = datos.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (datos[j] > datos[j + 1]) {
                    swap(datos, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] valores, int i, int j){
        int tmp = valores[i];
        valores[i] = valores[j];
        valores[j] = tmp;
    }

    private static <E extends Comparable <E>> void bubbleSortGen(E[] datos){
        for (int i = datos.length -1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (datos[j].compareTo(datos[j + 1]) > 0) {
                    swapGen(datos, j, j+1);
                }
            }
        }
    }

    public static <E> void swapGen(E[] valores, int i, int j){
        E tmp = valores[j];
        valores[j] = valores[i];
        valores[i] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {21, 52, 80, 10, 0, 1};
        Integer[] a = {21, 52, 80, 10, 0, 1};
        String[] b = {"Hola", "Como", "Estas"};
        System.out.println("Unsort");
        for(int i : array) {
            System.out.print(i);
        }
        bubbleSort(array);
        System.out.println("\nSort");
        for(int i : array) {
            System.out.print(i);
        }
        System.out.println("\nSort Gen");
        bubbleSortGen(a);
        for(int i : a) {
            System.out.print(i);
        }
        System.out.println("\nSort Gen");
        bubbleSortGen(b);
        for(int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
        System.out.println("");
    }
}
