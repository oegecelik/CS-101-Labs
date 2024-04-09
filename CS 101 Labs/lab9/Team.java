package lab9;
import java.util.ArrayList;

public class Team {
    
    //instance variables
    private int ID;
    private String name;
    private int averageAge;
    private int marketValue;
    private int sumofAge;
    private ArrayList<Player> squad;
    private int points;

    public Team(int ID, String name){
        if(ID<0){
            System.out.println("ID must be positive. Team could not be created.");
            return;
        }
        this.registerTeam();
        this.ID = ID;
        this.name = name;
        this.averageAge = 0;
        this.marketValue = 0; 
        this.sumofAge = 0;
        this.squad = new ArrayList<Player>();  
        this.points = 0;     
    }
    public ArrayList<Player> getSquad(){
        return this.squad;
    }
    public int getPoints(){
        return this.points;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAverageAge() {
        return this.averageAge;
    }

    public int getMarketValue() {
        return this.marketValue;
    }

    public void registerTeam(){

    }
    public boolean playerExists(int jerseyNumber){
        for(int i=0; i < squad.size(); i++){
            if(squad.get(i).getJerseyNumber() == jerseyNumber){
                return true;
            }
        }
        return false;
    }

    public void addPlayer(Player player){
        boolean doesExist = false;
        for(int i = 0; i < squad.size(); i++){
            if(squad.get(i).getJerseyNumber() == player.getJerseyNumber()){
                doesExist = true;
            }
        }
        if(!doesExist){
            if(this.name.equals(player.getNationality())){
                squad.add(player);
                sumofAge += player.getAge();
                this.averageAge = sumofAge/squad.size();
                this.marketValue += player.getMarketValue();
            }
        }
    }

    public void removePlayer(int jerseyNumber){
        for(int i= 0; i< squad.size(); i++){
            if(squad.get(i).getJerseyNumber() == jerseyNumber){
                this.squad.remove(squad.get(i));
            }
        }
        
    }

    public String toString(){
        String toReturn = "";
        for(int i = 1; i<=81; i++){
            toReturn += "=";
        }
        toReturn += "\n=";
        for(int i = 1; i<=33; i++){
            toReturn += " ";
        }
        toReturn += "Team Details";
        for(int i = 1; i<=34; i++){
            toReturn += " ";
        }
        toReturn += "=\n";
        for(int i = 1; i<=81; i++){
            toReturn += "=";
        }
        toReturn += "\nID: " + this.ID;
        toReturn += "\nTeam: " + this.name;
        toReturn += "\nAverage Age: " + this.averageAge;
        toReturn += "\nMarket Value: " + this.marketValue;
        toReturn += "\nSquad is composed of following players:\n";

        for(int i = 1; i<=81; i++){
            toReturn += "-";
        }
        toReturn += "\nName" + "                "
         + "Age" + "  " + "Nationality" + "    " + "Number"
        + "  " + "Position" + "            " + "Market Value\n";
        for(int i = 1; i<=81; i++){
            toReturn += "-";
        }
        for(int i= 0; i<squad.size(); i++){
            toReturn += "\n" + squad.get(i).toString();
        }
        toReturn += "\n";
        for(int i = 1; i<=81; i++){
            toReturn += "=";
        }
        return toReturn;
    }
    public static void main(String[] args) {
        Player aPlayer = new Player("Anan", 12, "abc", 12, "LW", 4300);
        Player bPlayer = new Player("Baban", 12, "abc", 13, "abasd", 123123123);
        Team team = new Team(123, "abc");
        team.addPlayer(aPlayer);
        team.addPlayer(bPlayer);
        System.out.println(team.toString());
    }
}
