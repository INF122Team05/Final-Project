public abstract class GameEngine extends Thread {
    private Grid grid;
    private GameTimer timer;
    private String gameDescription;

    // These hold the temporary selections by the user
    private String firstSelection;
    private String secondSelection;

    public GameEngine(GameRules rules){
        buildGame();
        timer = new GameTimer(rules.getTotalTime());

        gameDescription = rules.getDescription();
        firstSelection = "";
        secondSelection = "";
    }

    /** This method builds the GUI of the game **/
    private void buildGame(){
        try {
            grid = new Grid();
            grid.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Verify valid game move **/
    private boolean verifyMove(String move){
        return true;
    }

    /** This method checks if a move can be made, if so, it makes the move and returns true **/
    private boolean checkAndMakeMove(){
        return true;
    }

    /** This method checks if the game has been won, if so, returns true **/
    private boolean checkGameStatus(){
        return true;
    }

    /** This method provides a default runnable game **/
    public boolean runGame(){
        timer.runTimer();

        while(timer.getTimeRemaining() != 0){
            try{sleep(1000);}catch (InterruptedException e){}
            if (grid.checkInput) {
                // End game
                if (grid.userInput.equals("end")){
                    grid.setVisible(false);
                    return false;
                }
                // First selection
                else if (!grid.userInput.isEmpty() && firstSelection.isEmpty()) {
                    // User provides input: Potentially (x,y) coordinate on grid of block they select first
                    // Verify valid input
                    if (verifyMove(grid.userInput)) {
                        System.out.println("First move: " + grid.userInput);
                        firstSelection = grid.userInput;
                    } else {
                        // Display error: Invalid move
                        System.out.println("Invalid move");
                    }
                    grid.checkInput = false;
                }
                // Second selection
                else if (!grid.userInput.isEmpty()) {
                    if (verifyMove(grid.userInput)) {
                        System.out.println("Got the second move!");
                        secondSelection = grid.userInput;
                        checkAndMakeMove();
                        firstSelection = "";
                        secondSelection = "";
                    } else {
                        // Display error: Invalid move
                        System.out.println("Invalid move");
                    }
                    grid.checkInput = false;
                } else if (!checkGameStatus()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void run(){
        runGame();
    }
}
