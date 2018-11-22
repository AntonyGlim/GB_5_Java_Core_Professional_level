package lesson_1_Generics_and_Сallbacks.task_3.fruits;

/**
 * Класс родитель для фруктов в котором описаны общие поля и методы
 */
public class Fruit {

    String type;                    //Тип фрукта

    private float weight;           //Вес фрукта

    public Fruit(float weight) {    //В конструкторе задаем вес
        this.weight = weight;
    }

    public float getWeight() {      //Вернет вес фрукта
        return weight;
    }

    public String getType() {       //Вернет тип фрукта
        return type;
    }
}
