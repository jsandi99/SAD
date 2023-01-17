import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private JButton join;
    private JTextField nom;
    private JLabel titol;

    public LoginPanel(){
        this.setBackground(Color.CYAN);
        this.setLayout(new BorderLayout());

        titol = new JLabel("Introdueix el teu nom d'usuari: ");
        this.add(titol, BorderLayout.NORTH);

        nom = new JTextField();
        this.add(nom, BorderLayout.CENTER);

        join = new JButton();
        this.add(join, BorderLayout.EAST);
    }

    public JButton getButton(){
        return join;
    }    
    public JTextField getNomField(){
        return nom;
    }
}
