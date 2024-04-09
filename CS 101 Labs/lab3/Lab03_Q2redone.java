package lab3;
import java.util.Scanner;

public class Lab03_Q2redone {
    public static void main(String[] args){
        int number = 1;

        Scanner in = new Scanner(System.in);
        while(number>0) {
        System.out.print("Enter a number: ");
        
        if (in.hasNextInt())
        {
            number = in.nextInt();
            if ((number < 99) || (number > 9999999))
            {
                System.out.println("The input is invalid! The number must be between 3 and 7 digits long.");
            }
            
            else
            {
                int digits = (int) (Math.log10(number)+1);
                System.out.println("The number has "+ digits +" digits.");

                String croppedNumber = Integer.toString(number);

             
                while(croppedNumber.length()>1 && croppedNumber.charAt(0) == croppedNumber.charAt(croppedNumber.length()-1)) {
                    croppedNumber = croppedNumber.substring(1,croppedNumber.length()-1);
                    
                }
                if (croppedNumber.length()>1)
                {
                    System.out.println(number +" is NOT a palindromic number.");
                }
                else 
                {
                    System.out.println(number +" is a palindromic number.");
                }
            }
        }
        else
        {
            number = 0;
            System.out.println("Please enter a positive integer that is 3 to 7 digits long.");
           
        }
    }
    in.close();
    }
    
}
