package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class SeaPort extends SeaAdventure{
    private int portCapacity;                       //Текущая вместимость порта, ед
    private int maxPortCapacity;                    //Максимальная вместимость порта, ед
    private int loadingSpeed;                       //Скорость погрузки на корабль ед/с
    private String portName;                        //Название порта

    public SeaPort(String portName,int maxPortCapacity, int portCapacity, int loadingSpeed) {
        this.portName = portName;
        this.portCapacity = portCapacity;
        this.maxPortCapacity = maxPortCapacity;
        this.loadingSpeed = loadingSpeed;
    }

    public int getPortCapacity() {
        return portCapacity;
    }

    public void setPortCapacity(int portCapacity) {
        this.portCapacity = portCapacity;
    }

    @Override
    public void go(Ship ship) {
        System.out.println("Корабль " + ship.getShipName() + " прибыл в порт " + portName);
        try {
            Thread.sleep(ship.getShipCapacity()/loadingSpeed);
            ship.setShipCapacity(100);
            portCapacity = portCapacity - ship.getShipCapacity();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Корабль " + ship.getShipName() + " закончил погрузку и покинул порт " + portName);
    }
}
