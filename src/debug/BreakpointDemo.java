package debug;

/**
 * Use this demo to see how 'conditional breakpoints' work in debug mode
 * 
 * @author nlhsueh
 *
 */

public class BreakpointDemo {

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 10, 9, 6, 7 };

		for (int i = 0; i < data.length-1; i++) {
			if (data[i] > data[i + 1]) { //please set breakpoint here
				// do something
			}
		}
	}
}

