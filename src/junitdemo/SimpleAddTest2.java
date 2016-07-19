package junitdemo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleAddTest2 {

	
	
	SimpleAdd a;

	/*
	 * the method will run once when a @Test method run
	 */
	@Before
	public void setUp() {
		a = new SimpleAdd();
		// note how many times the method runs
		System.out.println("Set up");
	}

	/*
	 * the method will run once when the class loaded
	 */
	@BeforeClass
	public static void setUpClass() {
		// note how many times the method runs
		System.out.println("Set up class");
	}

	@Test
	public void testAdd() {
		assertEquals(12, a.add(5, 7));
	}

	/*
	 * timeout to set the max time to test a method
	 */
	@Test(timeout = 10)
	public void testAdd2() {
		assertEquals(12, a.add2(5, 7));
	}

	/*
	 * 1. You can use ignore to ignore the test 2. assertEquals(expected,
	 * actual, delta)
	 */
	@Test
	// @Ignore
	public void testAdd3() {
		assertEquals(12, a.add3(5.5, 7.0));
		assertEquals(12, a.add3(5.5, 7.6));
		assertEquals(12, a.add3(5.1, 7.1));

		// the last parameter means the acceptable difference between expected
		// and actual value
		assertEquals(12.1, a.add3(5.1, 7.1), 0.5);

		// when the difference is too large, assert will fail
		// assertEquals(12.6, a.add3(5.1, 7.1), 0.5);
	}

	/*
	 * Using assertArrayEquals
	 */
//	@Test
//	@Ignore	
//	public void testArrayAdd() {
//		try {
//			assertArrayEquals(new int[] { 2, 2, 2 },
//					a.add4(new int[] { 1, 1, 1 }, new int[] { 1, 1, 2 }));
//			assertArrayEquals(new int[] { 2, 2, 2 },
//					a.add4(new int[] { 1, 1, 1 }, new int[] { 1, 1, 1 }));
//			assertArrayEquals(new int[] { 2, 4, 2 },
//					a.add4(new int[] { 1, 1, 1 }, new int[] { 1, 3, 1 }));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/*
	 * test exception
	 */
	@Test(expected = Exception.class)
	public void testArrayAddWithException() throws Exception {
		assertArrayEquals(new int[] { 2, 2, 2 },
				a.add4(new int[] { 1, 1 }, new int[] { 1, 1, 1 }));

	}	

}
