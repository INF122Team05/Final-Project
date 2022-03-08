public class GameRules {
    private int totalTime;
    private String description;

    public GameRules(int totalTime){
        this.totalTime = totalTime;    
    }

    public int scoreCalculation(){
        // not implemented yet
        // felt like this made more sense as a method
        // when should this be called?
        return 0;
    }

    /** This method returns the max amount of time a game should last**/
    public int getTotalTime(){
        return this.totalTime;
    }

    /** This method sets the max amount of time a game should last **/
    public void setTotalTime(int newTotalTime){
        this.totalTime = newTotalTime;
    }

    /** This method returns a description of the games rules **/
    public String getDescription(){
        return this.description;
    }

    /** This method sets a description of the games rules **/
    public void setDescription(String newDescription){
        this.description = newDescription;
    }
}
