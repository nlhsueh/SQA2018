package junitdemo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * This program will test @BeforeClass, @AfterClass, @Before, @After
 * 
 * Run this program to see the "sequence" of the method call
 */
public class JUnitDemo01 {

	@BeforeClass
	public static void m1() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void m2() {
		System.out.println("@AfterClass");
	}

	@Before
	public void m3() {
		System.out.println("@Before");
	}

	@After
	public void m4() {
		System.out.println("@After");
	}

	@Test
	public void testf1() {
		System.out.println("testf1");
	}

	@Test
	public void testf2() {
		System.out.println("testf2");
	}

}

/*
 * The class to be tested
 */
class F {

	int f1() {
		return 1;
	}

	int f2() {
		return 2;
	}

}
