import java.util.List;
import java.util.ArrayList;


public class GameManager {
	List<Game> games;
	
	GameManager() {
		this.games = new ArrayList<Game>();
	}
	
	public List<Game> getGames() {
		return this.games;
	}
	
	
	//returns a game based on a string input. If game doesn't exist, return null
	public Game getGame(String name) {
		for (Game game : this.games) {
			if (game.getName().equals(name)) {
				return game;
			}
		}
		return null;
	}
	
	// Adds a game to the Games list
	public void addGame(String name) {
		Game g = new Game(name);
		this.games.add(g);
	}

}