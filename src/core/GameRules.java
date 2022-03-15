package core;

import java.util.Map;

public class GameRules {
    private int totalTime;
    private String description;
    private Map<Integer, Integer> scoreMap;

    public GameRules(int totalTime, String description, Map<Integer, Integer> scoreMap){
        this.totalTime = totalTime;
        this.description = description;
        this.scoreMap = scoreMap;
    }

    /** This method returns the score values for each number of matching blocks in a row **/
    public Map<Integer, Integer> getScoreMap() {
        return scoreMap;
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
