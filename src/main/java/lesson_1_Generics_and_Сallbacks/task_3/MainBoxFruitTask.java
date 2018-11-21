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
    //TODO метод isTypeCorrect проверяет, соответствует-ли тип элемента, который мы хотим добавить тому типу, который уже имеет коробка
    public static void main(String[] args) {

        Box<Fruit> box_1 = new Box();
        System.out.println(box_1.getWeight());
        box_1.add(new Apple(1.2f));
        box_1.add(new Apple(1.2f));
        box_1.add(new Apple(1.2f));
        box_1.add(new Apple(1.2f));
        box_1.add(new Orange(1.2f));
        System.out.println(box_1.getWeight());

    }


}
