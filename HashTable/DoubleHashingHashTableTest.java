/* Class DoubleHashingHashTableTest */
import java.util.Scanner;

public class DoubleHashingHashTableTest{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Ingresa el tamaño de la Hash\n");

        /* Make object of HashTable */
        HashTable ht = new HashTable(scan.nextInt() );
        char ch;
        /*  Perform HashTable operations  */

        do{

            System.out.println("\nOperaciones de la HashTable\n");
            System.out.println("1. Inserta ");
            System.out.println("2. Remover");
            System.out.println("3. Obtener valor mediante key");
            System.out.println("4. Checar si esta vacia");
            System.out.println("5. Vaciar");
            System.out.println("6. Tamaño");
            System.out.println("7. Imprimir HashTable\n");

            int choice = scan.nextInt();
            switch (choice){
            case 1 :
                System.out.println("Ingresa el key y el valor");
                ht.insert(scan.next(), scan.nextInt());
                ht.printHashTable();
                break;
            case 2 :
                System.out.println("Ingresa el key");
                ht.remove(scan.next());
                break;
            case 3 :
                System.out.println("Enter key");
                System.out.println("Valor = "+ ht.get(scan.next()));
                break;
            case 4 :
                System.out.println("Estatus Vacia " +ht.isEmpty());
                break;
            case 5 :
                ht.makeEmpty();
                System.out.println("Hash Table vacia\n");
                break;
            case 6 :
                System.out.println("Tamaño = "+ ht.getSize());
                break;
            case 7 :
                ht.printHashTable();
                break;
            default :
                System.out.println("Error \n ");
                break;
            }

            /* Display hash table */
            System.out.println("\nQuieres continuar  (s o n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'S'|| ch == 's');

    }
}
