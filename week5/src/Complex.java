public class Complex implements Cloneable, Comparable<Complex> {
    private double a;
    private double b;

    /** no-arg constructor: Complex object that represents 0 */
    public Complex() {
        a = 0;
        b = 0;
    }

    /** Single argument constructor: returns a+0i */
    public Complex(double a) {
        this.a = a;
        b = 0;
    }

    /** Constructor */
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /** Getters */
    public double getReal() {
        return a;
    }

    public double getImaginary() {
        return b;
    }

    /** Add method */
    public Complex add(Complex c2) {
        double real = this.getReal() + c2.getReal();
        double imaginary = this.getImaginary() + c2.getImaginary();
        return new Complex(real, imaginary);
    }

    /** Subtract method */
    public Complex subtract(Complex c2) {
        double real = this.getReal() - c2.getReal();
        double imaginary = this.getImaginary() - c2.getImaginary();
        return new Complex(real, imaginary);
    }

    /** Multiply method */
    public Complex multiply(Complex c2) {
        double real = this.getReal() * c2.getReal() - this.getImaginary() * c2.getImaginary();
        double imaginary = this.getImaginary() * c2.getReal() + this.getReal() * c2.getImaginary();
        return new Complex(real, imaginary);
    }

    /** Divide method */
    public Complex divide(Complex c2) {
        double a = this.getReal();
        double b = this.getImaginary();
        double c = c2.getReal();
        double d = c2.getImaginary();
        double real = (a * c + b * d) / c * c + d * d;
        double imaginary = (b * c - a * d) / c * c + d * d;
        return new Complex(a, b);
    }
    /** Abslolute value method */
    /** Cloneable */
    /** Comparable */
}
