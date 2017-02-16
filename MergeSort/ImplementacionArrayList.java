import javax.swing.JOptionPane;

public class ImplementacionArrayList{

    ArrayListG<Integer> miAL = new ArrayListG<Integer>(); //Array List simple

   public static void main(String args[]){

       ImplementacionArrayList obA = new ImplementacionArrayList();
       obA.menu();
   }

   public void menu(){
       String op;
      do{
          op = JOptionPane.showInputDialog(null,"1.  Introducir dato"+"\n"
                                             +"2.  Modificar dato"+"\n"
                                             +"3.  Eliminar dato"+"\n"
                                             +"4.  Buscar dato"+"\n"
                                             +"5.  Mostrar datos"+"\n"
                                             +"6.  Salir");

          switch(op){

              case "1"://Bloque para introducir datos al array list
                       int a;
                       a = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite dato a ingresar: "));
                       miAL.add(a);
                  break;
              case "2"://Bloque para Modificar dato del array
                       int b, c;
                       int indice;
                       b = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a Modificar: "));
                       if(miAL.contains(b)){
                           indice = miAL.indexOf(b);
                           c = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo dato: "));
                           miAL.set(indice, c);
                       }else{
                           JOptionPane.showMessageDialog(null, "No existe el dato a modificar !", "", JOptionPane.ERROR_MESSAGE);
                       }
                  break;
              case "3"://Bloque para eliminar dato del array
                       int d;
                       b = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar: "));
                       for(int i=0; i<miAL.size(); i++){
                           if(miAL.get(i).equals(b)){
                               miAL.remove(i);
                           }
                       }
                  break;
              case "4"://Bloque para buscar datos en el array list
                       String mostrarBus= "No se ha encontrado nada!", f;
                       c = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar: "));
                       for( int i = 0 ; i  < miAL.size(); i++){
                           if(miAL.get(i).equals(c)){
                               mostrarBus  ="";
                               mostrarBus += "Dato en  posicion "+i+" : "+miAL.get(i)+"\n";
                           }
                      }
                        JOptionPane.showMessageDialog(null, mostrarBus);
                  break;
              case "5"://Bloque para mostar los datos del array list


                      String Salida= "";
                      for( int i = 0 ; i  < miAL.size(); i++){
                       Salida += "Numero posicion "+i+" : "+miAL.get(i)+"\n";
                      }
                       JOptionPane.showMessageDialog(null, Salida);
                  break;
              case "6":
                  System.exit(0);
                  break;
              default:
                  JOptionPane.showMessageDialog(null, "Opcion invalida !");
                  break;
          }
      }while(!op.equals("6"));
   }

}
