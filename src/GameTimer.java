import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    public int time;

    public GameTimer(int totalTime){
        this.time = totalTime;
    }

    public int getTimeRemaining(){
        return this.time;
    }

    public void setTime(int newTime){
        this.time = newTime;
    }

    public int countDown(){
        this.time -= 1;
        return this.time;
    }
    
    public void runTask(){
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
        gameTimer.runTask();
    }    
}