package lesson_1_Generics_and_Сallbacks;

public class MainGenericsTask <T> {

    private T[] elements;

    public MainGenericsTask(T[] elements) {
        this.elements = elements;
    }

    public T[] exchangeElements (int firstIndex, int secondIndex){
        T tempElement = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = tempElement;

        return elements;
    }

}
