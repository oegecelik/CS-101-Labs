package lab4;

public class Lab04_Q4 {
    public static void main(String[] args){
        final double x_start = 0;
        double x = 0;
        final double x_end = 1;
        final double step_size = 0.01;
        final double pi = Math.PI;
        double total_areay = 0;
        double total_areah = 0;
        double h = 0;
        double y = 0;
        while (x < x_end){
            x = x + 0.01;
            y = Math.sin(pi*x) + (Math.sin(3*pi*x)/3);
            h = Math.pow(x, 2);
            total_areah = total_areah + step_size*h;
            total_areay = total_areay + step_size*y;          
        }
        System.out.println("The function is: x^2");
        System.out.println("Parameters:");
        System.out.println("x_start = " + x_start + ", x_end = " + x_end);
        System.out.println("step_size = " + step_size);
        System.out.println("Area under \"x^2\" from 0 to 1: " + total_areah);

        System.out.println("\nThe function is: sin(PI*x) + sin(PI*3*x)/3");
        System.out.println("Parameters:");
        System.out.println("x_start = " + x_start + ", x_end = " + x_end);
        System.out.println("step_size = " + step_size);
        System.out.println("Area under \"sin(PI*x) + sin(PI*3*x)/3\" from 0 to 1: " + total_areay);

     
    }
    
}
