import java.io.IOException;

import javax.swing.JOptionPane;

// import java.io.BufferedReader;
// import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client {

  public static final int PORT = 5000;
  private static ChatFrame chat;
  private static MySocket mySocket;
  private static String nickname;

  public static void main(String[] args) throws IOException {
    mySocket = new MySocket("localhost", PORT);
    chat = new ChatFrame();

    iniciarBoto();

    new Thread(() -> { // Thread para leer del servidor y printar por pantalla

      String output;
      while ((output = mySocket.readLine()) != null) {
        chat.getChatPanel().getChatText().append(output + "\n");
      }
    }).start();
  }

  public static void iniciarBoto() {
    chat.getLoginPanel().getJoinButton().addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent actionEvent) {
            final String output = chat.getLoginPanel().getNicknameField().getText();
            if (output.isEmpty()) {
              JOptionPane.showMessageDialog(null,
                  "No pots enviar un missatge buit!",
                  "Missatge buit",
                  JOptionPane.ERROR_MESSAGE);
            } else {
              mySocket.printLine(output);
              nickname = output;
              chat.setupChatPanel(nickname);
            }
          }
        });
    chat.getChatPanel().getSendButton().addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent actionEvent) {
            final String output = chat.getChatPanel().getMessageField().getText();
            if (output.isEmpty()) {
              JOptionPane.showMessageDialog(null,
                  "No pots enviar un missatge buit!",
                  "Missatge buit",
                  JOptionPane.ERROR_MESSAGE);
            } else {
              mySocket.printLine(output);
              chat.getChatPanel().getChatText().append(nickname + ": " + output + "\n");
              chat.getChatPanel().getMessageField().setText("");
            }
          }
        });
  }
}
