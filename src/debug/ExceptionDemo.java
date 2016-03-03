package debug;

/*
 * This program will demo how to define Exception
 */
public class ExceptionDemo {

	public static void main(String[] args) {
		int[] grade = { 100, 2, -2 };
		try {
			getGradeAverage(grade);
		} catch (WrongGradeException e) {
			e.printStackTrace();
		}
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