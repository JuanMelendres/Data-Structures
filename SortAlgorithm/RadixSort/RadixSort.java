import java.util.Scanner;

public class RadixSort{
    /** Method RadixSort **/
    public static void radixSort( int[] a){
        /** Variables **/
        int i,
            m = a[0],
            exp = 1,
            n = a.length;
        int[] b = new int[10];
        /** Recorremos a para hacer las comparaciones **/
        for (i = 1; i < n; i++){
            if (a[i] > m){
                m = a[i];
            }
        }
        /** Vamos checando los numeros mas significaivos **/
        while (m / exp > 0){
            int[] bucket = new int[10];
            for (i = 0; i < n; i++){
                bucket[(a[i] / exp) % 10]++;
            }
            for (i = 1; i < 10; i++){
                bucket[i] += bucket[i - 1];
            }
            for (i = n - 1; i >= 0; i--){
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            }
            for (i = 0; i < n; i++){
                a[i] = b[i];
            }
            exp *= 10;
        }
    }

    /** Main method **/
    public static void main(String[] args){
        Scanner scan = new Scanner( System.in );
        System.out.println("Radix Sort Test\n");
        int n, i;
        /** Accept number of elements **/
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();
        /** Create integer array on n elements **/
        int arr[] = new int[ n ];
        /** Accept elements **/
        System.out.println("\nEnter "+ n +" integer elements");
        for (i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }
        /** Call method sort **/
        radixSort(arr);
        /** Print sorted Array **/
        System.out.println("\nElements after sorting ");
        for (i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

}
