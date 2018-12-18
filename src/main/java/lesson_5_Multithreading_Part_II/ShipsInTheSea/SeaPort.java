package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class SeaPort {
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


}
