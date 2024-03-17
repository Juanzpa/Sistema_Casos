package sv.edu.udb.sistemas.JefeAreaFuncional;
import java.awt.*;
import javax.swing.*;

public class SolicitudCasos extends JFrame{
    private JTabbedPane tabbedPane1;
    private JButton enviarButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JComboBox comboBox1;
    private JPanel JpJArea;
    private JProgressBar progressBar1;
    private JComboBox comboBox2;

    public SolicitudCasos(String panel) {
        super(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JpJArea);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
    }


    public static void main(String[] args){
    JFrame frame = new SolicitudCasos("panel");
    frame.setVisible(true);
    }
}
