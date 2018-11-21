package lesson_1_Generics_and_Сallbacks.task_3.boxes;

import lesson_1_Generics_and_Сallbacks.task_3.fruits.Fruit;
import java.util.ArrayList;

public class Box<F extends Fruit> {

    private ArrayList<F> fruitsInBox;
    private float weight;

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
        } else if (fruit.getClass().getName().toString().equals(fruitsInBox.get(0).getClass().getName())){
            fruitsInBox.add(fruit);
            System.out.println("Фрукт тпа " + fruitsInBox.get(0).getName() + " - добавлен");
        } else {
            System.out.print("Нельзя добавить фрукт типа " + fruit.getName());
            System.out.println(". В коробке находятся фрукты типа: " + fruitsInBox.get(0).getName());
        }
    }

    public float getWeight() {
        this.weight = 0.0f;
        for (F f : fruitsInBox) {
            weight += f.getWeight();
        }
        return this.weight;
    }

    public boolean compareBoxes (Box<?> another){
        return (this.getWeight() == another.getWeight());
    }
}
