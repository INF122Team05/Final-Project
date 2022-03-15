package core;
import java.util.*;

public class GameLauncher{

    private UserManager users;
    private GameEngine engine;
    private GameManager gameList;

    public GameLauncher(ArrayList<String> gameTitles)
    {
        users = new UserManager();
        gameList = new GameManager();

        for (String gameTitle : gameTitles){
            gameList.addGame(gameTitle);
        }

        String user_name = promptUserName();
        if (users.login(user_name))
        {
            System.out.println("Login Successful");
            System.out.println("*** Game List ***");
            showGames();
            // engine.run();
        }
        else
        {
            System.out.println("Fail to Launch Application");
        }
    }

    public void showGames()
    {
        for (Game g : gameList.getGames())
        {
            System.out.println(g.getName());
        }
    }

    public String promptUserName()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("*** Login ***");
        System.out.println("Please enter a username to login");
        System.out.println("Or create a new account by providing a new username");
        String name = input.next();
        input.close();

        return name;
    }
}