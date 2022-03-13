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
    
    // /** This method starts the timer and prints the amount of time left **/
    // public void runTimer(){
    //     Timer timer = new Timer();
    //     TimerTask task = new TimerTask()
    //     {
    //         @Override
    //         public void run()
    //         {
    //             if(time == 0){
    //                 // ends the timer and timertask
    //                 // add in what ever function should be called when timer ends here
    //                 timer.cancel();
    //                 timer.purge();
    //             }
    //             else
    //                 System.out.println("Time left:" + time);
    //                 time -= 1;
    //         }
    //     };
    //     // runs the task each second
    //     timer.schedule(task, 0, 1000);
    // }

    /** This method starts the timer and prints the amount of time left **/
    public void runTimer() {
        test_timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (time <= 0) {
                    test_timer.stop();
                }
                else{
                    time--;
                }
            }
        }
        );};
    
    public void stop(){
        test_timer.stop();
    }
    

    public static void main(String[] args){
        GameTimer gameTimer = new GameTimer(100);
        gameTimer.runTimer();
        gameTimer.test_timer.start();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
        System.out.println(gameTimer.getTimeRemaining());
        String userName = myObj.nextLine();  // Read user input
        System.out.println(gameTimer.getTimeRemaining());
        if(userName == "stop"){
            gameTimer.stop();
        }
    }    
}