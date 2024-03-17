package sv.edu.udb.sistemas.JefeAreaFuncional;

import javax.swing.*;
import java.awt.*;

public class prueva extends JFrame {

    private JPanel JJPanel;

    public prueva(String panel) {
        super(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JJPanel);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
    }


    public static void main(String[] args){
        JFrame frame = new prueva("panel");
        frame.setVisible(true);
    }
}





