package lesson_1_Generics_and_Сallbacks.task_3.boxes;

import lesson_1_Generics_and_Сallbacks.task_3.fruits.Fruit;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс создает о-кт коробка  для хранения фруктов
 * @param <F> - обобщенный тип данных Fruit и его подклассы
 */
public class Box<F extends Fruit> {                     //Класс сможет принять только тип Fruit и все его подклассы

    private ArrayList<F> fruitsInBox;                   //В листе храняться все фрукты добавленные в коробку
    private float weight;                               //Общий вес коробки (складывается из суммы всех фруктов)

    /**
     * В конструкторе создаем новый лист
     */
    public Box() {
        fruitsInBox = new ArrayList<F>();
    }

    /**
     * Метод позволяет добавить фрукт в коробку.
     * Если коробка пуста, то в нее можно положить любой фрукт
     * Если в коробке есть хотя-бы один фрукт, то в нее можно будет добавить
     * только фрукты того же типа.
     * @param fruit
     */
    public void add (F fruit){
        if(fruitsInBox.isEmpty()){
            fruitsInBox.add(fruit);
            System.out.println("Фрукт тпа " + fruitsInBox.get(0).getName() + " - добавлен");
        } else if (isTypesEquals(fruit)){
            fruitsInBox.add(fruit);
            System.out.println("Фрукт тпа " + fruitsInBox.get(0).getName() + " - добавлен");
        } else {
            System.out.print("Нельзя добавить фрукт типа " + fruit.getName());
            System.out.println(". В коробке находятся фрукты типа: " + fruitsInBox.get(0).getName());
        }
    }

    /**
     * Подсчет веса фруктов в коробке
     * @return - Вернет вес коробки (сумму весов всех элементов коробки)
     */
    public float getWeight() {
        this.weight = 0.0f;
        for (F f : fruitsInBox) {
            weight += f.getWeight();
        }
        return this.weight;
    }

    /**
     * Метод сравнивает две коробки с разными типами
     * Если разница весов, взятая по модулю, меньше маленького числа (т.к. тип float)
     * <?> - метасимвольный аргумент типа, позволит нам сравнить о-ты разных типов
     * @param another
     * @return
     */
    public boolean compareBoxes (Box<?> another){
        return (Math.abs(this.getWeight() - another.getWeight()) <= 0.001);
    }

    /**
     * Метод пересыпает фрукты из одной коробки в другую,
     * если тип коробок совпадет
     * @param another
     */
    public void pourFruitIn (Box<F> another){
        while(!fruitsInBox.isEmpty()){
            another.add(fruitsInBox.remove(fruitsInBox.size() - 1));
        }
    }

    /**
     * Метод проверяет совпадают-ли типы элементов находящихся в листах
     * @param fruit - элемент стороннего листа
     * @return - да/нет
     */
    public boolean isTypesEquals(F fruit){
        return (fruit.getClass().getName().toString().equals(fruitsInBox.get(0).getClass().getName()));
    }

    /**
     * Получить лист с фруктами, находящимися в коробке
     * @return
     */
    public ArrayList<F> getFruitsInBox() {
        return fruitsInBox;
    }
}
