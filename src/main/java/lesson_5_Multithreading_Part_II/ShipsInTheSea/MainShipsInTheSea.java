package lesson_5_Multithreading_Part_II.ShipsInTheSea;

import java.math.BigInteger;

public class MainShipsInTheSea {
    static SeaPort portStart = new SeaPort("Начало", 6000, BigInteger.valueOf(5700), 50);
    static SeaPort portEnd = new SeaPort("Конец", 6000, BigInteger.valueOf(0), 50);

    public static void main(String[] args) {

        SeaObstacles seaObstacles = new SeaObstacles(new OpenSea(100), new TunnelInTheSea(200), new OpenSea(80));
        String[] shipsNames = {"Победа", "Беда", "Шхуна", "Верди", "Боцман"};
        for (int i = 0; i < shipsNames.length; i++) {
            new Thread(new Ship(seaObstacles, shipsNames[i], 1000, 0, 20)).start();
        }

        System.out.println("В начальном порту: " + portStart.getPortCapacity());
        System.out.println("В конечном порту: " + portEnd.getPortCapacity());
    }
}
