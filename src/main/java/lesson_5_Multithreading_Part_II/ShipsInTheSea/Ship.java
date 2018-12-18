package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class Ship implements Runnable {
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

    @Override
    public void run() {

    }

    public void loadShip(SeaPort seaPort){
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")" + " прибыл в порт " + seaPort.getPortName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (seaPort.getPortCapacity() >= maxShipCapacity){
            shipCapacity = maxShipCapacity;
        }else {
            shipCapacity = seaPort.getPortCapacity();
        }
        seaPort.setPortCapacity(seaPort.getPortCapacity() - shipCapacity);
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")" + " завершил погрузку в порту " + seaPort.getPortName());
    }

    public void reloadShip(SeaPort seaPort){
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")" + " прибыл в порт " + seaPort.getPortName());
        seaPort.setPortCapacity(seaPort.getPortCapacity() + shipCapacity);
        shipCapacity = 0;
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")" + " завершил разгрузку в порту " + seaPort.getPortName());
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
