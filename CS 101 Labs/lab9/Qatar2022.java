package lab9;

/** A class for Qatar 2022 World Cup
*   Turkiye is also qualified in this version :)
*   Market values and player information is obtained from Transfermarkt.com
*   @author Ozcan Ozturk
*   @version 1.0
*/
import java.util.Scanner;

public class Qatar2022 {
    static Scanner in = new Scanner(System.in);

    public static int asker() {
        
        boolean checker = false;
        int toReturn = 0;
        do{
            checker = false;
            if(in.hasNextInt()){
                toReturn = in.nextInt();
                checker = true;                

            }
            if (!checker) {
                System.out.print("Unrecognizable input. Please enter again: ");
            }
                in.nextLine();
                    
        }while(!checker);
        //in.close();
        return toReturn;  
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        boolean exit = false;        
        // Form the English Team
        Team england = new Team(34, "England");
        england.addPlayer(new Player("Raheem Sterling",  27, "England", 17, "Left Wing", 70000000));
        england.addPlayer(new Player("Phil Foden",  22, "England", 47, "Central Midfield", 110000000));
        england.addPlayer(new Player("Jack Grealish",  27, "England", 10, "Left Wing", 70000000));
        england.addPlayer(new Player("Declan Rice",  23, "England", 41, "Defensive Midfield", 80000000));
        england.addPlayer(new Player("Declan Rice",  23, "England", 41, "Defensive Midfield", 80000000));
        england.addPlayer(new Player("Aaron Ramsdale", 24, "England", 23, "Goalkeeper", 30000000)); 
        england.addPlayer(new Player("Aaron Ramsdale", 24, "England", 23, "Goalkeeper", 30000000));
        england.addPlayer(new Player("Jordan Pickford", 28, "England", 1, "Goalkeeper", 28000000));
        england.addPlayer(new Player("Nick Pope", 30, "England", 13, "Goalkeeper", 18000000));
        england.addPlayer(new Player("Ben White", 25, "England", 21, "Centre Back", 45000000)); 
        england.addPlayer(new Player("John Stones", 28, "England", 5, "Centre Back", 30000000));	
        england.addPlayer(new Player("Harry Maguire", 29, "England", 6, "Centre Back", 30000000));
        england.addPlayer(new Player("Eric Dier", 28, "England", 15, "Centre Back", 30000000));
        england.addPlayer(new Player("Conor Coady", 29, "England", 16, "Centre Back", 18000000));
        england.addPlayer(new Player("Luke Shaw", 27, "England", 3, "Left Back", 28000000)); 
        england.addPlayer(new Player("Kyle Walker", 32, "England", 2, "Right Back", 15000000)); 
        england.addPlayer(new Player("Jude Bellingham", 19, "England", 22, "Central Midfield", 100000000));
        england.addPlayer(new Player("Harry Kane", 29, "England", 9, "Centre Forward", 90000000));

        // Form the Turkish Team
        Team turkiye = new Team(38, "Türkiye");
        turkiye.addPlayer(new Player("Ugurcan Çakir", 26, "Türkiye", 23, "Goalkeeper", 14000000));
        turkiye.addPlayer(new Player("Altay Bayindir", 24, "Türkiye", 1, "Goalkeeper", 13000000)); 
        turkiye.addPlayer(new Player("Çaglar Söyüncü",	26, "Türkiye", 4, "Centre Back", 22000000)); 
        turkiye.addPlayer(new Player("Ozan Kabak", 22, "Türkiye", 15, "Centre Back", 10000000)); 
        turkiye.addPlayer(new Player("Tayyip Sanuç", 22, "Türkiye", 6, "Centre Back", 3800000)); 
        turkiye.addPlayer(new Player("Eren Elmali", 22, "Türkiye", 13, "Left Back", 4200000)); 
        turkiye.addPlayer(new Player("Zeki Çelik", 25, "Türkiye", 2, "Right Back", 15000000)); 
        turkiye.addPlayer(new Player("Salih Özcan", 24, "Türkiye", 5, "Defensive Midfield", 17000000));
        turkiye.addPlayer(new Player("Hakan Çalhanoglu", 28, "Türkiye", 10, "Central Midfield", 35000000));
        turkiye.addPlayer(new Player("Arda Güler", 17, "Türkiye", 25, "Attacking Midfield", 10000000));
        turkiye.addPlayer(new Player("Kerem Aktürkoglu", 24, "Türkiye", 7, "Left Wing", 13000000));
        turkiye.addPlayer(new Player("Cengiz Ünder", 25, "Türkiye", 17, "Right Wing", 17000000));
        turkiye.addPlayer(new Player("Enes Ünal", 25, "Türkiye", 16, "Centre Forward", 25000000));
        turkiye.addPlayer(new Player("Umut Bozok", 26, "Türkiye", 19, "Centre Forward", 5500000));
        turkiye.addPlayer(new Player("Cenk Tosun", 31, "Türkiye", 9, "Centre Forward", 2000000));

        // Form the Germany Team
        Team germany = new Team(6, "Germany");
        germany.addPlayer(new Player("Andre Ter Stegen", 30, "Germany", 22, "Goalkeeper", 30000000)); 
        germany.addPlayer(new Player("Manuel Neuer", 36, "Germany", 1, "Goalkeeper", 12000000));
        germany.addPlayer(new Player("Antonio Rüdiger", 29, "Germany", 2, "Centre Back", 40000000)); 
        germany.addPlayer(new Player("Niklas Süle", 27, "Germany", 15, "Centre Back", 35000000));
        germany.addPlayer(new Player("Thilo Kehrer", 26, "Germany", 5, "Centre Back", 22000000)); 
        germany.addPlayer(new Player("David Raum", 24, "Germany", 3, "Left Back", 26000000)); 
        germany.addPlayer(new Player("Lukas Klostermann", 26, "Germany", 16, "Right Back", 14000000)); 
        germany.addPlayer(new Player("Joshua Kimmich", 27, "Germany", 6, "Defensive Midfield", 80000000));
        germany.addPlayer(new Player("Leon Goretzka", 27, "Germany", 8, "Central Midfield", 65000000));
        germany.addPlayer(new Player("Ilkay Gündogan", 32, "Germany", 21, "Central Midfield", 25000000));
        germany.addPlayer(new Player("Jamal Musiala", 19, "Germany", 14, "Attacking Midfield", 100000000));
        germany.addPlayer(new Player("Leroy Sane", 26, "Germany", 19, "Left Wing", 70000000));
        germany.addPlayer(new Player("Serge Gnabry", 27, "Germany", 10, "Right Wing", 65000000));
        germany.addPlayer(new Player("Karim Adeyemi", 20, "Germany", 24, "Right Wing", 35000000));
        germany.addPlayer(new Player("Youssoufa Moukoko", 18, "Germany", 26, "Centre Forward", 30000000));
        germany.addPlayer(new Player("Niclas Füllkrug", 29, "Germany", 9, "Centre Forward", 5000000));
        
        // Create a Group to play the matches in the group
        // Group is created with 4 teams but 3 teams have already
        // been created manually to have some data ready to be used.
        Group groupA = new Group("A", 4);

        // Add the teams to Group "A"
        groupA.addTeam(germany);
        groupA.addTeam(england);
        groupA.addTeam(turkiye);

        System.out.println("---------------------------------------------------");
        System.out.println("Welcome to Qatar 2022! Get Ready for the World Cup!");
        System.out.println("---------------------------------------------------");      
        
        while(exit == false){
            System.out.print("-------------- Group: A -------------------\n"+
            "1 - Create a new Team\n"+
            "2 - Display a Team\n" +
            "3 - Add a Player to a Team\n"+
            "4 - Remove a Player with ID from a Team\n"+
            "5 - Add a Game to the Group\n"+
            "6 - Display Standings\n"+
            "7 - Exit\n"+
            "-------------------------------------------\n"+ 
            "Your choice: ");

            int userChoice = asker();
            boolean isValid = false;
            while(isValid == false){
                if(userChoice < 0 || userChoice > 7){
                    System.out.print("Unrecognizable input. Please enter again: ");
                    userChoice = asker();
                }
                else{
                    isValid = true;
                }
            }
           

            if(userChoice == 1){
                if(groupA.getNumberOfTeams() == groupA.getGroupSize()){
                    System.out.println("Group already has 4/4 teams.");
                }
                else{
                    System.out.print("What is the unique ID of the Team?: ");
                    int ID = asker();
                    if(ID>=0 && groupA.teamExists(ID)==false){
                        System.out.print("What is the name of the Team?: ");
                        String name = in.nextLine();
                        Team newTeam = new Team(ID, name);
                        groupA.addTeam(newTeam);
                    }
                    else if(groupA.teamExists(ID)==true){
                        System.out.println("A team with this ID already exists!");
                    }
                    else{
                        System.out.println("Group ID cannot be negative!");
                    }
                }              
            }

            else if(userChoice == 2){
                System.out.print("What is the unique ID of the Team?: ");
                int ID = asker();
                if(ID<0){
                    System.out.println("Team ID cannot be negative!");
                }
                else if(groupA.teamExists(ID)){
                    for(int i = 0; i <= groupA.getNumberOfTeams()-1; i++){
                        if(groupA.getTeams()[i].getID() == ID){
                            System.out.println(groupA.getTeams()[i].toString());
                        }
                    }
                    
                }
                else{
                    System.out.println("A team with the input ID does not exist.");
                }
            }
            else if(userChoice == 3){
                System.out.print("What is the unique ID of the Team to add the Player?: ");
                int ID = asker();
                int indexOfTeam = 0;

                if(ID<0){
                    System.out.println("Team ID cannot be negative!");
                }
                else if(groupA.teamExists(ID)){
                    System.out.print("Enter the name of the player: ");
                    String name = in.nextLine();
                    System.out.print("Enter the age of the player: ");
                    int age = asker();
                    if(age>0){
                        System.out.print("Enter the nationality of the player: ");
                        String nationality = in.next();
                        boolean doesNationalityExist = false;
                        boolean notCitizen = false;
                        for(int i = 0; i <= groupA.getNumberOfTeams()-1; i++){
                            if(groupA.getTeams()[i].getID() == ID && groupA.getTeams()[i].getName().equals(nationality)){
                                doesNationalityExist = true;
                                indexOfTeam = i;
                            }
                            if(groupA.getTeams()[i].getID() == ID && !groupA.getTeams()[i].getName().equals(nationality)){
                                notCitizen = true;
                            }
                        }
                        if(doesNationalityExist == true){
                            System.out.print("Enter the jersey number of the player: ");
                            int jerseyNumber = asker();
                            if(jerseyNumber>0){
                                boolean doesPlayerExist = false;
                                if(groupA.getTeams()[indexOfTeam].playerExists(jerseyNumber)){
                                    doesPlayerExist = true;
                                }
                                if(doesPlayerExist == false){
                                    System.out.print("Enter the position of the player: ");
                                    String position = in.nextLine();
                                    System.out.print("Enter the market value of the player: ");
                                    int marketValue = asker();
                                    if(marketValue>0){
                                        Player newPlayer = new Player(name, age, nationality, jerseyNumber, position, marketValue);
                                        groupA.getTeams()[indexOfTeam].addPlayer(newPlayer);
                                    }
                                    else{
                                        System.out.println("Market value cannot be negative!");
                                    }
                                }
                                else{
                                    System.out.println("Player with the jersey number already exists!");
                                }
                            }
                            else{
                                System.out.println("Jersey number cannot be a non-positive integer!");
                            }
                        }
                        else if(notCitizen == true){
                            System.out.println("Player must be a citizen of the country!");
                        }
                        else if(doesNationalityExist == false){
                            System.out.println("The input nationality does not exist in this group.");
                        }
                       
                        
                    }
                    else{
                        System.out.println("The age of a player cannot be a non-positive integer!");
                    }
                }
                else{
                    System.out.println("A team with the input ID does not exist.");
                }
            }
            else if(userChoice == 4){
                System.out.print("What is the unique ID of the Team to remove the Player?: ");
               int ID = asker();
               int teamIndex = -1;
               for(int i = 0; i < groupA.getNumberOfTeams(); i++){
                if(ID == groupA.getTeams()[i].getID()){
                    teamIndex = i;
                }
               }
               if(teamIndex == -1){
                System.out.println("The team with the input ID does not exist!");
               }
               else{
                System.out.print("Enter the jersey number of the player: ");
                int jerseyNumber = asker();
                
                    if(groupA.getTeams()[teamIndex].playerExists(jerseyNumber)){

                        groupA.getTeams()[teamIndex].removePlayer(jerseyNumber);
                    }
                    else{
                        System.out.println("Player does not exist!");
                    }
                   
               }
            }
            else if(userChoice == 5){
                System.out.print("What is the unique ID of the First Team?: ");
                int firstID = asker();
                boolean doesTeam1Exist = false;
                for(int i = 0; i < groupA.getNumberOfTeams(); i++){
                    if(groupA.getTeams()[i].getID() == firstID){
                        doesTeam1Exist = true;
                    }
                }
                if(doesTeam1Exist){
                    System.out.print("What is the unique ID of the Second Team?: ");
                    int secondID = asker();
                    boolean doesTeam2Exist = false;
                    for(int i = 0; i < groupA.getNumberOfTeams(); i++){
                        if(groupA.getTeams()[i].getID() == secondID){
                            doesTeam2Exist = true;
                        }
                    }
                    if(doesTeam2Exist){
                        System.out.print("Enter the score (such as 2 1): ");
                        boolean asker = true;
                        int goals1 = 0;
                        int goals2 = 0;

                        while(asker){
                            if(in.hasNextInt()){
                                goals1 = in.nextInt();
                                if(in.hasNextInt()){
                                    goals2 = in.nextInt();
                                    asker = false;
                                }
                                else{
                                    in.nextLine();
                                    System.out.print("Unrecognizable input. Please enter again: ");
                                }
                            }
                            else{
                                in.nextLine();
                                System.out.print("Unrecognizable input. Please enter again: ");
                            }
                        }

                        Team team1 = null;
                        Team team2 = null;
                        for(int i=0; i<groupA.getNumberOfTeams(); i++){
                            if(groupA.getTeams()[i].getID() == firstID){
                                team1 = groupA.getTeams()[i];
                            }
                            if(groupA.getTeams()[i].getID() == secondID){
                                team2 = groupA.getTeams()[i];
                            }
                        }

                        Game newGame = new Game(team1, team2 , goals1, goals2);
                        groupA.addGame(newGame);
                        System.out.println(newGame.toString());
                    }
                    else{
                        System.out.println("A team with the second input ID does not exist!");
                    }
                }
                else{
                    System.out.println("A team with the first input ID does not exist!");
                }
            }
            else if(userChoice == 6){
                System.out.println(groupA.toString());
            }
            else if(userChoice == 7){
                exit = true;
            }
         
        }

    }    
}
