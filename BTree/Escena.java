import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Creado por hadexexplade el 01 de febrero del 2016
 */
public class Escena extends JPanel{

    private BTree<Character> arbol;
    private PanelArbol<Character> vista;

    public Escena(){
        this.arbol = new BTree<Character>();
        E<Character> elemento = arbol.insert();
        arbolGeneral.insertarHijo(elemento,'A');
        elemento=arbolGeneral.insertarHijo(elemento,'D');
        arbolGeneral.insertarHijo(elemento,'C');
        arbolGeneral.insertarHijo(elemento,'E');
        elemento=arbolGeneral.insertarHijo(elemento,'G');
        arbolGeneral.insertarHijo(elemento,'F');
        elemento=arbolGeneral.insertarHijo(arbolGeneral.getRaiz(),'I');
        arbolGeneral.insertarHijo(elemento,'H');
        arbolGeneral.insertarHijo(elemento,'L');
        elemento=arbolGeneral.insertarHijo(arbolGeneral.getRaiz(),'O');
        arbolGeneral.insertarHijo(elemento,'M');
        this.vista=new PanelArbol<Character>(arbolGeneral);
        this.setLayout(new BorderLayout());
        add(vista,BorderLayout.CENTER);


    }
}
