/**
 * 3. Большая задача:
 * Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
 * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
 *      поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * Для хранения фруктов внутри коробки можно использовать ArrayList;
 * Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
 *      (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
 * Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
 *      которую подадут в compare в качестве параметра, true – если она равны по весу,
 *      false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую (помним про сортировку фруктов:
 *      нельзя яблоки высыпать в коробку с апельсинами). Соответственно, в текущей коробке фруктов не остается,
 *      а в другую перекидываются объекты, которые были в этой коробке;
 * Не забываем про метод добавления фрукта в коробку.
 */
package lesson_1_Generics_and_Сallbacks.task_3;

import lesson_1_Generics_and_Сallbacks.task_3.boxes.Box;
import lesson_1_Generics_and_Сallbacks.task_3.fruits.Apple;
import lesson_1_Generics_and_Сallbacks.task_3.fruits.Fruit;
import lesson_1_Generics_and_Сallbacks.task_3.fruits.Orange;

public class MainBoxFruitTask {

    public static void main(String[] args) {

        Box<Fruit> box_1 = new Box();                                               //Тип Fruit установлен, чтобы можно было ПОПЫТАТЬСЯ добавить фрукты разного типа
        System.out.println("Коробка 1 пуста. Ее вес: " + box_1.getWeight());
        box_1.add(new Apple(1.0f));                                         //Заполняем коробку фруктами
        box_1.add(new Apple(2.1f));
        box_1.add(new Apple(2.1f));
        box_1.add(new Orange(1.2f));                                        //Безуспешная попытка добавить фрукт другого типа
        System.out.println("Коробку 1 заполнили. Ее вес: " + box_1.getWeight());    //Выводим вес фруктов в коробке для информации
        System.out.println();

        Box<Fruit> box_2 = new Box();
        System.out.println("Коробка 2 пуста. Ее вес: " + box_2.getWeight());
        box_2.add(new Orange(1.8f));
        box_2.add(new Orange(1.7f));
        box_2.add(new Orange(1.7f));
        box_2.add(new Apple(1.7f));
        System.out.println("Коробку 2 заполнили. Ее вес: " + box_2.getWeight());
        System.out.println();

        Box<Fruit> box_3 = new Box();
        System.out.println("Коробка 3 пуста. Ее вес: " + box_3.getWeight());
        box_3.add(new Orange(1.8f));
        box_3.add(new Orange(1.1f));
        box_3.add(new Orange(1.7f));
        System.out.println("Коробку 3 заполнили. Ее вес: " + box_3.getWeight());
        System.out.println();

        Box<Fruit> box_4 = new Box();
        System.out.println("Коробка 3 пуста. Ее вес: " + box_4.getWeight());
        box_4.add(new Apple(2.2f));
        box_4.add(new Apple(1.1f));
        box_4.add(new Apple(2.3f));
        System.out.println("Коробку 3 заполнили. Ее вес: " + box_4.getWeight());
        System.out.println();

        //Блок сравнения весов в разных коробках
        System.out.println("Вес коробки 1 равен весу коробки 2? : " + box_1.compareBoxes(box_2));
        System.out.println("Вес коробки 1 равен весу коробки 3? : " + box_1.compareBoxes(box_3));
        System.out.println("Вес коробки 1 равен весу коробки 4? : " + box_1.compareBoxes(box_4));
    }


}
