package lesson_1_Generics_and_Сallbacks.task_3.boxes;

import lesson_1_Generics_and_Сallbacks.task_3.fruits.Fruit;
import java.util.ArrayList;

public class Box<F extends Fruit> {

    private ArrayList<F> frutsInBox;

    public Box(ArrayList<F> fruts) {
        this.frutsInBox = frutsInBox;
    }

    public float getWeight() {
        float weight = 0.0f;
        for (F f : frutsInBox) {
            weight += f.getWeight();
        }
        return weight;
    }

    public boolean compareBoxes (Box<?> anoter){
        return (this.getWeight() == anoter.getWeight());
    }
}
