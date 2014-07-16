package junitAssignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumberUtilsTest {
	private NumberUtils numberUtils;

	@Test
	public void testConstants() {
		assertEquals(0L, numberUtils.LONG_ZERO.longValue());
	}

	@Test
	public void testToInt() {
		assertEquals(12, numberUtils.toInt("12"));
		assertEquals(0, NumberUtils.toInt(null));
	}

	@Test
	public void testToIntDef() {
		assertEquals(12, numberUtils.toInt(null, 12));
	}

	@Test
	public void testToLong() {
		assertEquals(12L, NumberUtils.toLong("12"));
	}

	/*
	 * @Test public void testToLongNull() { assertEquals(12,
	 * NumberUtils.toLong(null, 12)); assertEquals(12,
	 * NumberUtils.toLong("12.4", 12)); }
	 */

	@Test
	public void testToFloat() {
		assertTrue(NumberUtils.toFloat("-1.2") == -1.2f);

	}

	@Test
	public void testToFloatNull() {
		assertTrue(NumberUtils.toFloat(null, 1.2f) == 1.2f);
	}

	@Test
	public void testToDouble() {
		assertTrue(NumberUtils.toDouble("1.4") == 1.4d);
		assertTrue(NumberUtils.toDouble("-1.4") == -1.4d);

	}

	@Test
	public void testToDoubleNull() {
		assertTrue(NumberUtils.toDouble(null, 1.2) == 1.2d);
		assertTrue(NumberUtils.toDouble(null, -1.2) == -1.2d);
	}

	@Test
	public void testToByte() {
		assertTrue(NumberUtils.toByte("123") == 123);

	}
	
	@Test(expected = NumberFormatException.class)
	public void testCreateNumException() {
		assertEquals("", NumberUtils.createNumber(""));
		assertEquals(Integer.valueOf("12345"),
				NumberUtils.createNumber("12345"));
		assertEquals(Double.valueOf("1.1E200"),
				NumberUtils.createNumber("1.1E200"));
	}

	@Test
	public void testCreateNumFor0x() {
		assertEquals(43709, NumberUtils.createNumber("0xAABD"));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinLongArray() {
		NumberUtils.min((long[]) null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinLongEmpty() {
		NumberUtils.min(new long[0]);
	}

}