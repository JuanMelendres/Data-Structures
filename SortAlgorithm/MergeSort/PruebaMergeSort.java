import javax.swing.JOptionPane;

public class PruebaMergeSort{

    ArrayListG<Integer> alG = new ArrayListG<Integer>();

    public static void main(String[] args) {

        PruebaMergeSort obj = new PruebaMergeSort();
        obj.menu();
    }

    public void menu(){
        String op;
       do{
           op = JOptionPane.showInputDialog(null,"1.  Introducir dato"+"\n"
                                              +"2.  Modificar dato"+"\n"
                                              +"3.  Eliminar dato"+"\n"
                                              +"4.  Buscar dato"+"\n"
                                              +"5.  Sort datos"+"\n"
                                              +"6.  Mostrar datos"+"\n"
                                              +"7.  Salir");

           switch(op){

               case "1"://Bloque para introducir datos al array list
                        int a;
                        a = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite dato a ingresar: "));
                        alG.add(a);
                   break;
               case "2"://Bloque para Modificar dato del array
                        int b, c;
                        int indice;
                        b = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a Modificar: "));
                        if(alG.contains(b)){
                            indice = alG.indexOf(b);
                            c = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo dato: "));
                            alG.set(indice, c);
                        }else{
                            JOptionPane.showMessageDialog(null, "No existe el dato a modificar !", "", JOptionPane.ERROR_MESSAGE);
                        }
                   break;
               case "3"://Bloque para eliminar dato del array
                        int d;
                        b = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar: "));
                        for(int i=0; i<alG.size(); i++){
                            if(alG.get(i).equals(b)){
                                alG.remove(i);
                            }
                        }
                   break;
               case "4"://Bloque para buscar datos en el array list
                        String mostrarBus= "No se ha encontrado nada!", f;
                        c = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar: "));
                        for( int i = 0 ; i  < alG.size(); i++){
                            if(alG.get(i).equals(c)){
                                mostrarBus  ="";
                                mostrarBus += "Dato en  posicion "+i+" : "+alG.get(i)+"\n";
                            }
                       }
                         JOptionPane.showMessageDialog(null, mostrarBus);
                   break;
               case "5"://Bloque para hacer sort los datos del array list
                        MergeSort2 ms = new MergeSort2(alG);
                        ms.sortGivenArray();
                        String Sal= "";
                        for( int i = 0 ; i  < alG.size(); i++){
                            Sal += "Numero posicion "+i+" : "+alG.get(i)+"\n";
                        }
                        JOptionPane.showMessageDialog(null, Sal);
                    break;
               case "6"://Bloque para mostar los datos del array list
                       String Salida= "";
                       for( int i = 0 ; i  < alG.size(); i++){
                        Salida += "Numero posicion "+i+" : "+alG.get(i)+"\n";
                       }
                        JOptionPane.showMessageDialog(null, Salida);
                   break;
               case "7":
                   System.exit(0);
                   break;
               default:
                   JOptionPane.showMessageDialog(null, "Opcion invalida !");
                   break;
           }
       }while(!op.equals("7"));
    }


}






/*
int[] arr = {45,23,11,89,77,98,4,28,65,43};
Mergesort mms = new Mergesort();
mms.sort(arr);
for(int i:arr){
    System.out.print(i + ",");
}
System.out.println(" ");
*/
