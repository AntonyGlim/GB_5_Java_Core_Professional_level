package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class SeaPort {
    private int portCapacity;                       //Вместимость порта, ед
    private int loadingSpeed;                       //Скорость погрузки на корабль ед/с
    private String portName;                        //Название порта

    public SeaPort(int portCapacity, int loadingSpeed, String portName) {
        this.portCapacity = portCapacity;
        this.loadingSpeed = loadingSpeed;
        this.portName = portName;
    }


}
