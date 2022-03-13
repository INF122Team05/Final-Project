import java.util.*;

public class GameLauncher {

    private UserManager users;
    private GameEngine engine;
    private GameManager gameList;

    public GameLauncher(){
        
        
        String user_name = promptUserName();
        if (users.login(user_name))
        {
            System.out.println("*** Game List ***");
            showGames();
            engine.run();
        }
        else
        {
            System.out.println("Fail to Launch Application");
        }  
	}

    public void showGames()
    {
        gameList.addGame("Candy Crush");
        gameList.addGame("Bejeweled");
        for (Game g : gameList.getGames())
        {
            System.out.println(g.getName());
        }
    }
   
    public String promptUserName()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter User Name: ");
        String name = input.nextLine();
        users.addUser(name);

        input.close();

        return name;
    }

}
