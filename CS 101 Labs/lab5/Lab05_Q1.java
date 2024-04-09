package lab5;

import java.util.Scanner;


public class Lab05_Q1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter 'falling stars' as string: ");

        String userInput = in.next();
        String alteredUserInput = userInput;

        int maxDigit = 0;
     
        for(int a = 0; a<userInput.length(); a++){
            if(Character.getNumericValue(userInput.charAt(a)) > maxDigit){
                maxDigit = Character.getNumericValue(userInput.charAt(a));
            }
        }
        

        for(int lineNumber = 1; lineNumber<=maxDigit; lineNumber++){
            userInput = alteredUserInput;
            alteredUserInput = "";
           

            for(int i=0; i<userInput.length(); i++){
                
                String digitString = Character.toString(userInput.charAt(i));
                int digitValue = Integer.valueOf(digitString);

                if(digitValue>0)
                {
                    digitValue--;
                    digitString = Integer.toString(digitValue);
                    alteredUserInput = alteredUserInput + digitString;                
                    System.out.print("*");         
                }
                else
                {
                    digitString = Integer.toString(digitValue);
                    alteredUserInput = alteredUserInput + digitString;
                    System.out.print(" ");                   
                }
                
    
            }
            System.out.println();
        }
        in.close();

    }

}
