package eclemma;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void testCheckTriangle() {
		Triangle t = new Triangle();
		assertEquals("正三角形", t.checkTriangle(11, 11, 11));		
	}
}
