package lesson_3_Input_Output_tools.ExtraTask_1_serializable;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String game;
    private int playHours;
    private int level;

    public Player(String name, String game, int playHours, int level) {
        this.name = name;
        this.game = game;
        this.playHours = playHours;
        this.level = level;
    }

    public void playerInfo(){
        System.out.println(name + " " + game + " " + playHours + " " + level);

    }
}
