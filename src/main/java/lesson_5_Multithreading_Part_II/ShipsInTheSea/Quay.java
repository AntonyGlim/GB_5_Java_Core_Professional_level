package lesson_5_Multithreading_Part_II.ShipsInTheSea;

/**
 * Класс описывает причал(морской порт)
 * capacity - количество товара в порту;
 * productDescription - тип товара и его описание
 */
public class Quay {
    private int capacity;
    private String productDescription;

    public int getCapacity() {
        return capacity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
