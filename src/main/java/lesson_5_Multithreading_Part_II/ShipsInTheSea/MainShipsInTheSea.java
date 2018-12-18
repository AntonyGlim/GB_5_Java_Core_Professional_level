package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class MainShipsInTheSea {
    public static void main(String[] args) {
        SeaPort portStart = new SeaPort("Порт Начало", 6000, 5700, 50);
        SeaPort portEnd = new SeaPort("Порт Конец", 6000, 0, 50);
        OpenSea openSea = new OpenSea(100);
        Ship ship_1 = new Ship("Победа", 100, 0, 20);
        SeaAdventure[] trip = {openSea};
        while (true){
            for (int i = 0; i < trip.length; i++) {
                portStart.go(ship_1);
                trip[i].go(ship_1);
            }
            if (portStart.getPortCapacity() == 0) break;
            for (int i = trip.length - 1; i <= 0; i--) {
                portEnd.go(ship_1);
                trip[i].go(ship_1);
            }
        }
    }
}
