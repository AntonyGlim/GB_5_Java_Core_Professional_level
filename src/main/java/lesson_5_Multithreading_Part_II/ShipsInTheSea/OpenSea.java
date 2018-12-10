package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class OpenSea extends Seaway {

    public OpenSea(int length) {
        this.length = length;
        this.description = "Открытое море " + length + " миль";
    }

    @Override
    public void toDo(Ship ship) {
        try {
            System.out.println(ship.getName() + " начал этап: " + description);
            Thread.sleep(length / ship.getShipSpeed() * 1000);
            System.out.println(ship.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
