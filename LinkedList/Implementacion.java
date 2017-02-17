import javax.swing.JOptionPane;

public class Implementacion{

    SLinkedList<Integer> ll = new SLinkedList<Integer>();
    private int con;

    public static void main(String[] args) {

            Implementacion obj = new Implementacion();
            obj.menu();
        }

        public void menu(){
            String op;
           do{
               op = JOptionPane.showInputDialog(null,"1.  Introducir dato"+"\n"
                                                  +"2.  Introducir dato al principio"+"\n"
                                                  +"3.  Ver si la lista esta vacia"+"\n"
                                                  +"4.  Eliminar dato"+"\n"
                                                  +"5.  Salir");

               switch(op){

                   case "1":
                            int a;
                            a = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite dato a ingresar: "));
                            con = 0;
                            ll.add(con,a);
                            con = con + 1;
                       break;
                   case "2":
                            int d;
                            d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato que quiere al principio: "));
                            ll.addFirst(d);
                       break;
                   case "3":
                            if(ll.isEmpty()){
                                JOptionPane.showMessageDialog(null, "Lista vacía!!!");
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Lista con estos datos: " + ll.toString());
                            }

                       break;
                   case "4":
                            int b;
                            b = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el indice a eliminar: "));
                            for(int i=0; i<ll.size(); i++){
                                if(ll.get(i) == b){
                                    ll.remove(i);
                                }
                            }
                       break;
                   case "5":
                       System.exit(0);
                       break;
                   default:
                       JOptionPane.showMessageDialog(null, "Opcion invalida !");
                       break;
               }
           }while(!op.equals("5"));
        }
}



















/*public static void main(String[] args) {
    SLinkedList<Libros> ll = new SLinkedList<Libros>();

    Libros l1 = new Libros(15,"Let us C","Yashwant Kanetkar","BPB",1);
    Libros l2 = new Libros(2,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
    Libros l3 = new Libros(5,"Operating System","Galvin","Wiley",8);

    ll.add(0,l1);
    ll.add(1,l2);
    ll.add(2,l3);

    System.out.println("Original contents of ll: " + "\n" + ll + "\n");
    ll.remove(1);
    System.out.println("Contents of ll after deletion: " + "\n" + ll + "\n");
    ll.addFirst(l2);
    System.out.println("Contents of ll after addFirst: " + "\n" + ll);
}*/
