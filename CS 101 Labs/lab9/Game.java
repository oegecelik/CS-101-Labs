/**
 * @author Orhun Ege Çelik
 */
package lab9;
public class Game {
    //instance variables
    private Team [] teams;
    private int [] goals;

    public Game(Team team1, Team team2, int team1goals, int team2goals){
        if(team1 != null && team2 != null && team1goals >= 0 && team2goals >= 0){
            this.registerGame();
            teams = new Team[2];
            teams[0] = team1;
            teams[1] = team2;
            goals = new int[2];
            goals[0] = team1goals;
            goals[1] = team2goals;
        }
        else{
            System.out.println("Game could not be played. Invalid input.");
        }
    }
    public Team [] getTeams(){
        return this.teams;
    }
    public int getTeamPoints(int ID){
        int  compared = 0;
        int comparedTo = 1;
        if(teams[0].getID() == ID){
        }
        else if(teams[1].getID() == ID){
            compared = 1;
            comparedTo = 0;
        }
        if(goals[compared] > goals[comparedTo]){
            return 3;
        }
        else if(goals[compared] == goals[comparedTo]){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void registerGame(){

    }
    
    public String toString(){
        String toReturn = "";
        toReturn += teams[0].getName() + " vs. " + teams[1].getName() + ": " + goals[0] + "-" + goals[1];
        return toReturn;
    }

}
