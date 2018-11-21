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
        fruitsInBox.add(fruit);
    }

    public float getWeight() {
        this.weight = 0.0f;
        for (F f : fruitsInBox) {
            weight += f.getWeight();
        }
        return this.weight;
    }

    public boolean compareBoxes (Box<?> anoter){
        return (this.getWeight() == anoter.getWeight());
    }
}
