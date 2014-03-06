package junitdemo;

import java.util.Random;

/**
 * 這個程式有錯誤。
 * 
 * 再開始修改這個程式以前，先建立他的 JUnit 模組，並測試它。修復它之後再用 JUnit 重新測試
 *
 */
public class BubbleSort {	
		
	public void bubbleSort(int[] data) {
		int length = data.length-1;
		int temp=0;		
		
		for (int path=0; path<length; path++) {
			for (int i=0; i<length-path; i++) {
				if (data[i] > data[i+1]) {
					temp = data[i];
					data[i] = temp;
					data[i+1] = data[i];
				}
			}
		}		
	}

}