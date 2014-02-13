package debug;

import java.util.Random;

/**
 * This program has a defect, please use debug tool to find out it and fix it
 *
 */
public class BubbleSort {	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data;
		data = new int[10];
		Random r = new Random();
		
		for (int i=0; i<10; i++) {
			data[i] = r.nextInt(100);
		}
		
		BubbleSort bs = new BubbleSort();
		
		bs.bubbleSort(data);
		System.out.println("Bubble sort complete");
	}
	
	public void bubbleSort(int[] data) {
		int length = data.length;
		int temp=0;
		
		for (int path=0; path<length; path++) {
			for (int i=0; i<length-path; i++) {
				if (data[i] > data[i+1]) {
					temp = data[i];
					data[i] = data[i+1];
					data[i+1] = temp;
				}
			}
		}		
	}

}