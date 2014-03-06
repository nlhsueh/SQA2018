package debug;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * This program will demo how to use Exception
 */
public class ExceptionDemo {

	public static void main(String[] args) {
		openFile();

		// compare with openFile(), here you need to handle the exception
		try {
			openFile2();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			div(12, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int[] grade = { 100, 2, -2 };
		try {
			getGradeAverage(grade);
		} catch (WrongGradeException e) {
			e.printStackTrace();
		}

	}

	/*
	 * This program will demo how to catch and handle an exception
	 */
	static void openFile() {
		try {
			FileInputStream f = new FileInputStream("grade.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/*
	 * This program will demo how to re-throw the caught exception
	 */
	static void openFile2() throws FileNotFoundException {
		try {
			FileInputStream f = new FileInputStream("grade.txt");
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}

	/*
	 * This program will demo how to check and throw an exception
	 */
	static double div(int x, int y) throws Exception {
		if (y == 0)
			throw new Exception("Divided by zero exception");
		return x / ((double) y);
	}

	/*
	 * This program will demo how to define and use your exception
	 */
	static double getGradeAverage(int g[]) throws WrongGradeException {
		int sum = 0;
		for (int i = 0; i < g.length; i++) {
			if (g[i] > 100 || g[i] < 0) {
				throw new WrongGradeException();
			}
			sum += g[i];
		}
		return sum / (double) (g.length);
	}
}

class WrongGradeException extends Exception {
	public WrongGradeException(String title) {
		super(title);
	}

	public WrongGradeException() {
		super("The grade is wrong, maybe greater than 100 or less than 0");
	}
}