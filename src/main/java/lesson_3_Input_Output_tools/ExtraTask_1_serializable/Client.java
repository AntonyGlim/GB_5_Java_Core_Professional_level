package lesson_3_Input_Output_tools.ExtraTask_1_serializable;

import java.io.*;
import java.net.*;

public class Client {

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



//  РАБОТА ЧЕРЕЗ ФАЙЛ (для информации)
//        //сериализация о-та
//        Player p = new Player("Fill", "Heroes5", 2, 80);
//        p.playerInfo();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PlayerFromClient.pl"));
//        oos.writeObject(p);
//        oos.close();
//
//        //десериализация о-та
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PlayerFromClient.pl"));
//        Player p2 = (Player) ois.readObject();
//        ois.close();
//        p2.playerInfo();