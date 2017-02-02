package junitdemo;

/*
 * This is a demo program to show how JUnit4 works for you
 */

public class SimpleAdd {



	public int add(int a, int b) {
		return a + b;
		// return 0;
	}

	/*
	 * addition by using "for"
	 */
	public int add2(int a, int b) {
		int x = b;
		for (int i = 0; i < a; i++) {
			x = x + 1;
			// i--; //if your run this, will cause infinite loop
		}
		return x;
	}

	/*
	 * partial addition: only the integer part
	 */
	public int add3(double a, double b) {
		return (int) a + (int) b;
	}

	/*
	 * addition of array
	 */
	public int[] add4(int a[], int b[]) throws Exception {
		if (a.length != b.length) {
			throw new Exception("different size of array");
		}
		int c[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i] + b[i];
		}
		return c;
	}

}
