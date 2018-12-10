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

    public Ship(int shipCapacity, int shipSpeed, String productType) {
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
        for (int i = 0; i < trevel.().size(); i++) {                             //Проходит препятствия
            race.getStages().get(i).go(this);
        }
    }
}
