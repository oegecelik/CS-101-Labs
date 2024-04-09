package lab9;

import java.util.Arrays;

public class Group {
    //instance variables
    private String name;
    private int groupSize;
    private int numberOfTeams;
    private Team[] teams;
    private Game[][] games;
    private int[] points;
    private int[] pointsDescending;
    private Team[] teamsInOrder;

    public Group(String name, int groupSize){
        if(groupSize < 0){
            System.out.println("Group could not be created. Invalid group size.");
            return;
        }
        this.name = name;
        this.groupSize = groupSize;
        this.numberOfTeams = 0;
        this.teams = new Team[groupSize];
        this.teamsInOrder = new Team[groupSize];
        this.games = new Game[groupSize][groupSize];
        this.points = new int[groupSize];
    }

    public void registerGroup(){
        
    }

    public Team[] getTeams() {
        return teams;
    }

    public String getName() {
        return name;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

   public boolean teamExists(int ID){
    for(int i = 0; i<=numberOfTeams-1; i++){
        if(teams[i].getID() == ID){
            return true;
        }
    }
    return false;
   }

   public void addTeam(Team team){
    if(numberOfTeams<groupSize){
        for(int i = 0; i<=numberOfTeams; i++){
            if(teams[i] == team){
                return;
            }
        }
        this.teams[numberOfTeams++] = team;
        }
    }
    
    public void addGame(Game game){
        Team[] teamsToCheck = game.getTeams();
        boolean check0 = false;
        boolean check1 = false;
        for(int i=0; i<=numberOfTeams-1; i++){
            if(teamsToCheck[0] == this.teams[i]){
                check0 = true; 
            }
            if(teamsToCheck[1] == this.teams[i]){
                check1 = true; 
            }
        }
        if(check0 == false || check1 == false){
            return;
        }
   
        int team1index = 0;
        int team2index = 0;
        for(int i = 0; i<= groupSize-1; i++){
            if(game.getTeams()[0] == this.teams[i]){
                team1index = i;
            }
        }
        for(int i = 0; i<= groupSize-1; i++){
            if(game.getTeams()[1] == this.teams[i]){
                team2index = i;
            }
        }
        //CHECKS FOR PREVIOUS GAMES
        if(games[team1index][team2index] != null || games[team2index][team1index] != null){
            System.out.println("A game has already been played between these two teams!");
            return;
        }
        games[team1index][team2index] = game;


        this.points[team1index] += game.getTeamPoints(game.getTeams()[0].getID());
        this.points[team2index] += game.getTeamPoints(game.getTeams()[1].getID());

    }

    public String toString(){
        
        pointsDescending = Arrays.copyOf(points,points.length);
        for(int i = 0; i<= numberOfTeams-1; i++){
            pointsDescending[i] = -pointsDescending[i];
        }
        Arrays.sort(pointsDescending);
        for(int i = 0; i<= numberOfTeams-1; i++){
            pointsDescending[i] = -pointsDescending[i];
        }
        


        //RECREATING THE ARRAYS JUST TO PRINT, these arrays are not used other than the toString method.
        teamsInOrder = new Team[numberOfTeams];
        for(int i= 0; i <= numberOfTeams - 1; i++){
            for(int j= 0; j<= numberOfTeams-1; j++){
                if(pointsDescending[i] == points[j]){
                    boolean contains = false;
                    for(int a = 0; a <= teamsInOrder.length-1; a++){
                        if(teamsInOrder[a] != null && teamsInOrder[a].equals(this.teams[j])){
                            contains = true;
                        }
                    }
                    if(!contains){
                        this.teamsInOrder[i] = this.teams[j];
                    }
                   
                }
            }
        }
        
      
        String toReturn = "";
        toReturn = "==================================\n" +
        "=       Group " + this.getName() + " Standings        =\n" + 
        "==================================\n";
        for(int i = 0; i<=numberOfTeams-1; i++){
            String spaces = "";
            String spacesBeforeId = "";
            if(Integer.toString(teamsInOrder[i].getID()).length() == 1){
                spaces = " ";
            }
           if(teamsInOrder[i].getName().length()<7){
               for(int j = teamsInOrder[i].getName().length(); j<7; j++){
                   spacesBeforeId += " ";
               }
           }
            toReturn += " " + (i+1) + ".      " + this.teamsInOrder[i].getName() + spacesBeforeId + " ( " + spaces + this.teamsInOrder[i].getID() + " )"
            + "   " + this.pointsDescending[i] + "\n";
        }
        toReturn += "==================================";
        return toReturn;        
    }
    public static void main(String[] args) {

Group B = new Group("B", 3);
Team germany = new Team(6, "Germany");
Team turkiye = new Team(38, "Türkiye");
Team england = new Team(34, "England");
B.addTeam(england);
B.addTeam(germany);
B.addTeam(turkiye);
Game g1 = new Game(turkiye, germany, 0, 3);
Game g4 = new Game(turkiye, england, 0, 3);
Game g2 = new Game(turkiye, england, 2, 0);
Game g3 = new Game(germany, england, 0, 0);

B.addGame(g2);
B.addGame(g1);
B.addGame(g3);
B.addGame(g4);


System.out.println(B);
    }
}
