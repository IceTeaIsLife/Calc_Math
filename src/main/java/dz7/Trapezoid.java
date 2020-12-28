package dz7;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trapezoid {
    private double K = 1.6;
    private double L = 1.2;
    private double h = 0.5;

    public double fXY(double x, double y) {
        return Math.pow(x, 2) + ((K - 1) / 2) * y;
    }

    public void run() {
        double a = 0, b = 2, x0 = a, y0 = L;
        while (x0 != 2) {
            double y = y0 + (h / 2) * (fXY(x0,y0) + fXY(x0+h, y0 + h * fXY(x0,y0)));
            // System.out.println(fXY(x0,y0));
            System.out.println(y);
            x0 += h;
            y0 = y;
        }
    }
}
