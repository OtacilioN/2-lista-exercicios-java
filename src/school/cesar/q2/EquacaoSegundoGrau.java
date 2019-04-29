package school.cesar.q2;

import java.util.Objects;

public class EquacaoSegundoGrau {
    private double a, b, c;

    public EquacaoSegundoGrau(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] getRaizes(){
        // Using Bhaskara (-b +- sqrt(b²-4ac)/2a)
        final int squaresNumber = 2;
        double squares[] = new double[squaresNumber];

        double delta = (b*b-4.0*a*c);

        System.out.println("Delta" + delta);
        squares[0] = (this.b * -1.0 + Math.sqrt(delta))/(2*a);
        squares[1] = (this.b * -1.0 - Math.sqrt(delta))/(2*a);
        return squares;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public boolean equals(Object target) {
        return this.a == ((EquacaoSegundoGrau)(target)).getA() && this.b == ((EquacaoSegundoGrau)(target)).getB() && this.c == ((EquacaoSegundoGrau)(target)).getC();
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        double [] squares = this.getRaizes();
        return "EquacaoSegundoGrau{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                " Raiz 1: " + squares[0] +
                " Raiz 2: " + squares[1] +
                '}';
    }

    public static void main(String[] args) {
        EquacaoSegundoGrau eq1 = new EquacaoSegundoGrau(2, 3, 1);
        EquacaoSegundoGrau eq2 = new EquacaoSegundoGrau(2, 3, 1);
        EquacaoSegundoGrau eq3 = new EquacaoSegundoGrau(1, 8, 16);

        // Verify Equals method
        System.out.println(eq1.equals(eq2));
        System.out.println(eq1.equals(eq3));

        System.out.println(eq1);
        System.out.println(eq2);
        System.out.println(eq3);


    }
}
