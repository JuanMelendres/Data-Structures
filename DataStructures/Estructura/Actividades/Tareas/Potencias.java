/*
    Autor: A00369017 Juan Antonio Melendres Villa
    Nombre de la clase: Potencias
    Fecha: 16/01/18
    Comentarios: none
*/
import java.util.InputMismatchException;
import java.util.*;

public class Potencias{

    public static int potencia(int b, int p) {
        if (b < 0) {
            if (p == 0){
                return -1;
            }
            else{
                return (b * potencia (b, p-1)) * -1;
            }
        }
        else {
            if (p == 0){
                return 1;
            }
            else{
                return b * potencia (b, p-1);
            }
        }
    }

    public static void main(String a[]){
        int base = 0;
        int potencia = 0;
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        String seguir;

        while (!salir) {
            System.out.println("Calcular potencias \n");
            System.out.println("1. Ingresar la base \n");
            System.out.println("2. Ingresar la potencia \n");
            System.out.println("3. Salir \n");

            try {
                System.out.println("Escribe una de las opciones \n");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingresa la base: \n");
                        base = sn.nextInt();
                        System.out.println("\n");
                        break;
                    case 2:
                        System.out.println("Ingresa la potencia: \n");
                        potencia = sn.nextInt();
                        System.out.println("\n");
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número \n");
                sn.next();
            }
        }
    }

}
