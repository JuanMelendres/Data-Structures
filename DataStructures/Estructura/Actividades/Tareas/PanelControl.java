/*
    Autor: A00369017 Juan Antonio Melendres Villa
    Nombre de la clase: PanelControl
    Fecha: 23/01/18
    Comentarios: none
*/
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Dimension;

public class PanelControl extends JPanel implements ChangeListener{
    private JSlider slider;
    private ReglaRecursiva rr;

    public PanelControl(ReglaRecursiva rr){
        super();
        this.rr = rr;
        this.setPreferredSize(new Dimension(50, 50));
        this.slider = new JSlider(JSlider.VERTICAL, 0, 10, 1);
        this.slider.setMajorTickSpacing(10);
        this.slider.setMinorTickSpacing(1);
        this.slider.setPaintTicks(true);
        this.slider.setPaintLabels(true);
        this.add(this.slider);
        this.slider.addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e){
        this.rr.setNivel(slider.getValue());
    }
}
