package debug;

public class AssertionDemo1 {

	public static void main(String[] args) {
		AssertionDemo1 at = new AssertionDemo1();
		System.out.println(at.checkTriangle(10, 23, 11));
		System.out.println(at.checkTriangle(1, 1, 1));
		System.out.println(at.checkTriangle(2, 2, 3));
		System.out.println(at.checkTriangle(3, 2, 2));
		System.out.println(at.checkTriangle(0, -1, -2));
	}

	public String checkTriangle(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			System.out.println("長度不可以是負的");
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