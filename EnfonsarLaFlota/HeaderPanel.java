import java.awt.*;
import javax.swing.*;

public class HeaderPanel extends JPanel {

  private JTextArea text;
  private Font font = new Font("Action Man Extended", Font.BOLD, 15);

  public HeaderPanel(){
    this.setBackground(Color.CYAN);
    text = new JTextArea();
    text.setBackground(Color.CYAN);
    text.setFont(font);
    text.setText("Enfonsar la flota");
    text.setEditable(false);
    this.add(text);   
  }

  public JTextArea getTextArea(){
    return text;
  }  
}