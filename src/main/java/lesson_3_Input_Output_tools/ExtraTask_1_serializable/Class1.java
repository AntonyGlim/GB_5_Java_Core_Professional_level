package lesson_3_Input_Output_tools.ExtraTask_1_serializable;

import java.io.*;

public class Class1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //сериализация о-та
        Player p = new Player("Fill", "Heroes5", 2, 80);
        p.playerInfo();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PlayerFromClient.pl"));
        oos.writeObject(p);
        oos.close();

        //десериализация о-та
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PlayerFromClient.pl"));
        Player p2 = (Player) ois.readObject();
        ois.close();
        p2.playerInfo();
    }
}
