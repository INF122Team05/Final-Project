package candycrush;

import bejeweled.Bejeweled;
import core.GameLauncher;
import core.GameRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Launcher {
    public static void main(String[] args){
        ArrayList<String> gamesList = new ArrayList<>();
        gamesList.add("Candy Crush");
        GameLauncher launcher = new GameLauncher(gamesList);

        Map<Integer, Integer> scoreMap = new HashMap<>();
        scoreMap.put(3,10);
        scoreMap.put(4,20);
        scoreMap.put(5,30);
        scoreMap.put(6,50);
        CandyCrush game = new CandyCrush(new GameRules(100, "CandyCrush Game", scoreMap));
        game.start();
    }
}
