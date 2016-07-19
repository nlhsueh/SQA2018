package whitebox;

public class Average { 

	public void av(int[] value) {
		int sum = 0, valid = 0, min = 0, max = 100, input = 0;
		@SuppressWarnings("unused")
		double average = 0;

		while (value[input] != -999 && input < 100) {

			if (value[input] >= min && value[input] <= max) {
				valid++;
				sum = sum + value[input];
			}
			input++;
		}
		if (valid > 0) {
			average = sum / valid;
		} else {
			average = -999;
		}
	}
}
