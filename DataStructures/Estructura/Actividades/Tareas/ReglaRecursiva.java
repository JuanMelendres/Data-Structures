/*
    Autor: A00369017 Juan Antonio Melendres Villa
    Nombre de la clase: ReglaRecursiva
    Fecha: 23/01/18
    Comentarios: none
*/
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Point;
import java.awt.Color;

public class ReglaRecursiva extends JPanel{
    private int nivel = 1;

    public ReglaRecursiva(){
        this.setPreferredSize(new Dimension(650, 300));
    }

    public int getNivel(){
        return this.nivel;
    }

    public void setNivel(int n){
        this.nivel = n;
        repaint();
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawLine(50, 200, getWidth()-50, 200);
        pintaRegla(g, this.nivel, new Point(50,200), new Point(getWidth()-50,200));
    }

    private Point puntoMedio(Point a, Point b){
        return new Point((a.x+b.x)/2, (a.y+b.y)/2);
    }

    public void pintaRegla(Graphics g, int n, Point min, Point max){
        int y = 200;
        if(n > 0) {
            Point med = puntoMedio(min,max);
            g.drawLine(med.x, y, med.x, y = y - (15 * n));
            pintaRegla(g, n - 1, min, med);
            pintaRegla(g, n - 1, med, max);
        }
    }

    public static void main(String[] args){
        JFrame ventana = new JFrame("Regla recursiva-Juan Antonio Melendres Villa - A00369017 Gpo 2");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ReglaRecursiva obj = new ReglaRecursiva();
        ventana.add(obj);
        ventana.add(new PanelControl(obj),BorderLayout.WEST);
        ventana.pack();
        ventana.setVisible(true);
    }
}
