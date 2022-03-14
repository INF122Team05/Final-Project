import java.util.*;

public class GameLauncher{

    private UserManager users;
    private GameEngine engine;
    private GameManager gameList;

    public GameLauncher() 
    {
        users = new UserManager();
        gameList = new GameManager();
        
        gameList.addGame("Candy Crush");
        gameList.addGame("Bejeweled");

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

        System.out.print("Please Enter User Name: ");
        String name = input.next();
        input.close();

        return name;
    }
}
