package lab4;
import java.util.Scanner;

public class Lab04_Q1 {
   
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int loop = 1;
        while (loop>0){
        System.out.print("Enter input n: ");
            if(in.hasNextInt()){
                int input = in.nextInt();
                String inputString = Integer.toString(input);
                if(input<=0){
                    System.out.println("Please enter a positive integer.");
                }
               
                else{
                    
                    int digits = inputString.length();
                    String reversedNumber = "";
                    while(digits>0){                      
                        reversedNumber = reversedNumber + inputString.charAt(digits-1);
                        inputString = inputString.substring(0,digits-1);
                        digits--;
                    }
                    System.out.println(reversedNumber);
                }
        }
        else{
            System.out.println("Please enter a positive integer.");
        }        

    }
    in.close();
    }
    
}
