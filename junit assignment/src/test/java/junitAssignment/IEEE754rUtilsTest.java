package junitAssignment;


import org.junit.Test;

import static org.junit.Assert.*;

public class IEEE754rUtilsTest {

	@Test
	public void testForConstructor() {
		IEEE754rUtils a = new IEEE754rUtils();
	}

	@Test
	public void testFloatArray() {
		float floatArray[] = { 1.4f, 3.6f, 4.2f };
		assertTrue(1.4f == IEEE754rUtils.min(floatArray));
		try {
			IEEE754rUtils.min((float[]) null);
			fail("The Array must not be null");
		} catch (Exception e) {

		}
		try {
			float Float_arr2[] = new float[0];
			IEEE754rUtils.min(Float_arr2);
			fail("Array cannot be empty.");
		} catch (Exception e) {

		}
	}

	@Test
	public void testMinDoubleArray() {
		double[] doubleArray = { 2.3, 6.6, 8.9, 4.4 };
		double result;
		result = IEEE754rUtils.min(doubleArray);
		assertEquals(result, 2.3, 0.1);
		try {

			IEEE754rUtils.min((double[]) null);
			fail("Expecting IllegalArgumentException");
		} catch (IllegalArgumentException e) {

		}

		try {
			double doubleArray2[] = new double[0];
			IEEE754rUtils.min(doubleArray2);
			fail("Expecting IllegalArgumentException");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void testMinDouble() {
		double double1 = 10.7, double2 = -0.5, double3 = 1.0;

		assertTrue(IEEE754rUtils.min(double1, double2, double3) == -0.5);
		assertEquals(IEEE754rUtils.min(Double.NaN, Double.NaN, Double.NaN),
				Double.NaN, 0.1);

		double1 = -10.5;
		double2 = 1.68;

		assertTrue(IEEE754rUtils.min(double1, double2) == -10.5);
		assertEquals(IEEE754rUtils.min(Double.NaN, Double.NaN), Double.NaN, 0.1);
		assertEquals(IEEE754rUtils.min(double2, Double.NaN), double2, 0.1);

	}

	@Test
	public void testMaxFloatArray() {
		float floatArray[] = { 2.4f, 3.6f, 8.8f };
		assertTrue(8.8f == IEEE754rUtils.max(floatArray));

		try {
			IEEE754rUtils.max((float[]) null);
			fail("The Array must not be null");
		} catch (Exception e) {

		}

		try {
			float floatArray2[] = new float[0];

			IEEE754rUtils.max(floatArray2);
			fail("Array must not be empty.");

		} catch (Exception e) {

		}
	}

	@Test
	public void testMaxDouble() {
		double double1, double2, double3;
		double1 = 7.7;
		double2 = -3.5;
		double3 = 2.7;

		assertTrue(IEEE754rUtils.max(double1, double2, double3) == 7.7);
		assertEquals(IEEE754rUtils.max(Double.NaN, Double.NaN, Double.NaN),
				Double.NaN, 0.1);

		double1 = -0.5;
		double2 = 18.5;

		assertTrue(IEEE754rUtils.max(double1, double2) == 18.5);

		assertEquals(IEEE754rUtils.max(Double.NaN, Double.NaN), Double.NaN, 0.1);
		assertEquals(IEEE754rUtils.max(Double.NaN, double2), double2, 0.1);
		assertEquals(IEEE754rUtils.max(7.7, Double.NaN), 7.7, 0.1);
	}

	@Test
	public void testForMinFloat() {
		float f1 = 7.8f, f2 = -8.9f, f3 = 5.6f;

		assertTrue(IEEE754rUtils.min(f1, f2, f3) == -8.9f);
		assertEquals(IEEE754rUtils.min(Float.NaN, Float.NaN, Float.NaN),
				Float.NaN, 0.01f);

		f1 = -7.8f;
		f2 = 3.9f;
		assertTrue(IEEE754rUtils.min(f1, f2) == -7.8f);
		assertEquals(IEEE754rUtils.min(Float.NaN, Float.NaN), Float.NaN, 0.01f);
		assertEquals(IEEE754rUtils.min(1.2f, Float.NaN), 1.2f, 0.01f);

	}

	@Test
	public void testForMaxFloat() {
		float f1, f2, f3;
		f1 = 0.1f;
		f2 = -13.5f;
		f3 = 6.0f;

		assertTrue(IEEE754rUtils.max(f1, f2, f3) == 6.0f);

		assertEquals(IEEE754rUtils.max(Float.NaN, Float.NaN, Float.NaN),
				Float.NaN, 0.01f);

		f1 = 1.0f;
		f2 = 5.6f;
		assertTrue(IEEE754rUtils.max(f1, f2) == 5.6f);
		assertEquals(IEEE754rUtils.max(Float.NaN, Float.NaN), Float.NaN, 0.01f);
		assertEquals(IEEE754rUtils.max(1.1f, Float.NaN), 1.1f, 0.01f);
	}
}