import java.util.Scanner;

public class NewtonRaphson {
    public static void main(String[] args){
        double x0, x1, E;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese x0: ");
        x0 = sc.nextDouble();
        x1 = x0;
        System.out.print("Ingrese el valor de error E: ");
        E = sc.nextDouble();

        while(Math.abs(f(x1)) > E){
            System.out.println("x0 = " + x0 + "; f(x0) = " + f(x0) + "; f'(x0) = " + df(x0));
            x1 = x0 - f(x0) / df(x0);
            System.out.println("x1 = " + x1 + "\n--------------------------");
            x0 = x1;
        }

        System.out.print("Raiz aproximada: " + x1);
    }

    public static double f(double x){
        return Math.pow(x,3) - 2*x - 1;
    }
    public static double df(double x){
        return 3*Math.pow(x,2) - 2; 
    }
}
