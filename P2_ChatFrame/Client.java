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

  public static void main(String[] args) throws IOException {
    mySocket = new MySocket("localhost", PORT);
    chat = new ChatFrame();

    iniciarBoto();

    new Thread(() -> { // Thread para leer del servidor y printar por pantalla

      String output;
      while ((output = mySocket.readLine()) != null) {
        chat.getConvers().append(output + "\n");
      }
    }).start();
  }

  public static void iniciarBoto() {
    chat.getButton().addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent actionEvent) {
            final String output = chat.getTextField().getText();
            if (output.isEmpty()) {
              JOptionPane.showMessageDialog(null,
                  "No pots enviar un missatge buit!",
                  "Missatge buit",
                  JOptionPane.ERROR_MESSAGE);
            } else {
              mySocket.printLine(output);
              chat.getConvers().append(output + "\n");
              chat.getTextField().setText("");
            }
          }
        });
  }
}
