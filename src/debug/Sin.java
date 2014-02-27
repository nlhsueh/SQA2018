package debug;

/*
 * This is a buggy program, use the debug concept to debug this program
 */
public class Sin {

	static double stop = 0.001;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sin s = new Sin();
		System.out.println("The value of sin(30')");
		System.out.println(s.sin(Math.PI/6.0));
	}

	public double sin(double x) {

		int n = 2; // 一開始跑的個數; starting loop number
		int inc = 3; // 每一次多加 inc 個個數; we add inc loop each time
		double stop = 0.000000000001; // 停止的條件; the stopping criteria

		double s1 = sin(x, n);
		n = n + inc;
		double s2 = sin(x, n);

		while (Math.abs(s2 - s1) >= stop) {
			s1 = s2;
			n = n + inc;
			s2 = sin(x, n);
		}

		return s2;
	}

	// n: number of items, for example, x-x^3/3!+x^5/5!, then n=3
	double sin(double x, int n) {

		double v = x;
		int postive = 1;
		for (int i = 1; i < 2 * n; i = i + 2) {
			v = v + postive * (Math.pow(x, i) / factorial(i));
			postive = postive * -1;
		}

		return v;
	}

	// 數學的階乘; factorial(3) = 3*2*1
	double factorial(double s) {
		double r = 1;

		for (int i = 1; i <= s; i++) {
			r = r * i;
		}
		return r;
	}

}