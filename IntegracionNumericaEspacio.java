import java.util.Scanner;

public class IntegracionNumericaEspacio {
    public static void main(String[] args) {
        double a, b, c, d, k, h, res, sum;
        double[][] tabla;
        int n, m;
        Scanner sc = new Scanner(System.in);

        a = 0;
        b = 2;
        m = 2;
        h = (b-a)/m;

        c = 0;
        d = 2;
        n = 2;
        k = (d-c)/n;

        tabla = new double[m+1][n+1];

        // Llenado de tabla de datos
        for(int i = 0; i < tabla.length; i++) {
            for(int j = 0; j < tabla[0].length; j++){
                System.out.print("("+(a+j*h)+", "+(c+k*i)+")  ");
                tabla[i][j] = f(a+j*h,c+k*i);
            }
            System.out.println("");
        }
        tablaF(tabla);

        simpson(tabla, h);

        /*
System.out.println("I=" + trapecios(tabla, h));
        if(tabla.length >= 3 && tabla.length % 2 != 0 && n >= 2 && n % 2 == 0){
            System.out.println("I=" + simpson(tabla, h));
        }
         */
        
    }

    public static double trapecios(double[][] tabla, double h){
        double sum = 0;
        double[] tablaIntegrales = new double[tabla.length];

        for(int i = 0; i < tablaIntegrales.length; i++){
            tablaIntegrales[i] = tabla[i][0];
            System.out.print(tablaIntegrales[i]);
            tablaIntegrales[i] += tabla[i][tabla[0].length-1];
            System.out.print(tablaIntegrales[i]);
            for(int j = 1; j < tabla[0].length-2; i++){
                tablaIntegrales[i] += 2*tabla[i][j];
            }
            System.out.print(tablaIntegrales[i]);
        }

        for(int i = 0; i < tablaIntegrales.length; i++){
            System.out.print(tablaIntegrales[i]+"  ");
        }

        /*
         * 
         * System.out.println("Trapecios: (" + h + "/2)(" + tabla[0][2] + "+" + tabla[tabla.length-1][2] + "+2(" + sum + "))");
        return (h/2) * (tabla[0][2] + tabla[tabla.length-1][2] + 2 * sum);
         */
        return 1.0;
    }

    public static double simpson(double[][] tabla, double h){
        double sumP = 0, sumI = 0;
        double[] integrales = new double[tabla[0].length];

        for(int i = 0; i < tabla.length; i++){
            sumI = 0;
            sumP = 0;

            for(int j = 1; j < tabla[0].length-1; j++){
                if(j % 2 == 0){
                    sumP += tabla[i][j];
                }else{
                    sumI += tabla[i][j];
                }
            }
            integrales[i] = tabla[i][0];  
            integrales[i] += tabla[i][tabla[0].length-1];
            integrales[i] += 4 * sumI + 2 * sumP;            
        }

        System.out.println("Simpson 1/3: (" + h + "/3)(" + tabla[0][2] + "+" + tabla[tabla.length-1][2] + "+4(" + sumI + ")+2("+sumP+"))");
        return (h/3) * (tabla[0][2] + tabla[tabla.length-1][2] + 4 * sumI + 2 * sumP);
    }

    public static void tablaF(double[][] tabla){
        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < tabla[0].length; j++){
                System.out.print("("+tabla[i][j]+")  ");
            }
            System.out.println("");
        }
    }

    public static void imprimirTabla(double[][] tabla){
        /*
         * for(int i = 0; i < tabla.length; i++){
            System.out.print("I"+i+" = "+h/2+"[");
            for(int j = 0; j < tabla[0].length; j++){
                System.out.print("I"+i+" = "+h/2+"[");
            }
            
            System.out.println("i= " + tabla[i][0] + ";  x=" + tabla[i][1] + ";  f(x)=" + tabla[i][2]);
        }
         */
        
    }
    
    public static double f(double x, double y){
        return Math.pow(x,2) + Math.pow(y,2);
    }

    /*
        F(x) Utilizados:
            TP1E18A: 5 * Math.pow(x, 2) + 2 * x - 3;
            TP1E18B: Math.pow(Math.E, x);
            TPO1E4: 
    */
}
