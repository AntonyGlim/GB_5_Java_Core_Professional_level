package lesson_1_Generics_and_Сallbacks.task_3.fruits;
/**
 * Простой о-кт типа Апельсин, которому в конструкторе можно задать вес, и у которого определен тип
 */
public class Orange extends Fruit {

    public Orange(float weight) {
        super(weight);
        super.type = "Апельсин";
    }

}
