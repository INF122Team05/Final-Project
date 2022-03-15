package core;

import java.awt.*;
import java.util.ArrayList;

public abstract class GameEngine extends Thread {
    private Grid grid;
    private GameRules rules;

    // These hold the temporary selections by the user
    private String selection;

    public GameEngine(GameRules rules){
        this.rules = rules;
        buildGame();
        selection = "";
    }

    /** This method builds the GUI of the game **/
    private void buildGame(){
        try {
            grid = new Grid(rules.getTotalTime());
            grid.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** After a move has been validated, make the move **/
    private void updateBlocks(ArrayList<Point> coords){
        for(Point coord : coords){
            grid.removeBlock(coord.x, coord.y);
        }
        // Count score
        System.out.println("That move had a total of " + coords.size() + " blocks");
        System.out.println("Therefore, that equals " + rules.getScoreMap().get(coords.size()) + " points");
        var scoreToAdd = rules.getScoreMap().get(coords.size());
        if (scoreToAdd == null){
            System.out.println("No score value for this move, defaulting to 100 points");
            grid.updateScore(100);
        }
        else{
            grid.updateScore(rules.getScoreMap().get(coords.size()));
        }

        grid.updateGrid();
    }

    /** Check if there is at least 3 matching blocks in a row. It returns the longest move, or -1 if no move **/
    public ArrayList<Point> checkForMatch(int x, int y, int blockID, int gridWidth, int gridHeight, int originalX, int originalY){
        ArrayList<Point> longestMoveTopDown = new ArrayList<>();
        ArrayList<Point> longestMoveLeftRight = new ArrayList<>();

        // If theres a match to the right
        if ((x < gridWidth-1) && (blockID == grid.blockBlock[x+1][y].getID()) && (x+1 != originalX)){
            for (int i=x+1; i<gridWidth; i++){
                if (blockID == grid.blockBlock[i][y].getID()){
                    longestMoveLeftRight.add(new Point(i,y));
                }
                else{break;}
            }
        }
        // If theres a match to the left
        if((x > 0) && (blockID == grid.blockBlock[x-1][y].getID()) && (x-1 != originalX)){
            for (int i=x-1; i>=0; i--){
                if (blockID == grid.blockBlock[i][y].getID()){
                    longestMoveLeftRight.add(new Point(i,y));
                }
                else{break;}
            }
        }
        // If theres a match below
        if((y < gridHeight-1) && (blockID == grid.blockBlock[x][y+1].getID()) && (y+1 != originalY)){
            for (int i=y+1; i<gridHeight; i++){
                if (blockID == grid.blockBlock[x][i].getID()){
                    longestMoveTopDown.add(new Point(x,i));
                }
                else{break;}
            }
        }
        // If theres a match above
        if((y > 0) && (blockID == grid.blockBlock[x][y-1].getID()) && (y-1 != originalY)){
            for (int i=y-1; i>=0; i--){
                if (blockID == grid.blockBlock[x][i].getID()){
                    longestMoveTopDown.add(new Point(x,i));
                }
                else{break;}
            }
        }


        if (longestMoveLeftRight.isEmpty() && longestMoveTopDown.isEmpty()){return null;}
        else {
            if (longestMoveLeftRight.size() > longestMoveTopDown.size()){
                System.out.println("Blocks to move:");
                for (Point p : longestMoveLeftRight){
                    System.out.println("(" + p.x + ", " + p.y + ")");
                }

                longestMoveLeftRight.add(new Point(x,y));
                return longestMoveLeftRight;
            }
            else{
                System.out.println("Blocks to move:");
                for (Point p : longestMoveTopDown){
                    System.out.println("(" + p.x + ", " + p.y + ")");
                }

                longestMoveTopDown.add(new Point(x,y));
                return longestMoveTopDown;
            }
        }
    }

    /** Verify valid game move **/
    private boolean verifyMove(String move){
        String[] inputNum = move.split(",");
        int numX, numY, num2X, num2Y;
        int gridMax = 6;
        try {
            numX = Integer.parseInt(inputNum[0]);
            numY = Integer.parseInt(inputNum[1]);
            num2X = Integer.parseInt(inputNum[2]);
            num2Y = Integer.parseInt(inputNum[3]);
        }catch (NumberFormatException e){
            System.out.println("Invalid move format:\nTry a,b,c,d which translates to (a,b) (c,d)");
            return false;
        }

        // User types 1-6 instead of 0-5, so we need to adjust that
        numX--;
        numY--;
        num2X--;
        num2Y--;

        // If selection is within the grid
        if ((numX < gridMax) && (numX >= 0) && (num2X < gridMax) && (num2X >= 0) && (numY < gridMax) && (numY >= 0) && (num2Y < gridMax) && (num2Y >= 0)){
            // If selection is a pair next to each other
            if (
                    ((numX + 1 == num2X) && (numY == num2Y)) || ((numX - 1 == num2X) && (numY == num2Y))
                            || ((numX == num2X) && (numY + 1 == num2Y)) || ((numX == num2X) && (numY - 1 == num2Y))
            ){
                // Check for matches
                ArrayList<Point> blocksToChangeMain = checkForMatch(num2X, num2Y, grid.blockBlock[numX][numY].getID() ,gridMax, gridMax, numX, numY);
                ArrayList<Point> blocksToChangeSelected = checkForMatch(numX, numY, grid.blockBlock[num2X][num2Y].getID() ,gridMax, gridMax, num2X, num2Y);
                if (blocksToChangeMain == null && blocksToChangeSelected == null){
                    return false;
                }
                else{
                    grid.swapImage(true, move);
                    try{sleep(1000);}catch (InterruptedException e){System.out.println("Failed to sleep");}
                    if (blocksToChangeMain != null && blocksToChangeMain.size() > 2){
                        updateBlocks(blocksToChangeMain);
                    }
                    if (blocksToChangeSelected != null && blocksToChangeSelected.size() > 2){
                        updateBlocks(blocksToChangeSelected);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /** This method checks if a move can be made, if so, it makes the move and returns true **/
    private boolean checkAndMakeMove(String move){
        if(verifyMove(move)){
            grid.swapImage(true, move);
            return true;
        }
        return false;
    }

    /** This method checks if the game has been won, if so, returns true **/
    private boolean checkGameStatus(){
        return true;
    }

    /** This method provides a default runnable game **/
    public boolean runGame(){
        while(grid.timer.getTimeRemaining() != 0){
            try{sleep(1000);}catch (InterruptedException e){}
            grid.updateTimer();
            if (grid.checkInput) {
                // End game
                if (grid.userInput.equals("end")){
                    grid.setVisible(false);
                    return false;
                }
                // Selection
                else if (!grid.userInput.isEmpty()) {
                    // User provides input: #,#,#,#
                    // Verify valid input
                    if (checkAndMakeMove(grid.userInput)) {
                        System.out.println("Move made");
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
        if (runGame()){
            System.out.println("Congrats! You beat the game with a total score of: " + grid.score);
        }
        else{
            System.out.println("Game Over! You finished the game with a total score of: " + grid.score);
        }
        grid.setVisible(false);
    }
}
