package debug;

public class BreakpointDemo {

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 10, 9, 6, 7 };
		int len = data.length;
		printArray(data);

		// 產生一個新的 data2 陣列，但部分內容對調
		int a = (int) (Math.random() * len + 1);
		int b = (int) (Math.random() * len + 1);

		int[] data2 = exchange(data, a, b);

		printArray(data2);//看看 交換後的狀況 
		printArray(data); //data 不該有異動

		sort(data);
		printArray(data);//看看排序是否正確
	}

	public static int[] exchange(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		return data;
	}

	public static void sort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] > data[i + 1]) {
				data[i] = data[i + 1];
				data[i + 1] = data[i];
			}
		}
	}

	public static void printArray(int[] data) {
		for (int x : data)
			System.out.print(x + "\t");
		System.out.println();
	}

}