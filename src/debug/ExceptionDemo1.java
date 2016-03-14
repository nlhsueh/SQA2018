package debug;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		// case 1
		openFile();

		// case 2
		try {
			openFile2();
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
			System.exit(0);
		}

		// case 3
		try {
			openFile3();
		} catch (FileNotFoundException e) {
			System.exit(0);
		}
	}

	static void openFile() {
		try {
			FileInputStream f = new FileInputStream("grade.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
			e.printStackTrace();
		}

	}

	static void openFile2() throws FileNotFoundException {
		FileInputStream f = new FileInputStream("grade.txt");
	}

	static void openFile3() throws FileNotFoundException {
		try {
			FileInputStream f = new FileInputStream("grade.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
			// re-throw the exception
			throw new FileNotFoundException();
		}
	}

}