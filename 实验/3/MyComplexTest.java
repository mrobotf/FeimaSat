import java.util.Objects;

class Mycomplex {
    private double real;
    private double imaginary;
    public Mycomplex() {
        this.real = 0;
        this.imaginary = 0;
    }
    public Mycomplex(double n1, double n2) {
        this.real = n1;
        this.imaginary = n2;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public static Mycomplex add(Mycomplex m1, Mycomplex m2) {
        Mycomplex mycomplex = new Mycomplex();
        mycomplex.real = m1.getReal() + m2.getReal();
        mycomplex.imaginary = m1.getImaginary() + m2.getImaginary();
        return mycomplex;
    }

    public static Mycomplex sub(Mycomplex m1, Mycomplex m2) {
        Mycomplex mycomplex = new Mycomplex();
        mycomplex.real = m1.getReal() - m2.getReal();
        mycomplex.imaginary = m1.getImaginary() - m2.getImaginary();
        return mycomplex;
    }

    public static Mycomplex mul(Mycomplex m1, Mycomplex m2) {
        Mycomplex mycomplex = new Mycomplex();
        mycomplex.real = m1.getReal() * m2.getReal() - m1.getImaginary() * m1.getImaginary();
        mycomplex.imaginary = m1.getReal() * m2.getImaginary() + m1.getImaginary() * m2.getReal();
        return mycomplex;
    }

    public static Mycomplex div(Mycomplex m1, Mycomplex m2) {
        Mycomplex mycomplex = new Mycomplex();
        double a = m1.getReal();    double b = m1.getImaginary();
        double c = m2.getReal();    double d = m2.getImaginary();
        mycomplex.real = (a*c + b*d)/(c*c + d*d);
        mycomplex.imaginary = (b*c - a*d)/(c*c + d*d);
        return mycomplex;
    }

    @Override
    public String toString() {
        if(imaginary  >= 0)
            return real + "+" + imaginary + 'i';
        else
            return real + "" + imaginary + "i";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mycomplex mycomplex = (Mycomplex) o;
        return Double.compare(mycomplex.real, real) == 0 && Double.compare(mycomplex.imaginary, imaginary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }


}
class MyComplexTest {
    public static void main(String[] args) {
        Mycomplex m1 = new Mycomplex(3.4, 8.0);
        Mycomplex m2 = new Mycomplex(3.4, 8.0);
        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);
        System.out.println("m1 == m2 = " + (m1 == m2));
        System.out.println("m1.equals(m2) = " + m1.equals(m2));
        Mycomplex m3 = new Mycomplex(4.4, -8.9);
        System.out.println("m3 = " + m3);
        Mycomplex m4 = Mycomplex.add(m1, m3);
        Mycomplex m5 = Mycomplex.sub(m2, m3);
        Mycomplex m6 = Mycomplex.mul(m1, m2);
        Mycomplex m7 = Mycomplex.div(m1, m2);
        System.out.println("m1 + m3 = " + m4);
        System.out.println("m2 - m3 = " + m5);
        System.out.println("m1 * m2 = " + m6);
        System.out.println("m1/m2 = " + m7);

    }
}