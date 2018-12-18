package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class MainShipsInTheSea {
    public static void main(String[] args) {
        SeaPort portStart = new SeaPort("Порт Начало", 6000, 5700, 50);
        SeaPort portEnd = new SeaPort("Порт Конец", 6000, 0, 50);
        Ship ship_1 = new Ship("Победа", 100, 20);
    }
}
