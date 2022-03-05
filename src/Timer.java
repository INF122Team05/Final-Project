// might be better to use Java's built in timer class or use alongside the timer class
public class Timer {
    public void Timer(){
        int time;
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

}
