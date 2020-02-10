package io.github.rytb2009.homework.two;

public class Rational {
    private long numerator;
    private long denominator;

    public Rational(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        toReducedForm();
    }

    public Rational add(Rational r) {
        long numerator = this.numerator * r.denominator + this.denominator * r.numerator;
        long denominator = this.denominator * r.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational minus(Rational r) {
        long numerator = this.numerator * r.denominator - this.denominator * r.numerator;
        long denominator = this.denominator * r.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational multiply(Rational r) {
        long numerator = this.numerator * r.numerator;
        long denominator = this.denominator * r.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational divide(Rational r) {
        long numerator = this.numerator * r.denominator;
        long denominator = this.denominator * r.numerator;
        return new Rational(numerator, denominator);
    }

    private void toReducedForm() {
        long gcd = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    }

    private long gcd(long x, long y) {
        if (x == 0) {
            return y;
        }
        long min = Math.min(x, y);
        long max = Math.max(x, y);
        return gcd(max % min, min);
    }

    long getNumerator() {
        return numerator;
    }

    long getDenominator() {
        return denominator;
    }
}
