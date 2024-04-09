package lab9;

import java.text.DecimalFormat;

public class Player {

    //instance variables
    private String name;
    private int age;
    private String nationality;
    private int jerseyNumber;
    private String position;
    private int marketValue;

    public Player(String name, int age, String nationality,
    int jerseyNumber, String position, int marketValue){
        if(age<=0){
            System.out.println("Age out of bounds. Player could not be created.");
            return;
        }
        if(jerseyNumber<=0 || jerseyNumber>99){
            System.out.println("Jersey number out of bounds. Player could not be created.");
            return;
        }
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.marketValue = marketValue;

    }

    //Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getPosition() {
        return position;
    }

    public int getMarketValue() {
        return marketValue;
    }

    //Setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    public String toString() {
        String toReturn = this.name;
        for(int i = 1; i<= 20 - this.name.length(); i++){
            toReturn += " ";
        }
        toReturn += this.age;
        for(int i = 1; i<= 5 - Integer.toString(this.age).length(); i++){
            toReturn += " ";
        }
        toReturn += this.nationality;
        for(int i = 1; i<= 15 - this.nationality.length(); i++){
            toReturn += " ";
        }
        toReturn += this.jerseyNumber;
        for(int i = 1; i<= 8 - Integer.toString(this.jerseyNumber).length(); i++){
            toReturn += " ";
        }
        toReturn += this.position;
        for(int i = 1; i<= 20 - this.position.length(); i++){
            toReturn += " ";
        }
        DecimalFormat dFormat = new DecimalFormat("###,###");
        String strMarketValue = dFormat.format(this.marketValue);

        toReturn += strMarketValue;
        return toReturn;
    }
    public static void main(String[] args) {
        Player a = new Player("an", 12, "ab", 13, "lw", 43333333);
        System.out.println(a.toString());
    }

}
