package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class Ship {
    private String shipName;                                            //Название корабля
    private int shipCapacity;                                           //Вместимость корабля, ед
    private int shipSpeed;                                              //Скорость движения корабля миль/час

    public Ship(String shipName, int shipCapacity, int shipSpeed) {
        this.shipName = shipName;
        this.shipCapacity = shipCapacity;
        this.shipSpeed = shipSpeed;
    }
}
