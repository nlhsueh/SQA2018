package junitdemo;

import static org.junit.Assert.*;

import org.junit.Test;

enum TriangleType {
	NotTriangle, Isosceles, Regular
}

public class EclemmaDemo {
	public TriangleType check(int a, int b, int c) {
		boolean c1, c2, c3;
		c1 = a + b > c;
		c2 = b + c > a;
		c3 = a + c > b;
		if (c1 && c2 && c3) {
			if (a == b) {
				if (b == c)
					return TriangleType.Regular;
				else
					return TriangleType.Isosceles;
			} else if (b == c) {
				if (c == a)
					return TriangleType.Regular;
				else
					return TriangleType.Isosceles;
			} else if (c == a) {
				if (a == b)
					return TriangleType.Regular;
				else
					return TriangleType.Isosceles;
			}
		}
		return TriangleType.NotTriangle;
	}
}

class TriangleTest2 {

	@Test
	public void doTest() {
		EclemmaDemo d = new EclemmaDemo();
		assertEquals(TriangleType.NotTriangle, d.check(1, 1, 10));
	}
}
