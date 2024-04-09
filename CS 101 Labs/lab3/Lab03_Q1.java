package lab3;
import java.util.Scanner;

public class Lab03_Q1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Graduation Eligibility Checker");
        System.out.print("Enter your credit units: ");
        
        if (in.hasNextInt())
         {
            int creditUnits = in.nextInt();
            if (creditUnits > 120) 
            {
                System.out.print("Enter your CGPA: ");
                if (in.hasNextDouble())
                {
                    double cGPA = in.nextDouble();
                    if (cGPA > 2.00)
                    {
                        System.out.println("The graduation requirements are satisfied.");
                    }
                    else
                    {
                        System.out.println("The graduation requirements are NOT satisfied.");
                    }

                }
                else
                {
                    System.out.println("Your CGPA should be a number. Please enter a number.");
                }
            }
            else
            {
                System.out.println("The graduation requirements are NOT satisfied.");
            }



        }
        else
        {
            System.out.println("Your credit units should be an integer. Please enter an integer.");
        }

in.close();
    }

}

