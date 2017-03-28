package junitdemo;
/* Test this program by JUnit, Note it is buggy.
 */
public class Triangle2 {
	public String checkTriangle(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			System.out.println("長度不可以是負的");
			System.exit(0);
		}
		assert a > 0 && b > 0 && c > 0;
		if (a + b > c && b + c > a && c + a > b) {
			if (a == b)
				if (b == c) {
					return "正三角形";
				} else
					return "等腰三角形";
			else if (b == c) {
				assert (a != b);
				return "等腰三角形";
			}
			assert (a != b);
			assert (a != c);
			assert (b != c);
			return "三角形";
		}
		return "非三角形";
	}
}
