//THIS PROGRAM WILL NOT WORK! Make in.close() as a comment.
package lab6;
import java.util.Scanner;

public class Lab06_Q1validationa {
    public static int asker() {
        Scanner in = new Scanner(System.in);
        boolean checker = false;
        int toReturn = 0;
        do{
            checker = false;
            if(in.hasNextInt()){
                toReturn = in.nextInt();
                if (toReturn>0) checker = true;                

            }
            if (!checker) System.out.print("Wrong input. Please enter again: ");
            in.nextLine();
            
        }while(!checker);
       in.close();     
        return toReturn;  
    }
    public static int floor(double toFloor) {
        int floored = (int) toFloor;
        return floored;        
    }
    public static int digitDecoder(int x) {
        int dx = floor(10-(x/2.0-3)*(x/2.0-3)-0.32);
        return dx;        
    }
    public static int passwordDecoder(int password) {
        int decodedPassword = 0;
        int decodedDigit = 0;

        int toDetermineDigits = password;
        int digits = 0;
        while(toDetermineDigits>0){
            toDetermineDigits /=10;
            digits++;
        }

        for (int i = 1; i<=digits; i++){
            int specificDigit = 0;
            specificDigit = password % 10;
            decodedDigit = digitDecoder(specificDigit);
            password /= 10;
            for(int a = 1; a<i; a++){
                decodedDigit *=10;
            }
            decodedPassword +=decodedDigit;
        }
        return decodedPassword;        
    }
    public static boolean isPrime(int inputNatural) {
        int counter = 0;
        for(int i = 2; i<=inputNatural; i++){
            if(inputNatural%i == 0){
                counter++;
            }
        }
        if(counter == 1){
            return true;
        }
        else{
            return false;
        }        
    }
    public static int primeSummation(int inputNatural) {
        int primeSummation = 0;
        if(isPrime(inputNatural)==true){
            return inputNatural;
        }
        else{
            for(int i = 2; i<=inputNatural; i++){
                if(inputNatural % i == 0){
                    boolean isPrime = isPrime(i);
                    if(isPrime == true){
                        primeSummation += i;
                    }
                } 
        }
        return primeSummation;
         }
    }
    public static int power(int oneOfAllThreeInput, int power) {
        int powered = oneOfAllThreeInput;
        for(int i= 1; i< power; i++){
            powered *= powered;
        }
        return powered;
    }
    public static boolean isPythagorean(int input1, int input2, int input3) {
        boolean check = false;
        if(power(input1,2) == power(input2, 2) + power(input3, 2)){
            check = true;
        }
        else if(power(input2,2) == power(input1, 2) + power(input3, 2)){
            check = true;
        }
        else if(power(input3,2) == power(input1, 2) + power(input2, 2)){
            check = true;
        }
        else{
            check = false;
        }
        return check;
    }
    public static long intToBinary(int inputInteger) {
        int inputIntegerDivide2Check = inputInteger;
        int remainingInput = inputInteger;
        int toReturn = 0;

        while(remainingInput>0){
            int digitToAdd = 1;
            int numberToSubtract = 1;
            int countOf2 = 0;
            while(inputIntegerDivide2Check >1){
                inputIntegerDivide2Check /= 2;
                countOf2++;
                numberToSubtract *=2;
            }
            for(int i = 1; i<=countOf2; i++){
                digitToAdd *=10;
            }
            if(remainingInput == 1){
                toReturn +=1;
                remainingInput -=1;
            }
            else{
                remainingInput -= numberToSubtract;
                toReturn += digitToAdd;
                inputIntegerDivide2Check = remainingInput;
            }
        }
       return toReturn;
    }
    public static long binaryAND(int firstInput, int secondInput) {
        long binary1 = intToBinary(firstInput);
        long binary2 = intToBinary(secondInput);
        long toReturn = 0;
        int digits = 0;
        long toDetermineDigits1 = binary1;
        
        while(toDetermineDigits1>0){
            toDetermineDigits1 /=10;
            digits++;
        }

        for(int i = 0; i < digits; i++){
            long binaryAndDigit = 0;
            if(binary1 % 10 == 1 && binary2 % 10 == 1){
                binaryAndDigit = 1;
            }
            for(int b = 0; b<i; b++){
                binaryAndDigit *=10;
            }
            toReturn += binaryAndDigit;
            binary1 /= 10;
            binary2 /= 10;
        }
        return toReturn;
    }
    public static long binaryOR(int firstInput, int secondInput) {
        long binary1 = intToBinary(firstInput);
        long binary2 = intToBinary(secondInput);
        long toReturn = 0;
        int digits = 0;
        long toDetermineDigits1 = binary1;
        
        while(toDetermineDigits1>0){
            toDetermineDigits1 /=10;
            digits++;
        }

        for(int i = 0; i < digits; i++){
            long binaryAndDigit = 0;
            if(binary1 % 10 == 1 || binary2 % 10 == 1){
                binaryAndDigit = 1;
            }
            for(int b = 0; b<i; b++){
                binaryAndDigit *=10;
            }
            toReturn += binaryAndDigit;
            binary1 /= 10;
            binary2 /= 10;
        }
        return toReturn;
    }
    public static void main(String[] args) {

        int password = 0;
        int inputNatural = 0;
        int primeSummation = 0;
        int input1 = 0;
        int input2 = 0;
        int input3 = 0;
        int power = 2;
        int input1ForBinary = 0;
        int input2ForBinary = 0;

        System.out.print("Enter your password: ");
        password = asker();

        int decodedPassword = passwordDecoder(password);
        System.out.println("Your decoded password is: " + decodedPassword);
        System.out.print("Please input the natural number: ");

        inputNatural = asker();
        primeSummation = primeSummation(inputNatural);
     
        System.out.println("The summation of the prime factors of "+ inputNatural + " is " + primeSummation + ".");
        System.out.print("Please input the first number: ");
        input1 = asker();
        System.out.print("Please input the second number: ");
        input2 = asker();
        System.out.print("Please input the third number: ");
        input3 = asker();
        boolean isPythagorean = isPythagorean(input1, input2, input3);
        if(isPythagorean == false){
            System.out.println("The triplet is not Pythagorean.");
        }
        else{
            if(power(input1,power) == power(input2,power) + power(input3, power)){
                System.out.println("The triplet is Pythagorean, power("+input1+", " +power+ ") = power(" + input2+", " +power+") + power("+input3+", "+power+")");
            }
            else if(power(input2,power) == power(input1, power) + power(input3, power)){
                System.out.println("The triplet is Pythagorean, power("+input2+", " +power+ ") = power(" + input1+", " +power+") + power("+input3+", "+power+")");
            }
            else if(power(input3, power) == power(input1, power) + power(input2, power)){
                System.out.println("The triplet is Pythagorean, power("+input3+", " +power+ ") = power(" + input1+", " +power+") + power("+input2+", "+power+")");
            }
        }
        System.out.print("Please enter the first natural number: ");
        input1ForBinary = asker();
        System.out.print("Please enter the second natural number: ");
        input2ForBinary = asker();
        long binary1 = intToBinary(input1ForBinary);
        long binary2 = intToBinary(input2ForBinary);
        System.out.println("Binary representation of the first number: " + binary1);
        System.out.println("Binary representation of the second number: " + binary2);
        System.out.println("The bitwise AND operation result: " + binaryAND(input1ForBinary, input2ForBinary));
        System.out.println("The bitwise OR operation result: " + binaryOR(input1ForBinary, input2ForBinary));

    }
}
