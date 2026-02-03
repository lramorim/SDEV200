/*Program name: Rational.java
* Author: Laura Amorim
* Date last updated: 02/02/2026
* Purpose: to redesign and implement the Rational class using BigInteger for the numerator and denominator
*/
import java.math.BigInteger;
import java.util.Scanner;


public class Rational extends Number implements Comparable<Rational>
{

    private BigInteger numerator;
    private BigInteger denominator;
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter rational r1 with numerator and denominator separated by a space: ");
        BigInteger n1 = input.nextBigInteger();
        BigInteger d1 = input.nextBigInteger();
        Rational r1 = new Rational(n1, d1);

        System.out.print("Enter rational r2 with numerator and denominator separated by a space: ");
        BigInteger n2 = input.nextBigInteger();
        BigInteger d2 = input.nextBigInteger();
        Rational r2 = new Rational(n2, d2);

        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        
        input.close();
    }

    public Rational() 
    {
        this(BigInteger.ZERO, BigInteger.ONE); //pre made constants for construct
    }

    public Rational(long n, long d) 
    {
        this(BigInteger.valueOf(n), BigInteger.valueOf(d));
    }

    public Rational(BigInteger n, BigInteger d) 
    {
        BigInteger gcd = n.gcd(d);
        numerator = n.divide(gcd);
        denominator = d.divide(gcd);

        if (denominator.signum() < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }
    }

    public BigInteger getNumerator() //accessors
    {
        return numerator;
    }

    public BigInteger getDenominator() 
    {
        return denominator;
    }

    public Rational add(Rational r) 
    {
        BigInteger n = numerator.multiply(r.denominator)
                .add(denominator.multiply(r.numerator));
        BigInteger d = denominator.multiply(r.denominator);
        return new Rational(n, d);
    }

    public Rational subtract(Rational r) 
    {
        BigInteger n = numerator.multiply(r.denominator)
                .subtract(denominator.multiply(r.numerator));
        BigInteger d = denominator.multiply(r.denominator);
        return new Rational(n, d);
    }

    public Rational multiply(Rational r) 
    {
        return new Rational(
                numerator.multiply(r.numerator),
                denominator.multiply(r.denominator)
        );
    }

    public Rational divide(Rational r) 
    {
        return new Rational(
                numerator.multiply(r.denominator),
                denominator.multiply(r.numerator)
        );
    }

    @Override
    public String toString() 
    {
        if (denominator.equals(BigInteger.ONE))
            return numerator.toString();
        return numerator + "/" + denominator;
    }

    @Override
    public int compareTo(Rational r) 
    {
        return numerator.multiply(r.denominator)
                .compareTo(denominator.multiply(r.numerator));
    }

    @Override
    public double doubleValue() 
    {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public int intValue() 
    {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }
}