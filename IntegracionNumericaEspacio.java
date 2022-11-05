import java.text.DecimalFormat;

public class IntegracionNumericaEspacio {
    static DecimalFormat formatoDecimal = new DecimalFormat("0.0000");

    public static void main(String[] args) {
        double a, b, c, d, k, h;
        double[][] tabla;
        int n, m;

        a = 0;
        b = 1;
        m = 3;
        h = (b-a)/m;

        c = 0;
        d = 1;
        n = 3;
        k = (d-c)/n;

        tabla = new double[n+1][m+1];

        // Llenado de tabla de datos
        for(int i = 0; i < tabla.length; i++) {
            for(int j = 0; j < tabla[0].length; j++){
                System.out.print("("+formatoDecimal.format(a+j*h)+", "+formatoDecimal.format(c+k*i)+")  ");
                tabla[i][j] = f(a+j*h,c+k*i);
            }
            System.out.println("");
        }
        System.out.println("");
        tablaF(tabla);
        System.out.println("");

        // Llamado a trapecios y simpson
        System.out.println("Trapecios: ");
        System.out.println(" = "+trapecios(tabla, h, k));
        if(tabla.length >= 3 && tabla.length % 2 != 0 && tabla[0].length >= 3 && tabla[0].length % 2 !=0){
            System.out.println("Simpson 1/3: ");
            System.out.println(" = "+simpson(tabla, h, k));
        }
    }

    public static double trapecios(double[][] tabla, double h, double k){
        double sum = 0;
        double[] tablaIntegrales = new double[tabla.length];

        for(int i = 0; i < tabla.length; i++){
            sum = 0;
            tablaIntegrales[i] = tabla[i][0];                   // x0
            tablaIntegrales[i] += tabla[i][tabla[0].length-1];  // xn
            for(int j = 1; j < tabla[0].length-1; j++){
                sum += tabla[i][j];                             // 2*xj
            }
            tablaIntegrales[i] += 2*sum;
            tablaIntegrales[i] *= h/2;
            System.out.println("I"+i+": "+formatoDecimal.format(h)+"/2"+"("+formatoDecimal.format(tabla[i][0])+ " + "+formatoDecimal.format(tabla[i][tabla[0].length-1])+" + 2("+formatoDecimal.format(sum)+")) = "+tablaIntegrales[i]);
        }

        sum = 0;
        for(int i = 1; i < tablaIntegrales.length-1; i++){
            sum += tablaIntegrales[i];
        }
        System.out.print("I:  " + formatoDecimal.format(k) + "/2(" + formatoDecimal.format(tablaIntegrales[0]) + " + " + formatoDecimal.format(tablaIntegrales[tablaIntegrales.length-1]) + " + 2(" + formatoDecimal.format(sum) + "))");
        return (k/2) * (tablaIntegrales[0] + tablaIntegrales[tablaIntegrales.length-1] + 2 * sum);
    }

    public static double simpson(double[][] tabla, double h, double k){
        double sumP = 0, sumI = 0;
        double[] integrales = new double[tabla.length];

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
            integrales[i] *= (h/3);
            System.out.println("I"+i+": (" + formatoDecimal.format(h) + "/3)(" + formatoDecimal.format(tabla[i][0]) + " + " + formatoDecimal.format(tabla[i][tabla[0].length-1]) + " + 4(" + formatoDecimal.format(sumI) + ") + 2("+formatoDecimal.format(sumP)+")) = " + integrales[i]);            
        }

        double sumParTotal = 0, sumImparTotal = 0;    
        for(int i = 1; i < integrales.length-1; i++){
            if(i % 2 == 0){
                sumParTotal += integrales[i];
            }else{
                sumImparTotal += integrales[i];
            }
        }
        System.out.print("I:  (" + formatoDecimal.format(k) + "/3)(" + formatoDecimal.format(integrales[0]) + " + " + formatoDecimal.format(integrales[integrales.length-1])+ " + 4(" + formatoDecimal.format(sumImparTotal) + ") + 2("+formatoDecimal.format(sumParTotal)+"))");
        return (k/3) * (integrales[0] + integrales[integrales.length-1] + 4 * sumImparTotal + 2 * sumParTotal);
    }

    public static void tablaF(double[][] tabla){
        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < tabla[0].length; j++){
                System.out.print("("+formatoDecimal.format(tabla[i][j])+")  ");
            }
            System.out.println("");
        }
    }
    
    public static double f(double x, double y){
        return Math.pow(x,2) + Math.pow(y,2);
    }


    /*
        f(x,y) Utilizados:
            Teoria 1: Math.pow(x,2) + Math.pow(y,2);
            Teoria 2: Math.log(x + 2 * y);
            TPO5: Math.pow(Math.E, (y-x));
        
        
    */
}
