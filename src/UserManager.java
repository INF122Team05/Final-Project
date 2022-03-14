import java.util.*;

public class UserManager 
{
    // String username;
    List<String> users;

    public UserManager() 
    {
        //Type your code
        users = new ArrayList<String>();
    }

    // Return boolean status in order to allow later action 
    public boolean login(String name)
    {
        boolean login = false;
        if (users.contains(name))
        {
            System.out.println("Success to login!!");
            login = true;
        }
        else
        {
            addUser(name);
            System.out.println("User account created, please login again.");
        }

        return login;
    }

    public void logout()
    {
        // If we are not saving any data, all data should be removed when logout
        users.clear();

        System.out.println("System logout success");
    }

    public void addUser(String name)
    {
        if (users.contains(name))
            System.out.println("User name already exist, please enter another name");
        else
            users.add(name);
    }

    public void removeUser(String name)
    {
        if (users.isEmpty())
            System.out.println("No user inside the system.");
        else if (!users.contains(name))
            System.out.println("User name does not exist.");
        else    
        {
            int idx = users.indexOf(name);
            users.remove(idx);
        }
    }

}
