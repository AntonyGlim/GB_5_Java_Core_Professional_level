package lesson_1_Generics_and_Сallbacks.task_3.fruits;

/**
 * Простой о-кт типа Яблоко, которому в конструкторе можно задать вес, и у которого определен тип
 */
public class Apple extends Fruit {

    public Apple(float weight) {
        super(weight);
        super.type = "Яблоко";
    }

}
