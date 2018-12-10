package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public class NarrowStrait extends Seaway {

    public NarrowStrait(int length) {
        this.length = length;
        this.description = "Узкий пролив " + length + " миль";
    }

    @Override
    public void toDo(Ship ship) {
        try {
            try {
                System.out.println(ship.getName() + " готовится к этапу(ждет): " + description);
//                smp.acquire();                                                                  //"Включаем красный"
                System.out.println(ship.getName() + " начал этап: " + description);
                Thread.sleep(length / ship.getShipSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(ship.getName() + " закончил этап: " + description);
//                smp.release();                                                                  //Освобождаем место для нового потока
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
