package lesson_1_Generics_and_Сallbacks.task_3.fruits;

public abstract class Fruit {

    String name;

    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
