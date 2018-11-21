package lesson_1_Generics_and_Сallbacks.task_3.boxes;

import lesson_1_Generics_and_Сallbacks.task_3.fruits.Fruit;
import java.util.ArrayList;

public class Box<F extends Fruit> {

    private ArrayList<F> fruitsInBox;
    private float weight;

    public Box() {
        fruitsInBox = new ArrayList<F>();
    }

    public void add (F fruit){
        if(fruitsInBox.isEmpty()){
            fruitsInBox.add(fruit);
        } else if (fruit.getClass().getName().toString().equals(fruitsInBox.get(0).getClass().getName())){
            fruitsInBox.add(fruit);
            System.out.println("Фрукт добавлен");
        } else {
            System.out.println("В коробке находятся фрукты другого типа");
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
