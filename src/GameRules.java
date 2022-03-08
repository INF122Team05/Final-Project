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

    public int getTotalTime(){
        return this.totalTime;
    }

    public void setTotalTime(int newTotalTime){
        this.totalTime = newTotalTime;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String newDescription){
        this.description = newDescription;
    }
}
