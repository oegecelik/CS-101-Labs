package lab2;

import java.util.Scanner;
 
public class Lab02_Q2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
//AV stands for average.
//PERC stands for percentage.

          final double AV_CONSTRUCTION_COST = 237760;
          final double SITE_WORK_COST = 15903;
          final double FOUNDATIONS = 25671;
          final double FRAMING = 41123;
          final double EXTERIOR = 33066;
          final double UTILITY = 32746;
          final double INTERIOR_FINISHES = 67939;
          final double OUTDOOR = 16591;
          final double UNEXPECTED_COSTS = AV_CONSTRUCTION_COST - (SITE_WORK_COST + FOUNDATIONS + FRAMING + EXTERIOR + UTILITY + INTERIOR_FINISHES + OUTDOOR);
          
          final double PERC_SITE_WORK_COST = 100*SITE_WORK_COST/AV_CONSTRUCTION_COST;
          final double PERC_FOUNDATIONS = 100*FOUNDATIONS/AV_CONSTRUCTION_COST;
          final double PERC_FRAMING = 100*FRAMING/AV_CONSTRUCTION_COST;
          final double PERC_EXTERIOR = 100*EXTERIOR/AV_CONSTRUCTION_COST;
          final double PERC_UTILITY = 100*UTILITY/AV_CONSTRUCTION_COST;
          final double PERC_INTERIOR_FINISHES = 100*INTERIOR_FINISHES/AV_CONSTRUCTION_COST;
          final double PERC_OUTDOOR = 100*OUTDOOR/AV_CONSTRUCTION_COST;
          final double PERC_UNEXPECTED_COSTS = 100*UNEXPECTED_COSTS/AV_CONSTRUCTION_COST;
          

          System.out.println("Enter the cost of building a house in USD:\t");
          if (in.hasNextDouble())
          {
              double total = in.nextDouble()/100;
              System.out.println("");
              System.out.println("*************************************************");
              System.out.printf("*****%34s%5s*****\n", "House Cost Distribution Table","");
              System.out.println("*************************************************");
               System.out.printf("* Site Work%14s%20.2f\t*\n", "%"+(int)Math.floor(PERC_SITE_WORK_COST), PERC_SITE_WORK_COST*total);
               System.out.printf("* Foundations%13s%19.2f\t*\n","%"+ (int)Math.floor(PERC_FOUNDATIONS), PERC_FOUNDATIONS*total);
               System.out.printf("* Framing%17s%19.2f\t*\n", "%"+(int)Math.floor(PERC_FRAMING), PERC_FRAMING*total);
               System.out.printf("* Exterior%16s%19.2f\t*\n", "%"+(int)Math.floor(PERC_EXTERIOR), PERC_EXTERIOR*total);
               System.out.printf("* Utility%17s%19.2f\t*\n","%"+ (int)Math.floor(PERC_UTILITY), PERC_UTILITY*total);
               System.out.printf("* Interior Finishes%7s%19.2f\t*\n", "%"+(int)Math.floor(PERC_INTERIOR_FINISHES), PERC_INTERIOR_FINISHES*total);
               System.out.printf("* Outdoor%16s%20.2f\t*\n", "%"+(int)Math.floor(PERC_OUTDOOR), PERC_OUTDOOR*total);
               System.out.printf("* Unexpected Costs%7s%20.2f\t*\n","%"+ (int)Math.floor(PERC_UNEXPECTED_COSTS), PERC_UNEXPECTED_COSTS*total);
               System.out.printf("* TOTAL %37.2f\t*\n", total*100);
               System.out.println("*************************************************");

          }
          else
          {
              System.out.println("Error: not a number. Please enter a number.");
          }
 in.close();
    }
} 