package debug;

public class ExceptionDemo2 {

	public static void main(String[] args) {
		ExceptionDemo2 at = new ExceptionDemo2();
		try {
			System.out.println(at.checkTriangle(10, 23, 11));
			System.out.println(at.checkTriangle(1, 1, 1));
			System.out.println(at.checkTriangle(2, 2, 3));
			System.out.println(at.checkTriangle(3, 2, 2));
			System.out.println(at.checkTriangle(0, -1, -2));
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}
	}

	public String checkTriangle(int a, int b, int c) throws Exception {
		if (a <= 0 || b <= 0 || c <= 0) {
			throw new Exception("長度不可以是負的");
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