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

    /**
     * Метод описывает погрузку корабля
     * @param seaPort - морской порт
     */
    public void loadShip(SeaPort seaPort){
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")"
                + " прибыл в порт " + seaPort.getPortName()
                + ", и ожидает погрузки");
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")"
                + " начал погрузку");
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
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")"
                + " завершил погрузку в порту " + seaPort.getPortName());
    }

    /**
     * Метод описывает разгрузку корабля
     * @param seaPort - морской порт
     */
    public void reloadShip(SeaPort seaPort){
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")"
                + " прибыл в порт " + seaPort.getPortName()
                + ", и ожидает разгрузки");
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")"
                + " начал разгрузку");
        seaPort.setPortCapacity(seaPort.getPortCapacity() + shipCapacity);
        shipCapacity = 0;
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")"
                + " завершил разгрузку в порту " + seaPort.getPortName());
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
