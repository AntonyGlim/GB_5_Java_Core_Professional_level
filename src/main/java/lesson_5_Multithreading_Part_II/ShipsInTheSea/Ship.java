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

    public void loadShip(SeaPort seaPort){
        if (seaPort.getPortCapacity() >= maxShipCapacity){
            shipCapacity = maxShipCapacity;
        }else {
            shipCapacity = seaPort.getPortCapacity();
        }
        seaPort.setPortCapacity(seaPort.getPortCapacity() - shipCapacity);
    }

    public void reloadShip(SeaPort seaPort){
        seaPort.setPortCapacity(seaPort.getPortCapacity() + shipCapacity);
        shipCapacity = 0;
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
