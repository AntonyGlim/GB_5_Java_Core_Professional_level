/**
 * Доп.дз
 * 1 Есть транспортные корабли, которые подплывают к проливу и далее
 *   плывут к причалам для погрузки разного рода товара.
 * 2 Они проходят через узкий пролив где одновременно могут находиться
 *   только 2 корабля.
 * 3 Вид кораблей и их вместительность могут быть разными в зависимости от типа товаров,
 *   которые нужно загрузить на корабль. (Представим что корабли везут Одежду, Еду, Топливо)
 * 4 Есть 3 вида причалов для погрузки кораблей в соотвествие с товарами,
 *   за одну секунду причал загружает на корабль 100 ед. товара, вместимость кораблей 500.
 * 5 После загрузки нужно пройти обратно через пролив и перевести товар.
 * 6 Нужно перевести 2700 ед. одежды, 5900 еды, 8500 топлива.
 * Перевести груз.
 * Правильно разбить задачу на параллельность.
 * Синхронизировать потоки, сохранить целостность данных.
 */
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
