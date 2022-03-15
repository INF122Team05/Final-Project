package example;

import core.Game;
import core.GameEngine;
import core.GameLauncher;
import core.GameRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExampleLauncher {
    public static void main(String[] args) {
        GameLauncher gameLauncher = new GameLauncher(new ArrayList<>());
        Map<Integer, Integer> scoreMap = new HashMap<>();
        Example example = new Example(new GameRules(100, "Example", scoreMap), new Game("Example"));
        example.start();
    }
}
