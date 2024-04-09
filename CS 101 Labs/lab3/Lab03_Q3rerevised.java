package lab3;
import java.util.Scanner;
public class Lab03_Q3rerevised {
  
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int a = 1;
        
        String username = "eben";
        String password = "anan";
        int credits = 600;
        String buddy = null;
        while(a>0)
        {
        System.out.print("Enter your username: ");
        
        String inputUsername = in.next();
        if(inputUsername.equals(username))


        {
            System.out.print("Enter your password: ");
            
            String inputPassword = in.next();
            if(inputPassword.equals(password))
            {
                System.out.println("1- Upgrade armor");
                System.out.println("2- Add a buddy");
                System.out.println("3- Change credentials");
                System.out.print("Select an option: ");
                int readnumber = in.nextInt();
                if (readnumber== 1)
                {
                    System.out.println("\nUpgrade armour:");
                    System.out.println("You have " +credits+" coins.");
                    if (credits >= 150)
                    {
                        credits = credits-150;
                        System.out.println("Your armour has been upgraded!");
                        System.out.println("You have "+credits+" coins. Bye!");
                    }
                    else
                    {
                        System.out.println("Not enough coins! Bye!");
                    }
                }
                else if(readnumber== 2)
                {
                    System.out.println("\nAdd a buddy:");
                  
                    
                    if (buddy == null)
                    {
                        System.out.print("Enter your buddy's name: ");
                        buddy = in.next();
                        System.out.println("\nYour buddy is "+buddy+". Bye!");

                    }
                    else
                    {
                        System.out.println("\nYou already have a buddy!");
                        System.out.println("Your buddy is "+buddy+". Bye!");
                    }
                }
                else if(readnumber== 3)
                {
                    System.out.print("\nChange credentials:");
                    System.out.println("\n1- Change username");
                    System.out.println("2- Change password");
                    System.out.print("Select an option:");
                    int readnumberfor3 = in.nextInt();
                    
                    if(readnumberfor3 == 1)
                    {
                        System.out.print("Enter your new username: ");
                        username = in.next();
                        System.out.println("\nYour username is "+username);
                        System.out.println("Your password is "+password);
                        System.out.println("Bye!");
                    }
                    else if(readnumberfor3== 2)
                    {
                        System.out.print("Enter your new password: ");
                        password = in.next();
                        System.out.println("\nYour username is "+username);
                        System.out.println("Your password is "+password);
                        System.out.println("Bye!");
                    }
                

                }
                    

                }
                else
                {
                    System.out.println("Password not found! Bye!");
                }
                }
                else
            {
                System.out.println("Username not found! Bye!");
            }
            
        }
        in.close();
            }
            

        }
       
        


    
   

