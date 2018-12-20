package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class OpenSea  extends SeaAdventure{

    public OpenSea(int openSeaLength) {
        length = openSeaLength;
        description = "открытое море";
    }

    @Override
    public void go(Ship ship) {
        System.out.println("Корабль " + ship.getShipName() + "(" + ship.getShipCapacity() + ")" + " начал этап" + description + ", протяженностьью " + length);
        try {
            Thread.sleep(1000 + (int)Math.random()*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Корабль " + ship.getShipName() + "(" + ship.getShipCapacity() + ")" + " завершил этап" + description + ", протяженностьью " + length);
    }
}
