package io.github.rytb2009.homework.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RationalTest {

    @Test
    void add() {
        Rational r = new Rational(5, 10);
        Rational r2 = new Rational(5, 10);
        Rational result = r.add(r2);
        assertEquals(1, result.getNumerator());
        assertEquals(1, result.getDenominator());

        r = new Rational(3, 2);
        r2 = new Rational(4, 7);
        result = r.add(r2);
        assertEquals(29,result.getNumerator());
        assertEquals(14, result.getDenominator());

        r = new Rational(4, 6);
        r2 = new Rational(6, 12);
        result = r.add(r2);
        assertEquals(7,result.getNumerator());
        assertEquals(6, result.getDenominator());
    }

    @Test
    void minus() {
        Rational r = new Rational(5, 10);
        Rational r2 = new Rational(5, 10);
        Rational result = r.minus(r2);
        assertEquals(0, result.getNumerator());
        assertEquals(1, result.getDenominator());

        r = new Rational(3, 2);
        r2 = new Rational(4, 7);
        result = r.minus(r2);
        assertEquals(13,result.getNumerator());
        assertEquals(14, result.getDenominator());

        r = new Rational(4, 6);
        r2 = new Rational(4, 12);
        result =  r.minus(r2);
        assertEquals(1,result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    void multiply() {
        Rational r = new Rational(5, 10);
        Rational r2 = new Rational(5, 10);
        Rational result = r.multiply(r2);
        assertEquals(1,result.getNumerator());
        assertEquals(4, result.getDenominator());

        r = new Rational(3, 2);
        r2 = new Rational(4, 7);
        result = r.multiply(r2);
        assertEquals(6, result.getNumerator());
        assertEquals(7, result.getDenominator());

        r = new Rational(4, 6);
        r2 = new Rational(4, 12);
        result = r.multiply(r2);
        assertEquals(2,result.getNumerator());
        assertEquals(9, result.getDenominator());
    }

    @Test
    void divide() {
        Rational r = new Rational(5, 10);
        Rational r2 = new Rational(5, 10);
        Rational result =  r.divide(r2);
        assertEquals(1,result.getNumerator());
        assertEquals(1, result.getDenominator());

        r = new Rational(3, 2);
        r2 = new Rational(4, 7);
        result =  r.divide(r2);
        assertEquals(21,result.getNumerator());
        assertEquals(8, result.getDenominator());

        r = new Rational(4, 6);
        r2 = new Rational(4, 12);
        result =  r.divide(r2);
        assertEquals(2,result.getNumerator());
        assertEquals(1, result.getDenominator());
    }
}