import java.util.Scanner;

public class RadixSort{

    // public static void sort( int[] a){
    //
    //     int i, m = a[0], exp = 1, n = a.length;
    //
    //     int[] b = new int[10];
    //
    //     for (i = 1; i < n; i++){
    //         if (a[i] > m){
    //             m = a[i];
    //         }
    //     }
    //     while (m / exp > 0){
    //
    //         int[] bucket = new int[10];
    //
    //         for (i = 0; i < n; i++){
    //
    //             bucket[(a[i] / exp) % 10]++;
    //         }
    //
    //         for (i = 1; i < 10; i++){
    //
    //             bucket[i] += bucket[i - 1];
    //         }
    //
    //         for (i = n - 1; i >= 0; i--){
    //
    //             b[--bucket[(a[i] / exp) % 10]] = a[i];
    //         }
    //
    //         for (i = 0; i < n; i++){
    //
    //             a[i] = b[i];
    //         }
    //         exp *= 10;
    //
    //     }
    // }
    //
    //     /** Main method **/
    //
    // public static void main(String[] args){
    //
    //     Scanner scan = new Scanner( System.in );
    //
    //     System.out.println("Radix Sort Test\n");
    //
    //     int n, i;
    //
    //     /** Accept number of elements **/
    //
    //     System.out.println("Enter number of integer elements");
    //
    //     n = scan.nextInt();
    //
    //     /** Create integer array on n elements **/
    //
    //     int arr[] = new int[ n ];
    //
    //     /** Accept elements **/
    //
    //     System.out.println("\nEnter "+ n +" integer elements");
    //
    //     for (i = 0; i < n; i++){
    //
    //         arr[i] = scan.nextInt();
    //     }
    //
    //     /** Call method sort **/
    //
    //     sort(arr);
    //
    //     /** Print sorted Array **/
    //
    //     System.out.println("\nElements after sorting ");
    //
    //     for (i = 0; i < n; i++){
    //         System.out.print(arr[i]+" ");
    //     }
    //
    //     System.out.println("");
    // }

   public static void Radix (int[] arr) {
      if(arr.length == 0)
      return;
      int[][] np = new int[arr.length][2];
      int[] q = new int[0x100];
      int i,j,k,l,f = 0;
      for(k=0;k<4;k++) {
         for(i=0;i<(np.length-1);i++)
         np[i][1] = i+1;
         np[i][1] = -1;
         for(i=0;i<q.length;i++)
         q[i] = -1;
         for(f=i=0;i<arr.length;i++) {
            j = ((0xFF<<(k<<3))&arr[i])>>(k<<3);
            if(q[j] == -1)
            l = q[j] = f;
         else {
            l = q[j];
            while(np[l][1] != -1)
            l = np[l][1];
            np[l][1] = f;
            l = np[l][1];
         }
         f = np[f][1];
         np[l][0] = arr[i];
         np[l][1] = -1;
      }
      for(l=q[i=j=0];i<0x100;i++)
      for(l=q[i];l!=-1;l=np[l][1])
      arr[j++] = np[l][0];
   }
   }

   public static void main(String[] args) {
      int i;
      int[] arr = new int[15];
      System.out.print("original: ");
      for(i=0;i<arr.length;i++) {
         arr[i] = (int)(Math.random() * 1024);
         System.out.print(arr[i] + " ");
      }

      Radix (arr);
      System.out.print("\nordenados: ");
      for(i=0;i<arr.length;i++)
      System.out.print(arr[i] + " ");
      System.out.println("\nHecho.");
  }

}
