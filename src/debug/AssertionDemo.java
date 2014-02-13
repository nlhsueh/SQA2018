package debug;

import java.util.Scanner;

public class AssertionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AssertionDemo demo = new AssertionDemo();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input an integer");
		int input;

		input = scanner.nextInt();
		while (input != -99) {
			// no assert
			System.out.println(input % 3);
			demo.check1(input);
			
			// using assert
			demo.check2(input);

			// if the method is not public, you may know the constraint of the
			// argument so the "incident" will not occur. But you can still use
			// assert to make your method readable and reliable
			if (input > 0) {
				demo.check1(input);
			}

			System.out.println("Please input an integer");
			input = scanner.nextInt();
		}

		Caller c = new Caller();
		c.m1();
	}

	private void check1(int value) {
		if (value % 3 == 0) {
			System.out.println("3n");
		} else if (value % 3 == 1) {
			System.out.println("3n+1");
		} else { // value %3 ==2
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
