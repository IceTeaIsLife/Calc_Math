package eltex_3;

import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Setter
@ToString
public class SquareEquation {
    private float x, a, b, c;
    BigDecimal R0;
    BigDecimal R00;
    BigDecimal L;
    BigDecimal C;

    public SquareEquation() {
    }

    public void setDefault() {
        R0 = BigDecimal.valueOf(3);
        R00 = BigDecimal.valueOf(6);
        L = BigDecimal.valueOf(2).multiply(new BigDecimal("0.001"));
        C = BigDecimal.valueOf(1670).multiply(new BigDecimal("0.000001"));
    }

    public void setCheck() {
        R0 = BigDecimal.valueOf(10);
        R00 = BigDecimal.valueOf(30);
        L = BigDecimal.valueOf(1).multiply(new BigDecimal("0.001"));
        C = BigDecimal.valueOf(50).multiply(new BigDecimal("0.000001"));
    }

    public void setLab() {
        R0 = BigDecimal.valueOf(490);
        R00 = BigDecimal.valueOf(201);
        L = BigDecimal.valueOf(224).multiply(new BigDecimal("0.00001"));
        C = BigDecimal.valueOf(27).multiply(new BigDecimal("0.000000001"));
    }

    public void resolve() {
        //BigDecimal a = R00.multiply(L).multiply(C);
        //BigDecimal b = R00.multiply(R0).multiply(C).add(L);
        //BigDecimal c = R00.add(R0);
        //BigDecimal a = L.multiply(C);
        //BigDecimal b = R0.multiply(C);
        //BigDecimal c = R00;
        //System.out.println(L * C);
        BigDecimal a = L.multiply(C);
        BigDecimal b = R00.add(R0);
        b = b.multiply(C);
        BigDecimal c = BigDecimal.valueOf(1);
        BigDecimal D = b.multiply(b);
        System.out.println(D);
        D = D.subtract(a.multiply(c).multiply(BigDecimal.valueOf(4)));
        //System.out.println(a.multiply(c).multiply(BigDecimal.valueOf(4)));
        System.out.println(D);
        BigDecimal x1 = b.multiply(BigDecimal.valueOf(-1))
                .add(bigSqrt(D))
                ;
        x1 = x1.divide(a.multiply(BigDecimal.valueOf(2)), RoundingMode.HALF_UP);
        System.out.println("x1 = " + x1);

        BigDecimal x2 = b.multiply(BigDecimal.valueOf(-1))
                .subtract(bigSqrt(D))
                ;
        x2 = x2.divide(a.multiply(BigDecimal.valueOf(2)), RoundingMode.HALF_UP);
        System.out.println("x2 = " + x2);
    }


    private static final BigDecimal SQRT_DIG = new BigDecimal(10);
    private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());

    /**
     * Private utility method used to compute the square root of a BigDecimal.
     *
     * @author Luciano Culacciatti
     * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
     */
    private static BigDecimal sqrtNewtonRaphson  (BigDecimal c, BigDecimal xn, BigDecimal precision){
        BigDecimal fx = xn.pow(2).add(c.negate());
        BigDecimal fpx = xn.multiply(new BigDecimal(2));
        BigDecimal xn1 = fx.divide(fpx,2*SQRT_DIG.intValue(), RoundingMode.HALF_DOWN);
        xn1 = xn.add(xn1.negate());
        BigDecimal currentSquare = xn1.pow(2);
        BigDecimal currentPrecision = currentSquare.subtract(c);
        currentPrecision = currentPrecision.abs();
        if (currentPrecision.compareTo(precision) <= -1){
            return xn1;
        }
        return sqrtNewtonRaphson(c, xn1, precision);
    }

    /**
     * Uses Newton Raphson to compute the square root of a BigDecimal.
     *
     * @author Luciano Culacciatti
     * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
     */
    public static BigDecimal bigSqrt(BigDecimal c){
        return sqrtNewtonRaphson(c,new BigDecimal(1),new BigDecimal(1).divide(SQRT_PRE));
    }
}
