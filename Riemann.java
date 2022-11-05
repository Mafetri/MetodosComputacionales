public class Riemann {
    public static void main(String[] args) {
        int n = 4, m = 4;
        double a = 0, b = 2, c = 0, d = 1, dX = (b-a)/m, dY = (d-c)/n, dA = dX * dY, x = a, y = c;
        double res = 0;

        System.out.println("Para m = "+m+", n = " + n + " con un dA = "+dA);

        for(int i = 1; i <= m; i++){
            y += dY;
            x = a;
            for(int j = 1; j <= n; j++){
                x += dX;
                System.out.println("f("+x+","+y+") = "+f(x,y));
                System.out.println("Sumatoria = " + res + " + " + f(x,y) + "(" + dA + ")");
                res += f(x,y) * dA;
            }
        }

        System.out.println("Resultado: " + res);
    }

    public static double f(double x, double y){
        return Math.pow(x,2) + 4 * Math.pow(y,2);
    }
}

/*
Funcion de la teoria:
    return 16 - Math.pow(x,2) - 2 * Math.pow(y,2);

TP04E5:
    return 16 - Math.pow(x,2) - 2 * Math.pow(y,2);

TPO5:

 */