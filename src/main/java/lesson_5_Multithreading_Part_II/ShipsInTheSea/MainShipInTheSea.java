package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class MainShipInTheSea {
    public static void main(String[] args) {
        System.out.println("ПЕРЕВОЗКА ГРУЗОВ ----> ПОДГОТОВКА КОРАБЛЕЙ");
        SeaTrevel seaTrevel = new SeaTrevel(new LoadingAtThePort(), new OpenSea(20), new NarrowStrait(50), new OpenSea(40), new LoadingAtThePort());
        Ship[] ships = new Ship[9];
        System.out.println("ПЕРЕВОЗКА ГРУЗОВ ----> КОРАБЛИ ГОТОВЫ ПРИСТУПИТЬ К ПОГРУЗКЕ");
        System.out.println("ПЕРЕВОЗКА ГРУЗОВ ----> ПОГРУЗКА НАЧАЛАСЬ!");
        System.out.println("ПЕРЕВОЗКА ГРУЗОВ ----> ВСЕ ГРУЗЫ ПЕРЕВЕЗЕНЫ. КОНЕЦ");
    }
}
