package candycrush;

import bejeweled.Bejeweled;
import core.GameLauncher;
import core.GameManager;
import core.GameRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Launcher {
    public static void main(String[] args){
        ArrayList<String> gamesList = new ArrayList<>();
        String gameName = "Candy Crush";
        gamesList.add(gameName);
        GameLauncher launcher = new GameLauncher(gamesList);

        Map<Integer, Integer> scoreMap = new HashMap<>();
        scoreMap.put(3,10);
        scoreMap.put(4,20);
        scoreMap.put(5,30);
        scoreMap.put(6,40);

        GameRules gameRules = new GameRules(120, "candy crush", scoreMap);
        GameManager gameManager = new GameManager();

        CandyCrush game = new CandyCrush(gameRules, gameManager.getGame(gameName));
        game.start();
    }
}
