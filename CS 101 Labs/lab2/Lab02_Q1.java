package lab2;

import java.util.Scanner;
 
public class Lab02_Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
        System.out.print("Enter length of the semi major axis of the ellipse: ");
            if (in.hasNextDouble())
            {
                double semiMajorAxis = in.nextDouble();
                System.out.print("\nEnter length of the semi minor axis of the ellipse: ");   
                    if (in.hasNextDouble())
                    {
                    double semiMinorAxis = in.nextDouble(); 
                    double areaOfEllipse = 3.14159265359 * semiMinorAxis * semiMajorAxis;  
                    double circumferenceOfEllipse = 2 * 3.14159265359 * Math.sqrt((Math.pow( semiMinorAxis , 2.0 ) + Math.pow(semiMajorAxis , 2.0))/2);
            
                    System.out.printf("The area of the ellipse is            : %10.3f", areaOfEllipse);
                    System.out.printf("\nThe circumference of the ellipse is ~ : %10.3f", circumferenceOfEllipse);
                    }   
                    else
                    {
                    System.out.println("Error: Not a number. Please type in a number.");
                    }   
                } 
            else
            {
                System.out.println("Error: Not a number. Please type in a number.");
            }
            in.close();

    }
}
