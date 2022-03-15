package bejeweled;

import core.GameLauncher;
import core.GameRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Launcher {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        String gameName = "Bejeweled";
        list.add(gameName);
        GameLauncher launcher = new GameLauncher(list);

        Map<Integer, Integer> scoreMap = new HashMap<>();
        scoreMap.put(3,100);
        scoreMap.put(4,200);
        scoreMap.put(5,300);
        scoreMap.put(6,500);

        GameRules gameRules = new GameRules(120, "bejeweled", scoreMap);

        Bejeweled game = new Bejeweled(gameRules, launcher.getGameList().getGame(gameName));
        game.start();
    }
}
