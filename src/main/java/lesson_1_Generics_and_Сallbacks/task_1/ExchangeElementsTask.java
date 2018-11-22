package lesson_1_Generics_and_Сallbacks.task_1;

public class ExchangeElementsTask <T> {

    private T[] elements;                           //массив типа Т

    public ExchangeElementsTask(T[] elements) {
        this.elements = elements;
    }

    /**
     * Метод меняет элементы местами по индексам через буфер
     * @param firstIndex
     * @param secondIndex
     * @return массив элементов
     */
    public T[] exchangeElements (int firstIndex, int secondIndex){
        T tempElement = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = tempElement;
        return elements;
    }

    /**
     * Метод выведет массив на экран
     * @param elements
     * @param comment
     */
    public void printArr (T[] elements, String comment){
        System.out.println(comment);
        for(T t : elements){
            System.out.print(t + " ");
        }
        System.out.println();
    }

    /**
     * Метод выведет на экран тип массива элементов
     */
    public void showType(){
        System.out.println("Тип T: " + elements.getClass().getName());
    }

}
