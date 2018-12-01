
package lesson_3_Input_Output_tools.ExtraTask_1_serializable.client;

import lesson_3_Input_Output_tools.ExtraTask_1_serializable.Player;

import java.io.*;
import java.net.*;

public class cli {

    public static void main(String args[]) {

        try {

        //Создадим сокет и потоки
            Socket socket = new Socket(InetAddress.getLocalHost(), 8011);
            OutputStream o = socket.getOutputStream();
            ObjectOutput oos = new ObjectOutputStream(o);

        //Создадим экземпляр класса Player
            Player p = new Player("Fill", "Heroes5", 2, 80);

        //Сериализуем объект класса Player и отправим его
            oos.writeObject(p);
            oos.flush();
            oos.close();

        } catch (Exception e) {
            System.out.println("Ошибка серриализации!");
            System.exit(1);
        }
    }
}
