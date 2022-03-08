import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    public int time;

    public GameTimer(int totalTime){
        this.time = totalTime;
    }

    /** This method returns the remaining amount of time **/
    public int getTimeRemaining(){
        return this.time;
    }

    /** This method sets the remaining amount of time **/
    public void setTime(int newTime){
        this.time = newTime;
    }
    
    /** This method starts the timer and prints the amount of time left **/
    public void runTimer(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                if(time == 0){
                    // ends the timer and timertask
                    // add in what ever function should be called when timer ends here
                    timer.cancel();
                    timer.purge();
                }
                else
                    System.out.println("Time left:" + time);
                    time -= 1;
            }
        };
        // runs the task each second
        timer.schedule(task, 0, 1000);
    }

    public static void main(String[] args){
        GameTimer gameTimer = new GameTimer(10);
        gameTimer.runTimer();
    }    
}