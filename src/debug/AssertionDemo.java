package debug;

import java.util.Scanner;

/*
 * To demo how to use assertion to make your program robust
 * 1. to make the assertion work, you must enable it. 
 * 2. enable the assertion: run configuration >> Arguments >> VM arguments: -ea
 */
public class AssertionDemo {

	public static void main(String[] args) {
		AssertionDemo demo = new AssertionDemo();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input an integer");
		int input;

		input = scanner.nextInt();
		while (input != -99) {
			// no assert
			demo.check1(input);

			// using assert
			// demo.check2(input);

			System.out.println("Please input an integer");
			input = scanner.nextInt();
		}

		Caller c = new Caller();
		c.m1();
	}

	// assert is not use
	private void check1(int value) {
		if (value % 3 == 0) {
			System.out.println("3n");
		} else if (value % 3 == 1) {
			System.out.println("3n+1");
		} else {
			// value %3 ==2
			System.out.println("3n+2");
		}
	}

	/*
	 * Using assert
	 */
	private void check2(int value) {
		if (value % 3 == 0) {
			System.out.println("3n");
		} else if (value % 3 == 1) {
			System.out.println("3n+1");
		} else { // value %3 ==2

			assert (value % 3 == 2);
			System.out.println("3n+2");
		}
	}

	/*
	 * if the method is public (service), do not use assertion to do your
	 * argument check. Use Exception
	 */
	public void check(int value) throws Exception {
		if (value < 0)
			throw new Exception("the value must be larger 0");

		if (value % 3 == 0) {
			System.out.println("3n");
		} else if (value % 3 == 1) {
			System.out.println("3n+1");
		} else {
			assert (value % 3 == 2);
			System.out.println("3n+2");
		}
	}
}

/*
 * 這個程式只是為了 demo 呼叫 check 時，若帶入一個錯誤的值，被呼叫端應該要處理（拋出例外）， 
 * 而非只是 assert
 */
class Caller {
	void m1() {
		AssertionDemo demo = new AssertionDemo();

		// note check is a public method (service), "argument checking" is an
		// important task
		try {
			demo.check(-100);
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
	}
}
