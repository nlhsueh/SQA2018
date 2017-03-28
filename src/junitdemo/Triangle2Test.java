package junitdemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class Triangle2Test {

	@Test
	public void testCheckTriangle2() {
		Triangle2 t = new Triangle2();
		assertEquals("正三角形", t.checkTriangle(11, 11, 11));		
	}
}
