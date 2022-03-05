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
