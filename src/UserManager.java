import java.util.*;

public class UserManager 
{
    // String username;
    public List<String> users;

    public void userManager() 
    {
        //Type your code
        this.users = new ArrayList<String>();
    }

    // Return boolean status in order to allow later action 
    public boolean login(String name)
    {
        boolean login = false;

        if (this.users == null || this.users.isEmpty())
        {
            this.users = new ArrayList<String>();
            this.users.add(name);
            System.out.println("New User account created");
            login = true;
        }
        else 
        {
            if (users.contains(name))
            {
                // System.out.println("Success to login!!");
                login = true;
            }
        }
        
        return login;
    }

    public void logout()
    {
        // If we are not saving any data, all data should be removed when logout
        this.users.clear();

        System.out.println("System logout success");
    }

    public void addUser(String name)
    {
        if (users.isEmpty())
        {
            // System.out.println("Adding to empty list ");
            users = new ArrayList<String>();
            users.add(name);
        }
        else
        {
            if (users.contains(name))
                System.out.println("User name already exist, please enter another name");
            else
                users.add(name);
        }
        
    }

    public void removeUser(String name)
    {
        if (this.users.isEmpty())
            System.out.println("No user inside the system.");
        else if (!this.users.contains(name))
            System.out.println("User name does not exist.");
        else    
        {
            int idx = users.indexOf(name);
            this.users.remove(idx);
        }
    }

}
