package dz7;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class RoongeKootta { //ooga booga
    private double K = 1.6;
    private double L = 1.2;
    private double h = 0.5;
    //private List<Double> listOfKs = new ArrayList<>();

    public double fXY(double x, double y) {
        return Math.pow(x, 2) + ((K - 1) / 2) * y;
    }

    public void run() {
        double a = 0, b = 2, x0 = a, y0 = L;
        int count = 1;
        while (x0 != 2) {
            double K1 = fXY(x0, y0);
            double K2 = fXY(x0 + (h / 2), y0 + (h * K1)/2);
            double K3 = fXY(x0 + (h / 2), y0 + (h * K2)/2);
            double K4 = fXY(x0 + h, y0 + h * K3);
            System.out.println("K1 = " + K1
                    + "\nK2 = " + K2
                    + "\nK3 = " + K3
                    + "\nK4 = " + K4);
            double y = y0 + (h / 6) * (K1 + 2 * K2 + 2*K3 + K4);
            // System.out.println(fXY(x0,y0));
            System.out.println("y" + count++ + " = " + y + "\n");
            x0 += h;
            y0 = y;
        }
    }
}
