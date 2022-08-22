import java.util.Scanner;

public class IntegracionNumerica {
    public static void main(String[] args) {
        double a, b, h, res, sum;
        double[][] tabla;
        int n;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese a: ");
        a = sc.nextDouble();
        System.out.print("Ingrese b: ");
        b = sc.nextDouble();
        System.out.print("Ingrese n (cantidad de partes): ");
        n = sc.nextInt();

        h = (b-a)/n;

        tabla = new double[n+1][3];

        // Llenado de tabla de datos
        tabla[0][0] = 0;
        tabla[0][1] = a;
        tabla[0][2] = f(a);
        for(int i = 1; i < tabla.length; i++) {
            tabla[i][0] = i;
            tabla[i][1] = tabla[i-1][1] + h;
            tabla[i][2] = f(tabla[i][1]);
        }
        
        imprimirTabla(tabla);
        System.out.println("I=" + trapecios(tabla, h));
        if(tabla.length >= 3 && tabla.length % 2 != 0 && n >= 2 && n % 2 == 0){
            System.out.println("I=" + simpson(tabla, h));
        }
    }

    public static double trapecios(double[][] tabla, double h){
        double sum = 0;

        for(int i = 1; i < tabla.length-1; i++){
            sum += tabla[i][2];
        }

        System.out.println("Trapecios: (" + h + "/2)(" + tabla[0][2] + "+" + tabla[tabla.length-1][2] + "+2(" + sum + "))");
        return (h/2) * (tabla[0][2] + tabla[tabla.length-1][2] + 2 * sum);
    }

    public static double simpson(double[][] tabla, double h){
        double sumP = 0, sumI = 0;

        for(int i = 1; i < tabla.length-1; i++){
            if(tabla[i][0] % 2 == 0){
                sumP += tabla[i][2];
            }else{
                sumI += tabla[i][2];
            }
        }

        System.out.println("Simpson 1/3: (" + h + "/3)(" + tabla[0][2] + "+" + tabla[tabla.length-1][2] + "+4(" + sumI + ")+2("+sumP+"))");
        return (h/3) * (tabla[0][2] + tabla[tabla.length-1][2] + 4 * sumI + 2 * sumP);
    }

    public static void imprimirTabla(double[][] tabla){
        for(int i = 0; i < tabla.length; i++){
            System.out.println("i= " + tabla[i][0] + ";  x=" + tabla[i][1] + ";  f(x)=" + tabla[i][2]);
        }
    }
    
    public static double f(double x){
        return Math.pow(Math.E, x);
    }

    /*
        F(x) Utilizados:
            TP1E18A: 5 * Math.pow(x, 2) + 2 * x - 3;
            TP1E18B:
    */
}
