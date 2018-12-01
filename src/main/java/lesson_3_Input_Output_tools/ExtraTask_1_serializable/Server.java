package lesson_3_Input_Output_tools.ExtraTask_1_serializable;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String args[]) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        Player p2 = null;

        try {
            serverSocket = new ServerSocket(8011);

            socket = serverSocket.accept();
            InputStream o = socket.getInputStream();
            ObjectInput ois = new ObjectInputStream(o);
            p2 = (Player) ois.readObject();
            ois.close();

            //Выведем информацию, которую получили от клиента
            p2.playerInfo();

        } catch (Exception e) {
            System.out.println("Ошибка десерриализации!");
            System.exit(1);
        }
    }
}
