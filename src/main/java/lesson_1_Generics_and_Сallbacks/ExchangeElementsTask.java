package lesson_1_Generics_and_Сallbacks;

public class ExchangeElementsTask <T> {

    private T[] elements;

    public ExchangeElementsTask(T[] elements) {
        this.elements = elements;
    }

    public T[] exchangeElements (int firstIndex, int secondIndex){
        T tempElement = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = tempElement;

        return elements;
    }

    public void printArr (T[] elements, String comment){
        System.out.println(comment);
        for(T t : elements){
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public void showType(){
        System.out.println("Тип T: " + elements.getClass().getName());
    }

}
