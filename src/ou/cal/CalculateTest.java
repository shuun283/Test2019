package ou.cal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculateTest {

	@Test
	public void test1() throws Exception {
		String actual = Calculate.parse("2 + 4 - 3");
		String expected = "3.0";
		assertEquals(expected, actual);
	}

	@Test
	public void test2() throws Exception {
		String actual = Calculate.parse(" 2 - ( -1 ) - 3");
		String expected = "0.0";
		assertEquals(expected, actual);
	}

	@Test
	public void test3() throws Exception {
		String actual = Calculate.parse(" 2 + 3 * (15 - 10 )");
		String expected = "17.0";
		assertEquals(expected, actual);
	}

	@Test
	public void test4() throws Exception {
		String actual = Calculate.parse(" 2 + 10 / (15 - 10 )");
		String expected = "4.0";
		assertEquals(expected, actual);
	}

	@Test
	public void test5() throws Exception {
		String actual = Calculate.parse("( 2 + 10 ) / (15 - 10 )");
		String expected = "2.4";
		assertEquals(expected, actual);
	}
}
