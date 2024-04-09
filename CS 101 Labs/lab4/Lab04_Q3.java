package lab4;
import java.util.Scanner;

public class Lab04_Q3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean programContinues = true;
        while(programContinues == true){

            System.out.print("Enter input n: ");
            int input = in.nextInt();
            int binary = 0;
            int inputAltered = 0;
            System.out.print("Please choose the operation. Division or Multiplication 'd' or 'm'?:");
            String operation = in.next();

            while (!operation.equals("d") && !operation.equals("m")){
                System.out.print("Unrecognizable operation. Please choose the operation. Division or Multiplication 'd' or 'm'?:");
                operation = in.next();
            }

            System.out.print("Enter the multiplier or divisor that is a multiple of two: ");

            if (operation.equals("d")){
                int divisor = in.nextInt();
                int toRight = (int) (Math.log(divisor)/Math.log(2));
                inputAltered = input >> toRight;                
            }
            else if (operation.equals("m")){
                int multiplier = in.nextInt();
                int toLeft = (int) (Math.log(multiplier)/Math.log(2));
                inputAltered = input << toLeft;
             
            }
            while(inputAltered != 0){
                int power = (int) (Math.log(inputAltered)/Math.log(2));
                inputAltered = inputAltered - (int) Math.pow(2, power);
                binary = binary + (int) Math.pow(10,power);
               }
              
           System.out.println("0b" + binary);
           System.out.print("Do you want to do another operation? 'y' (yes) or 'n' (no): ");
           String yesOrNo = in.next();

           while (!yesOrNo.equals("y") && !yesOrNo.equals("n")){
            System.out.println("Do you want to do another operation? 'y' (yes) or 'n' (no): ");
            yesOrNo = in.next();
            }

           if(yesOrNo.equals("y")){
            programContinues = true;
           }
           else if(yesOrNo.equals("n")){
            programContinues = false;
            System.out.println("Program finished.");
           }
          
        }
        in.close();
    }
    
}
