package junitdemo;

/*
 * 這是一個有 bug 的程式，請應用 debug 的觀念與工具來除錯。
 * 
 * This is a buggy program, use the debug concept to debug this program
 */
public class Sin {

	static double stop = 0.001;

	public static void main(String[] args) {
		Sin s = new Sin();
		System.out.println("The value of sin(30')");
		System.out.println(s.sin(Math.PI / 6.0));
	}

	/*
	 * @param x: 徑度
	 * 
	 * 這個程式透過泰勒展開世紀算 x 的 sine 值。由於泰勒展開式可以一直展到無窮值，我們在程式中必須設定停止的條件。一開始我們讓他跑 n
	 * 次，然後每次加 inc 個單位，當相鄰的兩次差距小於 stop 時就停止，否則就繼續算下去。
	 */
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

	/*
	 * @param n: number of items, for example, x-x^3/3!+x^5/5!, then n=3
	 * 
	 * 這個副程式裡面有不少的變數，可以使用 breakpoint 讓程式停在這個副程式，再使用 variable view
	 * 來看執行過程中這些變數的變化。
	 */
	double sin(double x, int n) {
		double v = x;
		int postive = 1;
		for (int i = 1; i < 2 * n; i = i + 2) {

			// (Math.pow(x, i) / factorial(i)) 這個值有點複雜，你可以用 expression view
			// 來看一下這個值是不是你期望的
			v = v + postive * (Math.pow(x, i) / factorial(i));
			postive = postive * -1;
		}

		return v;
	}

	/*
	 * 數學的階乘; factorial(3) = 3*2*1
	 */
	double factorial(double s) {
		double r = 1;

		for (int i = 1; i <= s; i++) {
			r = r * i;
		}
		return r;
	}

}