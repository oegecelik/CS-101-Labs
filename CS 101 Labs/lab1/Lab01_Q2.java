import java.lang.Math;

public class Lab01_Q2
{
public static void main(String[] args ) {
    final double a = Math.pow(3,2);
    final double b = Math.pow(2,5);
    final double c = 2.4 - 0.4;
    final double d = (-2.0/6.0);

    double firstExpression = (32.2 - 17/22) / ((1.5 - 7.3) * (4.3 + 24));
    double secondExpression = (73.5 * 16.4 - a * 81) / (b + 34);
    double thirdExpression = Math.pow(c,d);

    
    System.out.println("Result of expression 1 is: "+ firstExpression);
    System.out.println("Result of expression 2 is: "+ secondExpression);
    System.out.println("Result of expression 3 is: "+ thirdExpression);

}
}