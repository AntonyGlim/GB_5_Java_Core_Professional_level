package lesson_1_Generics_and_Сallbacks.task_3.fruits;

/**
 * Класс родитель для фруктов в котором описаны общие поля и методы
 */
public class Fruit {

    String type;

    private float weight;           //Вес фрукта

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }
}
