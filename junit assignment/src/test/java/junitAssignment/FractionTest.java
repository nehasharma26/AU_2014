package junitAssignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class FractionTest {

	@Test
	public void constructorTest() {
		Fraction frac;

		frac = Fraction.getFraction(0, 1);
		assertEquals(0, frac.getNumerator());
		assertEquals(1, frac.getDenominator());

		frac = Fraction.getFraction(1, 1);
		assertEquals(1, frac.getNumerator());
		assertEquals(1, frac.getDenominator());

		frac = Fraction.getFraction(1, 2);
		assertEquals(1, frac.getNumerator());
		assertEquals(2, frac.getDenominator());

		frac = Fraction.getFraction(1, 3);
		assertEquals(1, frac.getNumerator());
		assertEquals(3, frac.getDenominator());

		frac = Fraction.getFraction(2, 3);
		assertEquals(2, frac.getNumerator());
		assertEquals(3, frac.getDenominator());

		frac = Fraction.getFraction(1, -1);
		assertEquals(-1, frac.getNumerator());
		assertEquals(1, frac.getDenominator());

		// Checking zero
		try {
			frac = Fraction.getFraction(1, 0);
			fail("Expecting divide by 0");
		} catch (ArithmeticException e) {
		}
		// Checking -ve denominator with mini numerator
		try {
			frac = Fraction.getFraction(Integer.MIN_VALUE, -1);
			fail("Expecting divide can't negate");
		} catch (ArithmeticException e) {
		}
	}

	@Test
	public void testWithWhole() {
		Fraction fraction;

		fraction = Fraction.getFraction(3, 1, 4);
		assertEquals(13, fraction.getNumerator());
		assertEquals(4, fraction.getDenominator());

		fraction = Fraction.getFraction(-3, 1, 4);
		assertEquals(-13, fraction.getNumerator());
		assertEquals(4, fraction.getDenominator());

		// test denominator 0
		try {
			fraction = Fraction.getFraction(1, 1, 0);
			fail("expecting denominator is zero");
		} catch (ArithmeticException e) {
		}
		// testing denominator <0
		try {
			fraction = Fraction.getFraction(1, 1, -1);
			fail("expecting denominator is negative");
		} catch (ArithmeticException e) {
		}

		// testing numerator 0
		try {
			fraction = Fraction.getFraction(1, -1, 3);
			fail("expecting numerator is -ve");
		} catch (ArithmeticException e) {
		}

		// testing numerator >maxi integer
		try {
			fraction = Fraction.getFraction(0, Integer.MAX_VALUE + 1, 4);
			fail("expecting maxi integer");
		} catch (ArithmeticException e) {
		}

		try {
			fraction = Fraction.getFraction(3, Integer.MAX_VALUE + 1, 4);
			fail("expecting maxi integer");
		} catch (ArithmeticException e) {
		}

	}

	@Test
	public void testReducedFraction() {
		Fraction fraction;

		fraction = Fraction.getReducedFraction(2, 4);
		assertEquals(1, fraction.getNumerator());
		assertEquals(2, fraction.getDenominator());

		// numerator 0
		fraction = Fraction.getReducedFraction(0, 2);
		assertEquals(0, fraction.getNumerator());
		assertEquals(1, fraction.getDenominator());

		// denominator <0

		fraction = Fraction.getReducedFraction(2, -2);
		assertEquals(-1, fraction.getNumerator());
		assertEquals(1, fraction.getDenominator());

		// denominator 0 test
		try {
			fraction = Fraction.getReducedFraction(1, 0);
			fail("expecting deonimator is 0");
		} catch (ArithmeticException e) {
		}
		try {
			fraction = Fraction.getReducedFraction(3, Integer.MIN_VALUE);
			fail("expecting overflow");
		} catch (ArithmeticException e) {
		}
	}

	@Test
	public void testDoubleValueFunction() {
		Fraction fraction;

		fraction = Fraction.getFraction(0.75);
		assertEquals(3, fraction.getNumerator());
		assertEquals(4, fraction.getDenominator());

		fraction = Fraction.getFraction(0.666666d);
		assertEquals(2, fraction.getNumerator());
		assertEquals(3, fraction.getDenominator());

		// denominator is 0
		try {
			fraction = Fraction.getFraction(Double.NEGATIVE_INFINITY);
			fail("expecting denominator 0");
		} catch (ArithmeticException e) {
		}

		try {
			fraction = Fraction.getFraction(Double.POSITIVE_INFINITY);
			fail("expecting denominator 0");
		} catch (ArithmeticException e) {
		}
		// not a number
		try {
			fraction = Fraction.getFraction(Double.NaN);
			fail("expecting not a number");
		} catch (ArithmeticException e) {
		}

		// >maximum integer
		try {
			fraction = Fraction.getFraction(Integer.MAX_VALUE + 1);
			fail("expecting denominator 0");
		} catch (ArithmeticException e) {
		}
	}

	@Test
	public void testForCompareTo() {
		Fraction fraction1, fraction2;

		fraction1 = Fraction.getFraction(1, 2);
		fraction2 = Fraction.getFraction(2, 4);
		assertTrue(fraction1.compareTo(fraction1) == 0);
		assertTrue(fraction1.compareTo(fraction2) == 0);

		fraction1 = Fraction.getFraction(3, 5);
		fraction2 = Fraction.getFraction(1, 5);
		assertTrue(fraction1.compareTo(fraction2) > 0);

		fraction1 = Fraction.getFraction(2, 5);
		fraction2 = Fraction.getFraction(6, 5);
		assertTrue(fraction1.compareTo(fraction2) < 0);

		fraction1 = Fraction.getFraction(1, 2);
		fraction2 = Fraction.getFraction(1, 2);
		assertTrue(fraction1.compareTo(fraction2) == 0);

		try {
			fraction1 = Fraction.getFraction(2, 4);
			fraction2 = null;
			fraction1.compareTo(fraction2);
			fail("Expecting null pointer exception");
		} catch (NullPointerException e) {

		}

	}

	@Test
	public void testPropers() {
		Fraction fraction;

		fraction = Fraction.getFraction(1, 1, 4);
		assertEquals(1, fraction.getProperWhole());
		assertEquals(1, fraction.getProperNumerator());
		assertEquals(4, fraction.getDenominator());

		fraction = Fraction.getFraction(7, 4);
		assertEquals(1, fraction.getProperWhole());
		assertEquals(3, fraction.getProperNumerator());
		assertEquals(4, fraction.getDenominator());

		fraction = Fraction.getFraction(-7, 4);
		assertEquals(-1, fraction.getProperWhole());
		assertEquals(3, fraction.getProperNumerator());
		assertEquals(4, fraction.getDenominator());

	}

	@Test
	public void testValues() {
		Fraction fraction;

		fraction = Fraction.getFraction(4, 5, 2);
		assertEquals(6.50f, fraction.floatValue(), 0.00001f);
		assertEquals(6L, fraction.longValue());
		assertEquals(6, fraction.intValue());
		assertEquals(6.5d, fraction.doubleValue(), 0.00001d);

	}

	@Test
	public void testReduce() {
		Fraction fraction, output;

		fraction = Fraction.getFraction(5, 10);
		output = fraction.reduce();
		assertEquals(1, output.getNumerator());
		assertEquals(2, output.getDenominator());

		fraction = Fraction.getFraction(0, 10);
		output = fraction.reduce();
		assertEquals(0, output.getNumerator());
		assertEquals(1, output.getDenominator());

	}

	@Test
	public void testInvert() {
		Fraction fraction, output;

		fraction = Fraction.getFraction(3, 4);
		output = fraction.invert();
		assertEquals(4, output.getNumerator());
		assertEquals(3, output.getDenominator());

		fraction = Fraction.getFraction(-1, 1);
		output = fraction.invert();
		assertEquals(-1, fraction.getNumerator());
		assertEquals(1, fraction.getDenominator());
		try {
			fraction = Fraction.getFraction(0, 1);
			output = fraction.invert();
			fail("expecting divide by 0");

		} catch (ArithmeticException e) {

		}
		fraction = Fraction.getFraction(Integer.MIN_VALUE, 1);
		try {
			output = fraction.invert();
			fail("expecting ArithmeticException");
		} catch (final ArithmeticException ex) {

		}

	}

	@Test
	public void testNegate() {
		Fraction fracation;

		fracation = Fraction.getFraction(1, 2);
		fracation = fracation.negate();
		assertEquals(-1, fracation.getNumerator());
		assertEquals(2, fracation.getDenominator());

		fracation = Fraction.getFraction(-1, 2);
		fracation = fracation.negate();
		assertEquals(1, fracation.getNumerator());
		assertEquals(2, fracation.getDenominator());

		try {
			fracation = Fraction.getFraction(Integer.MIN_VALUE, 2);
			fracation = fracation.negate();
			fail("Expecting ArithmeticException");
		} catch (ArithmeticException e) {
		}

	}

	@Test
	public void testAbs() {
		Fraction fraction;

		fraction = Fraction.getFraction(1, 2);
		fraction = fraction.abs();
		assertEquals(1, fraction.getNumerator());
		assertEquals(2, fraction.getDenominator());

		fraction = Fraction.getFraction(-1, 2);
		fraction = fraction.abs();
		assertEquals(1, fraction.getNumerator());
		assertEquals(2, fraction.getDenominator());
	}

	@Test
	public void testAdd() {
		Fraction fraction1, fracation2, output;

		fraction1 = Fraction.getFraction(3, 4);
		fracation2 = Fraction.getFraction(1, 4);
		output = fraction1.add(fracation2);
		assertEquals(1, output.getNumerator());
		assertEquals(1, output.getDenominator());

		fraction1 = Fraction.getFraction(3, 4);
		fracation2 = Fraction.getFraction(1, 3);
		output = fraction1.add(fracation2);
		assertEquals(13, output.getNumerator());
		assertEquals(12, output.getDenominator());

		fraction1 = Fraction.getFraction(0, 4);
		fracation2 = Fraction.getFraction(3, 4);
		output = fraction1.add(fracation2);
		assertEquals(3, output.getNumerator());
		assertEquals(4, output.getDenominator());

		// f2 null
		try {
			fraction1 = Fraction.getFraction(1, 2);
			fracation2 = null;
			output = fraction1.add(fracation2);
			fail("expecting IllegalArgumentException");
		} catch (IllegalArgumentException e) {

		}
		// value>Integer.Max
		try {

			fraction1 = Fraction.getFraction(Integer.MAX_VALUE, 1);
			fracation2 = Fraction.getFraction(1, 2);
			output = fraction1.add(fracation2);
			fail("expecting ArithmeticException");
		} catch (ArithmeticException e) {

		}
	}

	@Test
	public void testSubtract() {
		Fraction f1, f2, output;

		f1 = Fraction.getFraction(3, 4);
		f2 = Fraction.getFraction(1, 4);
		output = f1.subtract(f2);
		assertEquals(1, output.getNumerator());
		assertEquals(2, output.getDenominator());

		f1 = Fraction.getFraction(3, 4);
		f2 = Fraction.getFraction(1, 3);
		output = f1.subtract(f2);
		assertEquals(5, output.getNumerator());
		assertEquals(12, output.getDenominator());

		// f2 null
		try {
			f1 = Fraction.getFraction(1, 2);
			f2 = null;
			output = f1.subtract(f2);
			fail("expecting IllegalArgumentException");
		} catch (IllegalArgumentException e) {

		}

		// numerator 0
		try {
			f1 = Fraction.getFraction(1, 2);
			f2 = Fraction.getFraction(0, 0);
			output = f1.subtract(f2);
			fail("expecting ArithemticException");
		} catch (ArithmeticException e) {

		}
		// value>Integer.Max
		try {

			f1 = Fraction.getFraction(Integer.MAX_VALUE + 2, 1);
			f2 = Fraction.getFraction(1, 2);
			output = f1.subtract(f2);
			fail("expecting ArithmeticException");
		} catch (ArithmeticException e) {

		}
	}

	@Test
	public void testMultiplyBy() {
		Fraction fraction1, fraction2, output;

		fraction1 = Fraction.getFraction(2, 4);
		fraction2 = Fraction.getFraction(1, 2);
		output = fraction1.multiplyBy(fraction2);
		assertEquals(1, output.getNumerator());
		assertEquals(4, output.getDenominator());

		fraction1 = Fraction.getFraction(-2, 4);
		fraction2 = Fraction.getFraction(1, 2);
		output = fraction1.multiplyBy(fraction2);
		assertEquals(-1, output.getNumerator());
		assertEquals(4, output.getDenominator());

		// IllegalArgumentException
		try {
			fraction1 = Fraction.getFraction(1, 2);
			fraction2 = null;
			output = fraction1.multiplyBy(fraction2);
			fail("expecting IllegalArgumentException");
		} catch (IllegalArgumentException e) {

		}
		// ArithmeticException
		try {
			fraction1 = Fraction.getFraction(Integer.MAX_VALUE, 1);
			fraction2 = Fraction.getFraction(2, 1);
			output = fraction1.multiplyBy(fraction2);
			fail("expecting arithmeticException");
		} catch (ArithmeticException e) {

		}
	}

	@Test
	public void testDivideBy() {
		Fraction fraction1, fraction2, output;

		fraction1 = Fraction.getFraction(2, 4);
		fraction2 = Fraction.getFraction(2, 4);
		output = fraction1.divideBy(fraction2);
		assertEquals(1, output.getNumerator());
		assertEquals(1, output.getDenominator());

		// checking null
		try {
			fraction1 = Fraction.getFraction(2, 4);
			fraction2 = null;
			output = fraction1.divideBy(fraction2);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {

		}
		// checking divide by 0
		try {
			fraction1 = Fraction.getFraction(2, 4);
			fraction2 = Fraction.getFraction(0, 1);
			output = fraction1.divideBy(fraction2);
			fail("Divide by 0 expected");
		} catch (ArithmeticException e) {

		}
		// checking >Integer.Max
		try {
			fraction1 = Fraction.getFraction(1, Integer.MAX_VALUE);
			fraction2 = Fraction.getFraction(Integer.MAX_VALUE, 1);
			output = fraction1.divideBy(fraction2); // should overflow
			fail("expecting ArithmeticException");
		} catch (ArithmeticException ex) {
		}
	}

	@Test
	public void testPow() {
		Fraction fraction, output;

		fraction = Fraction.getFraction(2, 4);
		output = fraction.pow(2);
		assertEquals(1, output.getNumerator());
		assertEquals(4, output.getDenominator());

		fraction = Fraction.getFraction(-1, 2);
		output = fraction.pow(2);
		assertEquals(1, output.getNumerator());
		assertEquals(4, output.getDenominator());

		fraction = Fraction.getFraction(2, 4);
		output = fraction.pow(0);
		assertEquals(1, output.getNumerator());
		assertEquals(1, output.getDenominator());

		fraction = Fraction.getFraction(2, 4);
		output = fraction.pow(-1);
		assertEquals(4, output.getNumerator());
		assertEquals(2, output.getDenominator());

		fraction = Fraction.getFraction(2, 3);
		output = fraction.pow(3);
		assertEquals(8, output.getNumerator());
		assertEquals(27, output.getDenominator());
	}

	@Test
	public void testEquals() {
		Fraction fraction1, fraction2;

		fraction1 = Fraction.getFraction(1, 2);
		fraction2 = Fraction.getFraction(-1, -2);
		assertEquals(true, fraction1.equals(fraction2));

		fraction1 = Fraction.getFraction(1, 2);
		fraction2 = Fraction.getFraction(1, 2);
		assertEquals(true, fraction1.equals(fraction2));
	}

	@Test
	public void testHashCode() {
		Fraction fraction1, fraction2;

		fraction1 = Fraction.getFraction(3, 4);
		fraction2 = Fraction.getFraction(3, 4);
		assertTrue(fraction1.hashCode() == fraction2.hashCode());

		fraction1 = Fraction.getFraction(1, 4);
		fraction2 = Fraction.getFraction(3, 4);
		assertTrue(fraction1.hashCode() != fraction2.hashCode());
	}

	@Test
	public void testtoString() {
		Fraction f;

		f = Fraction.getFraction(1, 4);
		assertEquals("1/4", f.toString());
	}

	@Test
	public void testtoProperString() {
		Fraction f;

		f = Fraction.getFraction(2, 1, 5);
		assertEquals("2 1/5", f.toProperString());

		f = Fraction.getFraction(-2, 1, 5);
		assertEquals("-2 1/5", f.toProperString());

		f = Fraction.getFraction(-2, 0, 5);
		assertEquals("-2", f.toProperString());

		f = Fraction.getFraction(3, 3);
		assertEquals("1", f.toProperString());

	}

	@Test
	public void testConstants() {
		assertEquals(0, Fraction.ZERO.getNumerator());
		assertEquals(1, Fraction.ZERO.getDenominator());
		assertEquals(1, Fraction.ONE.getNumerator());
		assertEquals(1, Fraction.ONE.getDenominator());
		assertEquals(1, Fraction.ONE_HALF.getNumerator());
		assertEquals(2, Fraction.ONE_HALF.getDenominator());
		assertEquals(1, Fraction.ONE_THIRD.getNumerator());
		assertEquals(3, Fraction.ONE_THIRD.getDenominator());
		assertEquals(2, Fraction.TWO_THIRDS.getNumerator());
		assertEquals(3, Fraction.TWO_THIRDS.getDenominator());
		assertEquals(1, Fraction.ONE_QUARTER.getNumerator());
		assertEquals(4, Fraction.ONE_QUARTER.getDenominator());
		assertEquals(2, Fraction.TWO_QUARTERS.getNumerator());
		assertEquals(4, Fraction.TWO_QUARTERS.getDenominator());
		assertEquals(3, Fraction.THREE_QUARTERS.getNumerator());
		assertEquals(4, Fraction.THREE_QUARTERS.getDenominator());
		assertEquals(1, Fraction.ONE_FIFTH.getNumerator());
		assertEquals(5, Fraction.ONE_FIFTH.getDenominator());
		assertEquals(2, Fraction.TWO_FIFTHS.getNumerator());
		assertEquals(5, Fraction.TWO_FIFTHS.getDenominator());
		assertEquals(3, Fraction.THREE_FIFTHS.getNumerator());
		assertEquals(5, Fraction.THREE_FIFTHS.getDenominator());
		assertEquals(4, Fraction.FOUR_FIFTHS.getNumerator());
		assertEquals(5, Fraction.FOUR_FIFTHS.getDenominator());
	}

}