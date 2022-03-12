import java.util.Timer;

public class Game {

    private String name; 
    private int score;
    private Timer timer = new Timer(); 

    public Game(){

    }

    public void startGameInstance() {

    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public void setTimer(){
        //set timer duration
    }

    public Timer getTimer(){
        return this.timer; 
    }

    /** This method determine if the initial board of the game is able to be make futhur move */
    public boolean checkInitialBoard(Grid g)
    {
        // if the function returns true --> the current board is valid for play
        // if the function returns false --> end of the game. Need to generate a new board for the game. 

        if (CheckVerticalMatch(g) == true)
            return true;

        if (CheckHorizontalMatch(g) == true)
            return true;
        /*
        for (int i = 0; i < arr_b.length; i++)
        {
            for (int j = 0; j < arr_b[i].length; j++)
            {
                Block current = arr_b[i][j];
                int c_id = current.getID();
                // if there is any vertical matches 
                if (i <= arr_b.length - 3 && c_id == arr_b[i][j + 1].getID() && c_id == arr_b[i][j + 2].getID())
                    return true;
                // if there is any horizontal match 
                if (j <= arr_b[i].length - 3 && c_id == arr_b[i + 1][j].getID() && c_id == arr_b[i + 2][j].getID())
                    return true;
            }
        }
        */

        return false;
    }

    /** This function check the vertical match, and remove the block if matches happened */
    public boolean CheckVerticalMatch(Grid g)
    {
        boolean verticalMatch = false;
        // Not sure if is needed, since the GameEngine already has the function to verify the move,
        // which might just call DeleteBlock() 

        Block[][] arr_b = g.blockBlock;       

        for (int i = 0; i < arr_b.length; i++)
        {
            for (int j = 0; j < arr_b[i].length; j++)
            {
                Block current = arr_b[i][j];
                int c_id = current.getID();
                // if there is any vertical matches 
                if (j <= arr_b[i].length - 3 && c_id == arr_b[i][j + 1].getID() && c_id == arr_b[i][j + 2].getID())
                {
                    verticalMatch = true;
                    // arr_b.remove(i, j);
                    // arr_b.remove(i, j + 1);
                    // arr_b.remove(i, j + 2);
                }
            }
        }
        return verticalMatch;
    }

    /** This function check the horizontal match, and remove the block if matches happened */
    public boolean CheckHorizontalMatch(Grid g)
    {
        boolean horizaontalMatch = false;
        // Not sure if is needed, since the GameEngine already has the function to verify the move,
        // which might just call DeleteBlock() 

        Block[][] arr_b = g.blockBlock;       

        for (int i = 0; i < arr_b.length; i++)
        {
            for (int j = 0; j < arr_b[i].length; j++)
            {
                Block current = arr_b[i][j];
                int c_id = current.getID();

                // if there is any horizontal match 
                if (i <= arr_b.length - 3 && c_id == arr_b[i + 1][j].getID() && c_id == arr_b[i + 2][j].getID())
                {
                    horizaontalMatch = true;
                    // arr_b.remove(i, j);
                    // arr_b.remove(i + 1, j);
                    // arr_b.remove(i + 2, j);
                }
            }
        }
        return horizaontalMatch;
    }
}