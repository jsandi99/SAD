import java.awt.*;
import javax.swing.*;

public class FooterPanel extends JPanel {

  private JTextArea text;
  private Font font = new Font("Action Man Extended", Font.BOLD, 15);

  public FooterPanel(){
    this.setBackground(Color.YELLOW);
    text = new JTextArea();
    text.setBackground(Color.YELLOW);
    text.setFont(font);
    text.setText("Decidiu qui comença primer i premeu un boto");
    text.setEditable(false);    
    this.add(text);    
  }  

  public JTextArea getTextArea(){
    return text;
  }
}