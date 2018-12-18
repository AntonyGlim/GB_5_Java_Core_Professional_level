package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class OpenSea  extends SeaAdventure{
    private int openSeaLength;              //Протяженность, миль

    public OpenSea(int openSeaLength) {
        this.openSeaLength = openSeaLength;
    }

    @Override
    public void go(Ship ship) {
        System.out.println("Корабль " + ship.getShipName() + "(" + ship.getShipCapacity() + ")" + " начал этап открытое море, протяженностьью " + openSeaLength);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Корабль " + ship.getShipName() + "(" + ship.getShipCapacity() + ")" + " завершил этап открытое море, протяженностьью " + openSeaLength);
    }
}
