package lab5;
import java.util.Random;

public class Lab05_Q2 {
    public static void main(String[] args){

        Random rand = new Random();

        int deckLength = 51;
        int previousPlayer = 0;
        int currentPlayer = 0;
        boolean sentinel = true;
        
        String deck = "";
        String dealSpecificA = "";
        String dealSpecificAChanged ="";
        String dealSpecificB = "";
        String dealSpecificBChanged = "";
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

        
            for(int a = 1; a<=26; a++){
                int randomPickOneIndex = rand.nextInt(deckLength);
                String cardPick = Character.toString(deck.charAt(randomPickOneIndex));
                dealSpecificA = dealSpecificA + cardPick;
                deck = deck.replaceFirst(cardPick, "");
                deckLength--;
            }
            System.out.println("Player 1's deal: " + dealSpecificA);
            dealSpecificAChanged = dealSpecificA;

            
//Remove duplicates.
            int dealSpecificALength = dealSpecificA.length();

            for(int i = 0; i<dealSpecificALength; i++){
                boolean checker = true;
                
                for(int b = 1; b+i<dealSpecificALength && checker == true; b++){
                    if(dealSpecificAChanged.charAt(i) == dealSpecificAChanged.charAt(b+i)){
                        dealSpecificAChanged = dealSpecificAChanged.replaceFirst(Character.toString(dealSpecificAChanged.charAt(i)), "");
                        dealSpecificAChanged = dealSpecificAChanged.replaceFirst(Character.toString(dealSpecificAChanged.charAt(b+i-1)), "");

                        checker = false;
                        i= -1;
                        dealSpecificALength = dealSpecificAChanged.length();
                    }
                 }
            }
            
            for(int i = 1; i<=25; i++){
                int randomPickTwoIndex = rand.nextInt(deckLength);
                String cardPick = Character.toString(deck.charAt(randomPickTwoIndex));
                dealSpecificB = dealSpecificB + cardPick;
                deck = deck.replaceFirst(cardPick, "");
                deckLength--;
            }

            System.out.println("Player 2's deal: " + dealSpecificB);
            dealSpecificBChanged = dealSpecificB;

//Remove duplicates.

            int dealSpecificBLength = dealSpecificB.length();

            for(int i = 0; i<dealSpecificBLength; i++){
                boolean checker = true;
                
                for(int b = 1; b+i<dealSpecificBLength && checker == true; b++){
                    if(dealSpecificBChanged.charAt(i) == dealSpecificBChanged.charAt(b+i)){
                        dealSpecificBChanged = dealSpecificBChanged.replaceFirst(Character.toString(dealSpecificBChanged.charAt(i)), "");
                        dealSpecificBChanged = dealSpecificBChanged.replaceFirst(Character.toString(dealSpecificBChanged.charAt(b+i-1)), "");
                        
                        checker = false;
                        i= -1;
                        dealSpecificBLength = dealSpecificBChanged.length();
                    }
                 }
            }
        
      
    dealSpecificA = dealSpecificAChanged;
    dealSpecificB = dealSpecificBChanged;

    if(getsOneMoreCard == 1){
        dealOne = dealSpecificA; 
        dealTwo = dealSpecificB;
        firstPlayer = dealTwo;
        secondPlayer = dealOne;
        currentPlayer = 2;         
      }
      else{
        dealOne = dealSpecificB;
        dealTwo = dealSpecificA;
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
                        dealTwo = firstPlayer;
                        dealOne = secondPlayer;
                        currentPlayer = 1;
                    }
                    else{
                        dealOne = firstPlayer;
                        dealTwo = secondPlayer;
                        currentPlayer = 2;
                    }
    
                  
                    System.out.println("Pairs are removed:");
                    System.out.println("Player-1 hand: " + dealOne);
                    System.out.println("Player-2 hand: " + dealTwo);
                    System.out.println();
                    trash = firstPlayer;
                    firstPlayer = secondPlayer;
                    secondPlayer = trash;

                    if(dealOne.equals("K")){
                        System.out.println("Game Over!");
                        System.out.println("Player-2 Wins!");
                        System.out.println("\t Player-1 hand: " + dealOne);
                        System.out.println("\t Player-2 hand: " + dealTwo);
                        sentinel = false;
                    }
                    else if(dealTwo.equals("K")){
                        System.out.println("Game Over!");
                        System.out.println("Player-1 Wins!");
                        System.out.println("\t Player-1 hand: " + dealOne);
                        System.out.println("\t Player-2 hand: " + dealTwo);
                        sentinel = false;
                    }

  
                }
                while(sentinel == true);
    }

}

}

