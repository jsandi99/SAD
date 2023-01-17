import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

import javax.swing.*;

public class ChatFrame extends JFrame /* implements ActionListener */{

  // private JButton sendButton;
  // private JTextField textField;
  // private JPanel header;
  // private JTextArea convers;
  // private JPanel text;
  // private JLabel title;

  private final CardLayout contentCardLayout;
  private final JPanel contentPanel;
  private ChatPanel chatPanel;
  private LoginPanel loginPanel;

  public ChatFrame(){
    contentCardLayout = new CardLayout();
    contentPanel = new JPanel(contentCardLayout);
    add(contentPanel);
    setupLoginPanel();

    setVisible(true);
    //pack();
  }

  public void setupLoginPanel(){
    loginPanel = new LoginPanel();
    contentPanel.add(loginPanel, "1");
    contentCardLayout.show(contentPanel, "1");

    setTitle("Swing Chat");
    contentPanel.validate();
    contentPanel.repaint();
    setResizable(false);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    dim = new Dimension(400,200);
    setSize(dim);
    setLocationRelativeTo(null);
    contentPanel.setPreferredSize(dim);
    loginPanel.setPreferredSize(dim);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public void setupChatPanel(String nickname){
  chatPanel = new ChatPanel("Benvingut "+ nickname + "!\n");
  contentPanel.add(chatPanel, "3");
  contentCardLayout.show(contentPanel, "3");

  setTitle("Chat SAD");
  contentPanel.validate();
  contentPanel.repaint();
  setResizable(true);
  Dimension dim = new Dimension(700,700);
  setSize(dim);
  setLocationRelativeTo(null);
  contentPanel.setPreferredSize(dim);
  chatPanel.setPreferredSize(dim);
  setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
}


  // ChatFrame(){
  //   this.setResizable(false);
  //   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  //   setupLoginPanel();    
    
  //   this.setVisible(true);
  // }

  // public void setupLoginPanel(){
  //   loginPanel = new LoginPanel();
  //   loginPanel.setPreferredSize(new Dimension(500,200));
  //   this.setTitle("Login");
  //   this.add(loginPanel);
  // }

  // public void setupChatPanel(){
  //   this.setSize(500, 500);
  //   this.setLayout(new BorderLayout());
  //   this.setTitle("Chat");    

  //   textField = new JTextField();
  //   textField.setPreferredSize(new Dimension(405,50));

  //   title = new JLabel("Chat");

  //   header = new JPanel();
  //   header.setPreferredSize(new Dimension(500,50));
  //   header.setAlignmentX(CENTER_ALIGNMENT);
  //   header.setAlignmentY(CENTER_ALIGNMENT);
  //   header.add(title);
    
  //   convers = new JTextArea();
  //   convers.setBackground(new Color(204,236,239));
  //   convers.setPreferredSize(new Dimension(500,300));
  //   convers.setEditable(false);   
  //   convers.setLineWrap(true);
  //   JScrollPane scrollPanel = new JScrollPane(convers);
  //   scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  //   scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
  //   this.add(scrollPanel);

  //   text = new JPanel();
  //   text.setPreferredSize(new Dimension(500,50));
  //   text.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
 
  //   sendButton = new JButton("Enviar");
  //   sendButton.setPreferredSize(new Dimension(80,50));

  //   text.add(textField);
  //   text.add(sendButton);    

  //   this.add(header, BorderLayout.NORTH);
  //   this.add(convers, BorderLayout.CENTER);
  //   this.add(text, BorderLayout.SOUTH);
  // }

  /*public JPanel getText (){
    return text;
  }
  public JButton getButton(){
    return sendButton;
  }
  public JTextArea getConvers(){
    return convers;
  }
  public JTextField getTextField(){
    return textField;
  }*/
  // public LoginPanel getLoginPanel(){
  //   return loginPanel;
  // }

  public ChatPanel getChatPanel() { return chatPanel;}
  public LoginPanel getLoginPanel() { return loginPanel;}

}