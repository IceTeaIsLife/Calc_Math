package dz7;

public class Main {
    public static void main(String[] args) {
        double K = 1.6, L = 1.2, h = 0.5;
        Euler euler = new Euler(K, L, h);
        //euler.run();
        Trapezoid trapezoid = new Trapezoid(K, L, h);
        //trapezoid.run();
        RoongeKootta roongeKootta = new RoongeKootta(K, L, h);
        roongeKootta.run();
    }
}
