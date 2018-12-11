package lesson_8_NetworkChat_part_2.Client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import lesson_8_NetworkChat_part_2.TimeNow;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import static lesson_8_NetworkChat_part_2.Constants.IPADRESS;
import static lesson_8_NetworkChat_part_2.Constants.PORT;


public class Controller {
    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    @FXML
    HBox bottomPanel;

    @FXML
    HBox upperPanel;

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    ListView<String> clientList;

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    private boolean isAuthorized;

    /**
     * В зависимости от того, авторизовался-ли пользователь,
     * метод меняет интерфейс программы
     * @param isAuthorized - авторизовался-ли пользователь
     */
    public void setAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
        if(!isAuthorized) {
            upperPanel.setVisible(true);
            upperPanel.setManaged(true);
            bottomPanel.setVisible(false);
            bottomPanel.setManaged(false);
            clientList.setVisible(false);
            clientList.setManaged(false);
        } else  {
            upperPanel.setVisible(false);
            upperPanel.setManaged(false);
            bottomPanel.setVisible(true);
            bottomPanel.setManaged(true);
            clientList.setVisible(true);
            clientList.setManaged(true);
        }
    }


    public void connect() {
        try {
            socket = new Socket(IPADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        authorization();
                        if (isAuthorized){
                            workWithServer();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                            System.out.println("Соединение с сервером закрыто");
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        setAuthorized(false);
                        System.exit(0);
                    }
                }
            });
            t1.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void authorization() throws IOException {
        while (true) {
            String str = in.readUTF();
            if(str.startsWith("/timeLimit")){
                out.writeUTF("/timeLimit");
                break;
            }
            if(str.startsWith("/authok")) {
                setAuthorized(true);
                break;
            } else {
                textArea.appendText(str + "\n");
            }
        }
    }

    public void workWithServer() throws IOException {
        while (true) {
            String str = in.readUTF();
            if(str.startsWith("/")) {
                if (str.equals("/serverClosed")) break;
                if(str.startsWith("/clientlist")) {
                    String[] tokens = str.split(" ");

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            clientList.getItems().clear();
                            for (int i = 1; i < tokens.length; i++) {
                                clientList.getItems().add(tokens[i]);
                            }
                        }
                    });
                }
            } else {
                textArea.appendText(str + "\n");
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            createWindow();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
            }
        }
    }


    public void createWindow() throws IOException {
        MiniStage miniStage = new MiniStage();
        miniStage.show();
    }

    public void sendMsg() {
        try {
            out.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void tryToAuth(ActionEvent actionEvent) {

        if(socket == null || socket.isClosed()) {
            connect();
        }
        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passwordField.getText());
            loginField.clear();
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
