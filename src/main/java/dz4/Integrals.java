package dz4;

import java.util.Scanner;

public class Integrals {
	private double k, l, a, b;

	public void typeKL() {
		Scanner in = new Scanner(System.in);
		k = Double.parseDouble(in.next());
		l = Double.parseDouble(in.next());
	}

	Integrals() {
		typeKL();
		a = (k - l) / 2;
		b = k + l;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

	public int typeN() {
		Scanner in = new Scanner(System.in);
		return Integer.parseInt(in.next());
	}

	public double correctIntegralFunction(double x) {
		double I = (0.5) * Math.log(Math.pow(x, 2) + x + k)
				+ ((l - 0.5) / Math.sqrt(k - 0.25))
				* Math.atan((x + 0.5) / Math.sqrt(k - 0.25));
		return I;
	}

	public double correctIntegral() {
		double I = correctIntegralFunction(b) - correctIntegralFunction(a);
		return I;
	}

	public double func(double x) {
		double f = (x + l) / (Math.pow(x, 2) + x + k);
		return f;
	}

	public double fSUM(double[] f) {
		double sum = 0;
		for (int i = 1; i < f.length; i++) {
			sum += f[i];
		}
		return sum;
	}

	public double fSUMparabol(double[] f) {
		double sum = 0;
		for (int i = 1; i < f.length; i++) {
			if (i % 2 != 0) {
				sum += f[i] * 4;
			} else {
				sum += f[i] * 2;
			}
		}
		return sum;
	}

	public void trapezoid(int n) {
		double h = (b - a) / n;
		System.out.println("h = " + h);
		double[] x = new double[n];
		double[] f = new double[n];
		double fA = this.func(a);
		double fB = this.func(b);
		System.out.println("a = " + a);
		System.out.println("fA = " + fA);
		System.out.println("b = " + b);
		System.out.println("fB = " + fB);
		for (int i = 1; i <= n - 1; i++) {
			x[i] = a + i * h;
			f[i] = this.func(x[i]);
			System.out.println("x" + i + " = " + x[i]);
			System.out.println("\u001B[31m" + "f" + i + " = " + f[i] + "\u001B[0m");
		}

		double I = (((fA + fB) / 2) + fSUM(f)) * h;
		System.out.println("Itr = " + I);
	}

	public void paraboloid(int n) {
		double h = (b - a) / (2 * n);
		System.out.println("h = " + h);
		double[] x = new double[2 * n];
		double[] f = new double[2 * n];
		double fA = this.func(a);
		double fB = this.func(b);
		System.out.println("a = " + a);
		System.out.println("fA = " + fA);
		System.out.println("b = " + b);
		System.out.println("fB = " + fB);
		for (int i = 1; i <= 2 * n - 1; i++) {
			x[i] = a + i * h;
			f[i] = this.func(x[i]);
			System.out.println("x" + i + " = " + x[i]);
			System.out.println("\u001B[31m" + "f" + i + " = " + f[i] + "\u001B[0m");
		}

		double I = (fA + fB + fSUMparabol(f)) * h * (1.0 / 3.0);
		System.out.println("Ipar = " + I);
	}

	public double fti(double t) {
		return func(((a + b) / 2) + ((b - a) / 2) * t);
	}

	public double funcGauss(int n) {
		double sum = 0;
		if (n == 4) {
			sum = 0.347854 * (fti(-0.861136) + fti(0.861136)) + 0.652145 * (fti(-0.339981) + fti(0.339981));
			System.out.println("i = 1: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + -0.861136 + ") = " + fti(-0.861136));
			System.out.println("i = 2: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + -0.339981 + ") = " + fti(-0.339981));
			System.out.println("i = 3: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + 0.339981 + ") = " + fti(0.339981));
			System.out.println("i = 4: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + 0.861136 + ") = " + fti(0.861136));
		}

		if (n == 6) {
			sum = 0.171324 * (fti(-0.932464) + fti(0.932464))
					+ 0.360761 * (fti(-0.661209) + fti(0.661209))
					+ 0.467913 * (fti(-0.238619) + fti(0.238619));
			System.out.println("i = 1: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + -0.932464 + ") = " + fti(-0.932464));
			System.out.println("i = 2: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + -0.661209 + ") = " + fti(-0.661209));
			System.out.println("i = 3: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + -0.238619 + ") = " + fti(-0.238619));
			System.out.println("i = 4: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + 0.238619 + ") = " + fti(0.238619));
			System.out.println("i = 5: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + 0.661209 + ") = " + fti(0.661209));
			System.out.println("i = 6: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + 0.932464 + ") = " + fti(0.932464));
		}

		if (n == 8) {
			sum = 0.101228 * (fti(-0.960289) + fti(0.960289))
					+ 0.222381 * (fti(-0.796666) + fti(0.796666))
					+ 0.313706 * (fti(-0.525532) + fti(0.525532))
					+ 0.362683 * (fti(-0.183434) + fti(0.183434));
			System.out.println("i = 1: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + -0.960289 + ") = " + fti(-0.960289));
			System.out.println("i = 2: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + -0.796666 + ") = " + fti(-0.796666));
			System.out.println("i = 3: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + -0.525532 + ") = " + fti(-0.525532));
			System.out.println("i = 4: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + -0.183434 + ") = " + fti(-0.183434));
			System.out.println("i = 5: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + 0.183434 + ") = " + fti(0.183434));
			System.out.println("i = 6: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + 0.525532 + ") = " + fti(0.525532));
			System.out.println("i = 7: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + 0.796666 + ") = " + fti(0.796666));
			System.out.println("i = 8: f(" + ((a + b) / 2) + " + " + ((b - a) / 2) + " (" + 0.960289 + ") = " + fti(0.960289));
		}

		return sum;
	}

	public void methodGauss(int n) {

		double I = funcGauss(n) * (b - a) / 2;
		System.out.println("Ig = " + I);
	}
}
