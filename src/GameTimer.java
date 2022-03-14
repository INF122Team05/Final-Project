import javax.swing.Timer;

import java.util.Scanner;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer {
    private Timer test_timer;
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
         java.util.Timer timer = new java.util.Timer();
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
                 time -= 1;
             }
         };
         // runs the task each second
         timer.schedule(task, 0, 1000);
     }

}