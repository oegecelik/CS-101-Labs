package lab5;
import java.util.Random;

public class Lab05_Q2edited {
    public static void main(String[] args){

        Random rand = new Random();

        int deckLength = 51;
        int previousPlayer = 0;
        int currentPlayer = 0;
        int playerPrinter = 1;
        boolean sentinel = true;
        int dealLength = 26;

        String deck = "";
        String dealSpecific = "";
        String dealSpecificA ="";
        String dealSpecificB = "";
        String dealOne = "";
        String dealTwo = "";
        String firstPlayer;
        String secondPlayer;
        String trash = "";

        for (int i = 1; i<=9; i++){
            for (int a = 1; a<=4; a++){
                deck += i;
            }
        }

        for (int b = 1; b<=4; b++){
            for (int c = 1; c<=4; c++){
                if(b==1)
                deck += "T";
                if(b==2)
                deck += "J";
                if(b==3)
                deck += "Q";
                if(b==4)
                deck += "K";
            }
        }
        deck = deck.substring(0,deck.length()-1);
        System.out.println("Starting the game with the following deck:\n" + deck+ "\n");
        System.out.println("Initial cards are dealing...");

//Deck creation is completed. Moving on to randomly dealing the cards.
        

        int getsOneMoreCard = rand.nextInt(2);
        getsOneMoreCard +=1;

        for(int c=1; c<=2; c++){
                    
            for(int a = 1; a<=dealLength; a++){
                int randomPickIndex = rand.nextInt(deckLength);
                String cardPick = Character.toString(deck.charAt(randomPickIndex));
                dealSpecific = dealSpecific + cardPick;
                deck = deck.replaceFirst(cardPick, "");
                deckLength--;
            }
            System.out.println("Player"+ playerPrinter +"'s deal: " + dealSpecific);
           

            
//Remove duplicates.
            int dealSpecificLength = dealSpecific.length();

            for(int i = 0; i<dealSpecificLength; i++){
                boolean checker = true;
                
                for(int b = 1; b+i<dealSpecificLength && checker == true; b++){
                    if(dealSpecific.charAt(i) == dealSpecific.charAt(b+i)){
                        dealSpecific = dealSpecific.replaceFirst(Character.toString(dealSpecific.charAt(i)), "");
                        dealSpecific = dealSpecific.replaceFirst(Character.toString(dealSpecific.charAt(b+i-1)), "");

                        checker = false;
                        i= -1;
                        dealSpecificLength = dealSpecific.length();
                    }
                 }
            }
            if(dealLength ==26){
                 dealSpecificB = dealSpecific;
            }
            else{
                dealSpecificA = dealSpecific;
            }

            dealLength = 25;
            playerPrinter = 2;
            dealSpecific = "";
            
        }
         
        

    if(getsOneMoreCard == 1){
        dealOne = dealSpecificB; 
        dealTwo = dealSpecificA;
        firstPlayer = dealTwo;
        secondPlayer = dealOne;
        currentPlayer = 2;         
      }
      else{
        dealOne = dealSpecificA;
        dealTwo = dealSpecificB;
        firstPlayer = dealOne; 
        secondPlayer = dealTwo;  
        currentPlayer = 1;
      }

    System.out.println();
    System.out.println("Pairs are removed:");
    System.out.println("Player-1 hand: " + dealOne);
    System.out.println("Player-2 hand: " + dealTwo);
    System.out.println();
    System.out.println("Start Drawing...");

    
  
//Inital card drawing completed. Moving on to the core game loop.


    if(firstPlayer.equals("K") || secondPlayer.equals("K")){
        System.out.println("What are the odds! Dead deal. Restart the game.");
    }
    else{
        do{
            if (currentPlayer ==1){
                previousPlayer = 2;
            }
            else{
                previousPlayer = 1;
            }
           
        int firstPicksFromSecondIndex = rand.nextInt(secondPlayer.length());
        String firstPicksFromSecondCard = Character.toString(secondPlayer.charAt(firstPicksFromSecondIndex));
                System.out.println("Player-" + currentPlayer +" is drawing the card: " + firstPicksFromSecondCard + " from Player-" + previousPlayer + "...");

                secondPlayer = secondPlayer.replace(firstPicksFromSecondCard, "");
                firstPlayer = firstPlayer + firstPicksFromSecondCard;
                if(currentPlayer == 2){
                    dealTwo = firstPlayer;
                    dealOne = secondPlayer;
                }
                else{
                    dealOne = firstPlayer;
                    dealTwo = secondPlayer;
                }

                System.out.println("\t Player-1 hand: " + dealOne);
                System.out.println("\t Player-2 hand: " + dealTwo);
                System.out.println();

//Remove the duplicates if there are any.
                int firstPlayerHandLength = firstPlayer.length();

                  for(int i = 0; i<firstPlayerHandLength; i++){
                        boolean checker = true;
                        
                        for(int b = 1; b+i<firstPlayerHandLength && checker == true; b++){
                            if(firstPlayer.charAt(i) == firstPlayer.charAt(b+i)){
                                firstPlayer = firstPlayer.replaceFirst(Character.toString(firstPlayer.charAt(i)), "");
                                firstPlayer = firstPlayer.replaceFirst(Character.toString(firstPlayer.charAt(b+i-1)), "");
                                
                                checker = false;
                                i= -1;
                                firstPlayerHandLength = firstPlayer.length();
                            }
                         }
                    }

                    if(currentPlayer ==2){
                        previousPlayer = currentPlayer;
                        dealTwo = firstPlayer;
                        dealOne = secondPlayer;
                        currentPlayer = 1;
                    }
                    else{
                        previousPlayer = currentPlayer;
                        dealOne = firstPlayer;
                        dealTwo = secondPlayer;
                        currentPlayer = 2;
                    }

                    trash = firstPlayer;
                    firstPlayer = secondPlayer;
                    secondPlayer = trash;
                  
                    System.out.println("Pairs are removed:");
                    System.out.println("Player-1 hand: " + dealOne);
                    System.out.println("Player-2 hand: " + dealTwo);
                    System.out.println();                   

                    if(dealOne.equals("K")||dealTwo.equals("K")){
                        System.out.println("Game Over!");
                        System.out.println("Player-" + previousPlayer +" Wins!");
                        System.out.println("\t Player-1 hand: " + dealOne);
                        System.out.println("\t Player-2 hand: " + dealTwo);
                        sentinel = false;
                    }  
                }
                while(sentinel == true);
    }
}
}

