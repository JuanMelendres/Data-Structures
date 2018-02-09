import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Point;

public class SierpinskiGasket extends JFrame{
    private int level;

    public SierpinskiGasket(){
        super("Fractal SierpinskiGasket");
        this.setSize(640, 480);
        this.level = Integer.parseInt(JOptionPane.showInputDialog("Escribe el nivel de profundidad a calcular"));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        Point a  = new Point(20, 380); //puntos originales 20, 380
        Point b  = new Point(620, 380); //puntos originales 620, 380
        Point c = new Point(320, 50); //puntos originales 320, 50
        this.pintaTriangulos(g, this.level, a, b, c);
    }

    private void pintaLineas(Graphics g, Point a, Point b){
        g.drawLine(a.x, a.y, b.x, b.y);
    }

    private Point puntoMedio(Point a, Point b){
        return new Point((a.x+b.x)/2, (a.y+b.y)/2);
    }

    private void pintaTriangulos(Graphics g, int n, Point a, Point b, Point c){
        if(n == 0) {
            this.pintaLineas(g, a, b);
            this.pintaLineas(g, b, c);
            this.pintaLineas(g, c, a);
        }
        else {
            Point ab2 = this.puntoMedio(a, b),
                bc2 = this.puntoMedio(b, c),
                ca2 = this.puntoMedio(c, a);
            this.pintaTriangulos(g, n-1, a, ab2, ca2);
            this.pintaTriangulos(g, n-1, ab2, b, bc2);
            this.pintaTriangulos(g, n-1, ca2, bc2, c);

        }
    }

    public static void main(String[] args) {
        SierpinskiGasket fractal = new SierpinskiGasket();
    }
}
