import java.util.Scanner;

public class ImplementacionHeap{

    public static void main(String[] args) {
        Heap<Integer> hp = new Heap<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un Entero, 'listo' parar todo: ");
        String line = sc.next();
        while (!line.equals("listo")) {
            hp.insert(Integer.parseInt(line));
            System.out.println(hp);
            System.out.print("Ingrese otro Entero, 'listo' parar todo: ");
            line = sc.next();
        }
        while (!hp.isEmpty()) {
            int max = hp.delete();
            System.out.println(max + " " + hp);
        }
    }

}
