package lab4;
import java.util.Scanner;

public class Lab04_Q2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = 1;
        while(a>0){

        System.out.print("Please input n: ");
        int input = in.nextInt();
        int binary = 0;

        while(input != 0){
             int power = (int) (Math.log(input)/Math.log(2));
             input = input - (int) Math.pow(2, power);
             binary = binary + (int) Math.pow(10,power);
            }
            System.out.println(binary);
        }
        in.close();
        }
      
    }
    

