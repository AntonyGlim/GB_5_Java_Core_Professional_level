package lesson_5_Multithreading_Part_II.ShipsInTheSea;

/**
 * Класс описывает корабль.
 * shipCapacity - вместимость
 * shipSpeed - скорость корабля
 */
public class Ship implements Runnable {
    private String name;
    private int shipCapacity;
    private int shipSpeed;
    private String productType;

    private SeaTrevel seaTrevel;

    public Ship(SeaTrevel seaTrevel, int shipCapacity, int shipSpeed, String productType) {
        this.seaTrevel = seaTrevel;
        this.shipCapacity = shipCapacity;
        this.shipSpeed = shipSpeed;
        this.productType = productType;
    }

    public int getShipCapacity() {
        return shipCapacity;
    }

    public int getShipSpeed() {
        return shipSpeed;
    }

    public String getName() {
        return name;
    }

    public void setShipCapacity(int shipCapacity) {
        this.shipCapacity = shipCapacity;
    }

    public void setShipSpeed(int shipSpeed) {
        this.shipSpeed = shipSpeed;
    }

    @Override
    public void run() {
        for (int i = 0; i < seaTrevel.getTrevel().size(); i++) {                             //Проходит препятствия
            seaTrevel.getTrevel().get(i).toDo(this);
        }
    }
}
