package io.github.rytb2009.homework.two;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class HugeIntegerTest {

    @Test
    void testToString() {
        assertEquals("1257785687", new HugeInteger("1257785687").toString());
        assertEquals("123", new HugeInteger("000000123").toString());
        assertEquals("0", new HugeInteger("0").toString());
        assertEquals("0", new HugeInteger("-0").toString());
        String hiStr = "-2415456874894631354646546165468746131654654613167465765135465465465465";
        HugeInteger hi = new HugeInteger(hiStr);
        assertEquals(hiStr, hi.toString());
    }

    @Test
    void add() {
        HugeInteger hi = new HugeInteger("124");
        HugeInteger hi2 = new HugeInteger("79");
        assertEquals("203", hi.add(hi2).toString());

        hi = new HugeInteger("-124");
        hi2 = new HugeInteger("-79");
        assertEquals("-203", hi.add(hi2).toString());

        hi = new HugeInteger("-123");
        hi2 = new HugeInteger("78");
        assertEquals("-45", hi.add(hi2).toString());

        hi = new HugeInteger("123");
        hi2 = new HugeInteger("-78");
        assertEquals("45", hi.add(hi2).toString());

        hi = new HugeInteger("-11111111111111111111111111111111111");
        hi2 = new HugeInteger("11111111111111111111111111111111111");
        assertEquals("0", hi.add(hi2).toString());

        hi = new HugeInteger("111111111111111111111111111111111111111111111111111");
        hi2 = new HugeInteger("999999999999999999999999999999999999999999999999999");
        assertEquals("1111111111111111111111111111111111111111111111111110", hi.add(hi2).toString());

        hi = new HugeInteger("-111111111111111111111111111111111111111111111111111");
        hi2 = new HugeInteger("999999999999999999999999999999999999999999999999999");
        assertEquals("888888888888888888888888888888888888888888888888888", hi.add(hi2).toString());

        hi = new HugeInteger("-111111111111111111111111111111111111111111111111111");
        hi2 = new HugeInteger("-22255533334444442313123178739821739817398127391739218");
        assertEquals("-22366644445555553424234289850932850928509238502850329", hi.add(hi2).toString());
    }

    @Test
    void subtract() {
        HugeInteger hi = new HugeInteger("79");
        HugeInteger hi2 = new HugeInteger("124");
        assertEquals("-45", hi.subtract(hi2).toString());

        hi = new HugeInteger("124");
        hi2 = new HugeInteger("79");
        assertEquals("45", hi.subtract(hi2).toString());

        hi = new HugeInteger("-123");
        hi2 = new HugeInteger("78");
        assertEquals("-201", hi.subtract(hi2).toString());

        hi = new HugeInteger("123");
        hi2 = new HugeInteger("-78");
        assertEquals("201", hi.subtract(hi2).toString());

        hi = new HugeInteger("-11111111111111111111111111111111111");
        hi2 = new HugeInteger("-11111111111111111111111111111111111");
        assertEquals("0", hi.subtract(hi2).toString());

        hi = new HugeInteger("111111111111111111111111111111111111111111111111111");
        hi2 = new HugeInteger("2225553333444444478888");
        assertEquals("111111111111111111111111111108885557777666666632223", hi.subtract(hi2).toString());

        hi = new HugeInteger("-111111111111111111111111111111111111111111111111111");
        hi2 = new HugeInteger("22255533334444442313123178739821739817398127391739218");
        assertEquals("-22366644445555553424234289850932850928509238502850329", hi.subtract(hi2).toString());
    }

    @Test
    void isEqualTo() {
        assertTrue(new HugeInteger("2225553333444444478888").isEqualTo(new HugeInteger("2225553333444444478888")));
        assertFalse(new HugeInteger("-2225553333444444478888").isEqualTo(new HugeInteger("2225553333444444478888")));
    }

    @Test
    void isNotEqualTo() {
        assertFalse(new HugeInteger("2225553333444444478888").isNotEqualTo(new HugeInteger("2225553333444444478888")));
        assertTrue(new HugeInteger("-2225553333444444478888").isNotEqualTo(new HugeInteger("2225553333444444478888")));
    }

    @Test
    void isGreaterThan() {
        assertTrue(new HugeInteger("2225553333444444478888111").isGreaterThan(new HugeInteger("2225553333444444478888")));
        assertTrue(new HugeInteger("2225553333444444478888").isGreaterThan(new HugeInteger("-2225553333444444478888")));
        assertTrue(new HugeInteger("2225553333444444478889").isGreaterThan(new HugeInteger("2225553333444444478888")));
        assertFalse(new HugeInteger("2225553333444444478888").isGreaterThan(new HugeInteger("2225553333444444478888")));
    }

    @Test
    void isLessThan() {
        assertTrue(new HugeInteger("2225553333444444478888").isLessThan(new HugeInteger("2225553333444444478888111")));
        assertTrue(new HugeInteger("-2225553333444444478888").isLessThan(new HugeInteger("2225553333444444478888")));
        assertTrue(new HugeInteger("2225553333444444478888").isLessThan(new HugeInteger("2225553333444444478889")));
        assertFalse(new HugeInteger("2225553333444444478888").isLessThan(new HugeInteger("2225553333444444478888")));
    }

    @Test
    void isGreaterThanOrEqualTo() {
        assertTrue(new HugeInteger("2225553333444444478888111").isGreaterThanOrEqualTo(new HugeInteger("2225553333444444478888")));
        assertTrue(new HugeInteger("2225553333444444478888").isGreaterThanOrEqualTo(new HugeInteger("-2225553333444444478888")));
        assertTrue(new HugeInteger("2225553333444444478889").isGreaterThanOrEqualTo(new HugeInteger("2225553333444444478888")));
        assertTrue(new HugeInteger("2225553333444444478888").isGreaterThanOrEqualTo(new HugeInteger("2225553333444444478888")));
    }

    @Test
    void isLessThanOrEqualTo() {
        assertTrue(new HugeInteger("2225553333444444478888").isLessThanOrEqualTo(new HugeInteger("2225553333444444478888111")));
        assertTrue(new HugeInteger("-2225553333444444478888").isLessThanOrEqualTo(new HugeInteger("2225553333444444478888")));
        assertTrue(new HugeInteger("2225553333444444478888").isLessThanOrEqualTo(new HugeInteger("2225553333444444478889")));
        assertTrue(new HugeInteger("2225553333444444478888").isLessThanOrEqualTo(new HugeInteger("2225553333444444478888")));
    }
}