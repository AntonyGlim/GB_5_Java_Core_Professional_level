package lesson_5_Multithreading_Part_II.ShipsInTheSea;

import java.math.BigInteger;

public class SeaPort extends SeaAdventure{
    private BigInteger portCapacity;                //Текущая вместимость порта, ед BigInteger - для синхронизации
    private int maxPortCapacity;                    //Максимальная вместимость порта, ед
    private int loadingSpeed;                       //Скорость погрузки на корабль ед/с
    private String portName;                        //Название порта

    public SeaPort(String portName,int maxPortCapacity, BigInteger portCapacity, int loadingSpeed) {
        this.portName = portName;
        this.portCapacity = portCapacity;
        this.maxPortCapacity = maxPortCapacity;
        this.loadingSpeed = loadingSpeed;
    }

    public BigInteger getPortCapacity() {
        return portCapacity;
    }

    public void setPortCapacity(BigInteger portCapacity) {
        this.portCapacity = portCapacity;
    }

    public String getPortName() {
        return portName;
    }

    @Override
    public void go(Ship ship) {
//
    }
}
