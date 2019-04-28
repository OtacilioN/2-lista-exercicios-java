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

        double delta =  Math.sqrt(b*2.0-4.0*a*c)/2.0*a;

        squares[0] = this.b * -1.0 + delta;
        squares[1] = this.b * -1.0 - delta;
        return squares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquacaoSegundoGrau that = (EquacaoSegundoGrau) o;
        return Double.compare(that.a, a) == 0 &&
                Double.compare(that.b, b) == 0 &&
                Double.compare(that.c, c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
