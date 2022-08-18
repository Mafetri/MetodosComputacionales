import java.util.Scanner;

class Biseccion{
    public static void main(String[] args){
        double a, b, E, r;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el valor de a: ");
        a = sc.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        b = sc.nextDouble();
        System.out.print("Ingrese el valor del error E: ");
        E = sc.nextDouble();

        if(f(a)*f(b) < 0){
            do{
                r = (a+b)/2;
                System.out.println("[" + a + ", " + b + "] => r = " + r + "; f(a) = "+f(a)+"; f(r) = "+f(r));
                if(f(a)*f(r)<0){
                    b = r;
                }else{
                    a = r;
                }
            }while(Math.abs(f(r)) >= E);

            System.out.println("Raiz aproximada: "+r);
        }else{
            System.out.println("No se cumple con la condicion inicial");
        }
    }

    public static double f(double x){
        return Math.PI * (Math.pow(x,2)) * ((9 - x) / 3) - 30;
    }

    /*
        Funciones utilizadas:
            TP1E8A: Math.pow(x,3) - 2*x - 1; 
            TP1E8B: 2 * Math.sin((x+1));
            TP1E13: 80 * Math.pow(Math.E, -2*x) + 20 * Math.pow(Math.E, -0.5*x) - 7;
            TP1E14: Math.PI * (Math.pow(x,2)) * ((9 - x) / 3) - 30;
    */
}

