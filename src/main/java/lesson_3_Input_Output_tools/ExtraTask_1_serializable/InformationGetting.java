package lesson_3_Input_Output_tools.ExtraTask_1_serializable;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Класс предназначен для получения информации извне
 */
public class InformationGetting  implements Runnable{

    private Socket socket;
    private DataInputStream in;


    public InformationGetting(Socket socket) throws IOException {
        this.socket = socket;
        in = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {                                                  //Получение сообщений
                String msg = in.readUTF();
                System.out.println(msg);
                if (msg.equalsIgnoreCase("/q")) System.exit(0);             //У меня не получилось выйти иначе! Пояните, пожалуйста, как правильно выйти и закрыть все потоки

                //десериализация о-та
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PlayerFromClient.pl"));
                Player p2 = (Player) ois.readObject();
                ois.close();
                p2.playerInfo();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            in.close();
            System.out.println("in.close() - done (InformationGetting)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}