package lesson_5_Multithreading_Part_II.ShipsInTheSea;

import java.util.ArrayList;
import java.util.Arrays;

public class SeaTrevel {
    private ArrayList<Seaway> trevel;
    public ArrayList<Seaway> getTrevel() { return trevel; }
    public SeaTrevel(Seaway... trevel) {
        this.trevel = new ArrayList<Seaway>(Arrays.asList(trevel));
    }
}
