package lesson_5_Multithreading_Part_II.ShipsInTheSea;

import java.math.BigInteger;

public class MainShipsInTheSea {

    static final int SHIPSCOUNT = 9;                                                //Количество кораблей
    static final int portsCount = 3;

    public static void main(String[] args) {

        //Создаем порты начало
        SeaPort[] portsStartArr = {
                new SeaPort("ОдеждаНачало", 6000, BigInteger.valueOf(5700), 50),
                new SeaPort("ЕдаНачало", 8000, BigInteger.valueOf(7700), 40),
                new SeaPort("ТопливоНачало", 7000, BigInteger.valueOf(6900), 60)
        };

        //Создаем порты конец
        SeaPort[] portsEndArr = {
                new SeaPort("ОдеждаКонец", 7000, BigInteger.valueOf(0), 40),
                new SeaPort("ЕдаКонец", 9000, BigInteger.valueOf(0), 50),
                new SeaPort("ТопливоКонец", 8000, BigInteger.valueOf(0), 60)
        };

        //Создаем массив имен кораблей
        String[] shipsNames = new String[SHIPSCOUNT];
        for (int i = 0; i < SHIPSCOUNT; i++) {
            shipsNames[i] = "Корабль_" + (i + 1);
        }

        //Создаем полосу препятствий
        SeaObstacles seaObstacles = new SeaObstacles(new OpenSea(100), new TunnelInTheSea(200), new OpenSea(80));

        //Создаем корабли, в качестве параметров, передаем кораблям конкретный порт
        SeaPort portStart = portsStartArr[0];
        SeaPort portEnd = portsEndArr[0];
        for (int i = 0; i < shipsNames.length; i++) {
            if (i % portsCount == 0){
                portStart = portsStartArr[i/portsCount];
                portEnd = portsEndArr[i/portsCount];
            }
            new Thread(new Ship(seaObstacles, shipsNames[i], 20, portStart, portEnd)).start();
        }

        { //Блок для отладки, чтобы оценить сколько товаров в порту, после того как все все отвозили
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("В начальном порту: " + portStart.getPortCapacity());
//        System.out.println("В конечном порту: " + portEnd.getPortCapacity());
    }
}
