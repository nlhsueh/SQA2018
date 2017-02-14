package debug;

/*
 * 這是一個有錯的程式，請利用 breakpoint 來除錯
 */
public class BreakpointDemo {

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 10, 9, 6, 7 };
		System.out.print("data:\t");
		printArray(data);

		// 產生一個新的 data2 陣列，但部分內容對調
		int len = data.length;
		int a = (int) (Math.random() * len + 1);
		int b = (int) (Math.random() * len + 1);
		// 預期 data 內的資料不會受影響
		int[] data2 = exchange(data, a, b);

		System.out.print("data2:\t");
		printArray(data2);//看看 交換後的狀況
		System.out.print("data:\t");
		printArray(data); //data 不該有異動

		sort(data); //這時候 data 會有異動
		System.out.print("data:\t");
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