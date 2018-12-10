package lesson_5_Multithreading_Part_II.ShipsInTheSea;

/**
 * Класс описывает корабль.
 * shipCapacity - вместимость
 * shipSpeed - скорость корабля
 */
public class Ship {
    private int shipCapacity;
    private double shipSpeed;

    public Ship(int shipCapacity, double shipSpeed) {
        this.shipCapacity = shipCapacity;
        this.shipSpeed = shipSpeed;
    }

    public int getShipCapacity() {
        return shipCapacity;
    }

    public double getShipSpeed() {
        return shipSpeed;
    }

    public void setShipCapacity(int shipCapacity) {
        this.shipCapacity = shipCapacity;
    }

    public void setShipSpeed(double shipSpeed) {
        this.shipSpeed = shipSpeed;
    }
}
