package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class MainShipsInTheSea {
    static SeaPort portStart = new SeaPort("Начало", 6000, 5700, 50);
    static SeaPort portEnd = new SeaPort("Конец", 6000, 0, 50);

    public static void main(String[] args) {

        SeaObstacles seaObstacles = new SeaObstacles(new OpenSea(100), new TunnelInTheSea(200), new OpenSea(80));
//        Ship ship_1 = new Ship(seaObstacles, "Победа", 1000, 0, 20);

        Thread t1 = new Thread(new Ship(seaObstacles, "Победа", 1000, 0, 20));
        t1.start();

//        while (true){
//            ship_1.loadShip(portStart);
//            for (int i = 0; i < seaObstacles.getSeaAdventures().size(); i++) {
//                seaObstacles.getSeaAdventures().get(i).go(ship_1);
//            }
//            System.out.println(portStart.getPortCapacity());
//            System.out.println(portEnd.getPortCapacity());
//            System.out.println("1111111111111111111111111");
//            ship_1.reloadShip(portEnd);
//            if (portStart.getPortCapacity() <= 0) break;
//            for (int i = seaObstacles.getSeaAdventures().size() - 1; i >= 0; i--) {
//                seaObstacles.getSeaAdventures().get(i).go(ship_1);
//            }
//            System.out.println(portStart.getPortCapacity());
//            System.out.println(portEnd.getPortCapacity());
//            System.out.println("222222222222222222222222");
//        }
    }
}
