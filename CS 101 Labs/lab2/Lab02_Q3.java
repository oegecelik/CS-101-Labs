package lab2;

import java.util.Scanner;
 
public class Lab02_Q3 { 
    public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the title:");
    String title = in.nextLine();
    System.out.println("--------------------------------------");

    System.out.println("Number of characters: \"" + title.length()+"\"");
    System.out.println("All lowercase: \""+  title.toLowerCase()+ "\"");
    System.out.println("Remove leading and trailing blank characters: \"" + title.strip()+"\"");
    System.out.println("Character at index position 4: \'" + title.charAt(4)+"\'");
    System.out.println("Title from 3rd character to 5th character (both included): \"" + title.substring(2,5)+"\"");
    System.out.println("First occurrence of character 'e': " + (title.indexOf('e')+1));
    System.out.println("Last occurrence of character 'e': " + (title.lastIndexOf('e')+1));

    in.close();
    }
}