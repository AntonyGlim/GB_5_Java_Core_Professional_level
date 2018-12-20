package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class MainShipsInTheSea {
    public static void main(String[] args) {
        SeaPort portStart = new SeaPort("Начало", 6000, 5700, 50);
        SeaPort portEnd = new SeaPort("Конец", 6000, 0, 50);
        SeaObstacles seaObstacles = new SeaObstacles(new OpenSea(100), new TunnelInTheSea(200), new OpenSea(80));
//        SeaAdventure openSea_1 = new OpenSea(100);
//        SeaAdventure tunel = new TunnelInTheSea(200);
//        SeaAdventure openSea_2 = new OpenSea(80);
        Ship ship_1 = new Ship("Победа", 1000, 0, 20);
//        SeaAdventure[] trip = {openSea_1, tunel, openSea_2};
        while (true){
            ship_1.loadShip(portStart);
            for (int i = 0; i < seaObstacles.getSeaAdventures().size(); i++) {
                seaObstacles.getSeaAdventures().get(i).go(ship_1);
            }
            System.out.println(portStart.getPortCapacity());
            System.out.println(portEnd.getPortCapacity());
            System.out.println("1111111111111111111111111");
            ship_1.reloadShip(portEnd);
            if (portStart.getPortCapacity() <= 0) break;
            for (int i = seaObstacles.getSeaAdventures().size() - 1; i >= 0; i--) {
                seaObstacles.getSeaAdventures().get(i).go(ship_1);
            }
            System.out.println(portStart.getPortCapacity());
            System.out.println(portEnd.getPortCapacity());
            System.out.println("222222222222222222222222");
        }
    }
}
