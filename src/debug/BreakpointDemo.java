package debug;

public class BreakpointDemo {

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 10, 9, 6, 7 };
		int a = 1;
		int b = 2;
		int c = a + b; // please set breakpoint here

		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] > data[i + 1]) { // please set breakpoint here
				data[i] = data[i+1];
				data[i+1] = data[i];
			}
		}
	}
}