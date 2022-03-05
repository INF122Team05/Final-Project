import java.util.Scanner;

public abstract class GameEngine extends Thread {
    private Grid grid;
    private Timer timer;
    private String gameDescription;

    // These hold the temporary selections by the user
    private String firstSelection;
    private String secondSelection;

    public GameEngine(GameRules rules){
        grid = new Grid();
        timer = new Timer();
        timer.setTime(rules.getTotalTime());

        gameDescription = rules.getDescription();
        firstSelection = "";
        secondSelection = "";
    }

    /** This method builds the GUI of the game **/
    public void buildGame(){}

    /** Verify valid game move **/
    public boolean verifyMove(String move){
        return true;
    }

    /** This method checks if a move can be made, if so, it makes the move and returns true **/
    public boolean checkAndMakeMove(){
        return true;
    }

    /** This method checks if the game has been won, if so, returns true **/
    public boolean checkGameStatus(){
        return true;
    }

    /** This method provides a default runnable game **/
    public boolean runGame(){
        String input = "";
        Scanner sc = new Scanner(System.in);
        timer.countDown();

        while(timer.getTimeRemaining() != 0){
            // Check if there is input
            if (sc.hasNext() && firstSelection.isEmpty()){
                // User provides input: Potentially (x,y) coordinate on grid of block they select first
                input = sc.nextLine();

                // Verify valid input
                if (verifyMove(input)){
                    firstSelection = input;
                }
            }
            else if (sc.hasNext()){
                input = sc.nextLine();

                if (verifyMove(input)){
                    secondSelection = input;
                    checkAndMakeMove();
                    firstSelection = "";
                    secondSelection = "";
                }
            }
            else if (checkGameStatus()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void run(){
        runGame();
    }
}
