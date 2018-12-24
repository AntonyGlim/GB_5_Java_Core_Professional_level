package lesson_5_Multithreading_Part_II.ShipsInTheSea;

import java.math.BigInteger;

public class Ship implements Runnable {
    private SeaObstacles seaObstacles;                                  //Морские препятствия
    private String shipName;                                            //Название корабля
    private int shipCapacity;                                           //Текущая вместимость корабля, ед
    private int maxShipCapacity;                                        //Максимальная вместимость корабля, ед
    private int shipSpeed;                                              //Скорость движения корабля миль/час
    private SeaPort portStart;
    private SeaPort portEnd;

    public Ship(SeaObstacles seaObstacles, String shipName, int shipSpeed, SeaPort portStart, SeaPort portEnd) {
        this.seaObstacles = seaObstacles;
        this.shipName = shipName;
        this.shipCapacity = 0;
        this.maxShipCapacity = 4000;
        this.shipSpeed = shipSpeed;
        this.portStart = portStart;
        this.portEnd = portEnd;
    }

    @Override
    public void run() {
        while (true){
            this.loadShip(portStart);
            for (int i = 0; i < seaObstacles.getSeaAdventures().size(); i++) {
                seaObstacles.getSeaAdventures().get(i).go(this);
            }
            //Блок вывода вспомогательной информации
//            {
//                System.out.println(portStart.getPortCapacity());
//                System.out.println(portEnd.getPortCapacity());
//                System.out.println("1111111111111111111111111");
//            }
            this.reloadShip(portEnd);
            if (portStart.getPortCapacity().intValue() == 0) break;
            for (int i = seaObstacles.getSeaAdventures().size() - 1; i >= 0; i--) {
                seaObstacles.getSeaAdventures().get(i).go(this);
            }
            //Блок вывода вспомогательной информации
//            {
//                System.out.println(portStart.getPortCapacity());
//                System.out.println(portEnd.getPortCapacity());
//                System.out.println("222222222222222222222222");
//            }
        }
        portStart.seaPortInformation();
        portEnd.seaPortInformation();
    }

    /**
     * Метод описывает погрузку корабля
     * @param seaPort - морской порт
     */
    public synchronized void loadShip(SeaPort seaPort){
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")"
                + " прибыл в порт " + seaPort.getPortName()
                + ", и готовиться к погрузке");
        if (seaPort.getPortCapacity().intValue() >= maxShipCapacity){
            shipCapacity = maxShipCapacity;
        }else if (seaPort.getPortCapacity().intValue() < maxShipCapacity && seaPort.getPortCapacity().intValue() != 0) {
            shipCapacity = seaPort.getPortCapacity().intValue();
        }else {
            return;
        }
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")"
                + " начал погрузку в порту " + seaPort.getPortName());
        seaPort.setPortCapacity(BigInteger.valueOf(seaPort.getPortCapacity().intValue() - shipCapacity));
        try {
            Thread.sleep(10000 + (int) Math.random() * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">>> Корабль " + shipName + "(" + shipCapacity + ")"
                + " завершил погрузку в порту " + seaPort.getPortName());
    }

    /**
     * Метод описывает разгрузку корабля
     * @param seaPort - морской порт
     */
    public synchronized void reloadShip(SeaPort seaPort){
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")"
                + " прибыл в порт " + seaPort.getPortName()
                + ", и ожидает разгрузки");
        System.out.println("Корабль " + shipName + "(" + shipCapacity + ")"
                + " начал разгрузку в порту " + seaPort.getPortName());
        seaPort.setPortCapacity(BigInteger.valueOf(seaPort.getPortCapacity().intValue() + shipCapacity));
        shipCapacity = 0;
        System.out.println(">>>>>> Корабль " + shipName + "(" + shipCapacity + ")"
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
