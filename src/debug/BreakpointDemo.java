package debug;

public class BreakpointDemo {

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 10, 9, 6, 7 };
		int len = data.length;
		printArray(data);
		sort(data);
		printArray(data);// 看看排序是否正確

		// 產生一個新的 data2 陣列，但部分內容對調
		int a = (int) (Math.random() * len); // remove +1
		int b = (int) (Math.random() * len); // remove +1

		// set breakpoint here to see a, b
		int[] data2 = exchange(data, a, b);

		// trace the code by "step by step run", use "variable to see the
		// difference between data and data2
		printArray(data2);// 看看 交換後的狀況
		printArray(data); // data 不該有異動

		sort(data);
		printArray(data);// 看看排序是否正確
	}

	public static int[] exchange(int[] data, int i, int j) {
		// copy data to another array (data2) before the exchange
		int data2[] = new int[data.length];
		for (int k = 0; k < data.length; k++) {
			data2[k] = data[k];
		}
		int temp = data2[i];
		data2[i] = data2[j];
		data2[j] = temp;
		return data2;
	}

	public static void sort(int[] data) {
		int temp;
		// need 2-for loop to do the sort
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - 1; j++) {
				if (data[j] > data[j + 1]) {
					temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}
	}

	public static void printArray(int[] data) {
		for (int x : data)
			System.out.print(x + "\t");
		System.out.println();
	}

}