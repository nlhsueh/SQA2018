package debug;

public class BreakpointDemo1 {
	public static void main(String[] args) {
		int total = 7;
		int people = 2;
		double avg = total / people;
		int std = 3;

		int money = 1000;
		if (avg - std <= 0)
			money += 100;
		else
			money -= 100;
		// what is the value of money?
		System.out.println(money);
	}
}
