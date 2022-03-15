package bejeweled;

import core.GameLauncher;
import core.GameRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Launcher {
    public static void main(String[] args){
        ArrayList<String> gamesList = new ArrayList<>();
        gamesList.add("Bejeweled");
        GameLauncher launcher = new GameLauncher(gamesList);

        Map<Integer, Integer> scoreMap = new HashMap<>();
        scoreMap.put(3,100);
        scoreMap.put(4,200);
        scoreMap.put(5,300);
        scoreMap.put(6,500);
        Bejeweled game = new Bejeweled(new GameRules(10, "Bejeweled", scoreMap));
        game.start();
    }
}
