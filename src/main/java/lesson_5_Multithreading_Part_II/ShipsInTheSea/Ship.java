package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class Ship {
    private String shipName;                                            //Название корабля
    private int shipCapacity;                                           //Текущая вместимость корабля, ед
    private int maxShipCapacity;                                        //Максимальная вместимость корабля, ед
    private int shipSpeed;                                              //Скорость движения корабля миль/час

    public Ship(String shipName, int maxShipCapacity, int shipCapacity, int shipSpeed) {
        this.shipName = shipName;
        this.shipCapacity = shipCapacity;
        this.maxShipCapacity = maxShipCapacity;
        this.shipSpeed = shipSpeed;
    }

    public int getShipCapacity() {
        return shipCapacity;
    }

    public String getShipName() {
        return shipName;
    }

    public int getShipSpeed() {
        return shipSpeed;
    }

    public void setShipCapacity(int shipCapacity) {
        this.shipCapacity = shipCapacity;
    }
}
