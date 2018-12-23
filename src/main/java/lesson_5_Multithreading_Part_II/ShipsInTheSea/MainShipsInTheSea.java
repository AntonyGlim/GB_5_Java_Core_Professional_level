package lesson_5_Multithreading_Part_II.ShipsInTheSea;

import java.math.BigInteger;

public class MainShipsInTheSea {

    public static void main(String[] args) {

        SeaPort[] portsStartArr = {
                new SeaPort("ОдеждаНачало", 6000, BigInteger.valueOf(5700), 50),
                new SeaPort("ЕдаНачало", 8000, BigInteger.valueOf(7700), 40),
                new SeaPort("ТопливоНачало", 7000, BigInteger.valueOf(6900), 60)
        };
        SeaPort[] portsEndArr = {
                new SeaPort("ОдеждаКонец", 7000, BigInteger.valueOf(0), 40),
                new SeaPort("ЕдаКонец", 9000, BigInteger.valueOf(0), 50),
                new SeaPort("ТопливоКонец", 8000, BigInteger.valueOf(0), 60)
        };
        String[] shipsNames = null;
        for (int i = 0; i < 9; i++) {
            shipsNames[i] = "Корабль_" + (i + 1);
        }
        
        SeaObstacles seaObstacles = new SeaObstacles(new OpenSea(100), new TunnelInTheSea(200), new OpenSea(80));

        for (int i = 0; i < shipsNames.length; i++) {
            new Thread(new Ship(seaObstacles, shipsNames[i], 1000, 0, 20)).start();
        }
        { //Блок для отладки, чтобы оценить сколько товаров в порту, после того как все все отвозили
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("В начальном порту: " + portStart.getPortCapacity());
//        System.out.println("В конечном порту: " + portEnd.getPortCapacity());
    }
}
