import java.util.Arrays;

class Statistics {
	private int[] array;
	
	public Statistics(int [] array) {
		this.array = array;
	}
	public int getMin() {
		int min = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i]<min) {
				min=array[i];
			}
		}
		return min;
	}
	//why i dont use parameter int[]
	public int getMax() {
		int max = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i]>max) {
				max=array[i];
			}
		}
		return max;
	}
	public double getAverage() {
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
			}
		double average = (double)sum/array.length;
		return average;
	}
	//important!! Remember to write toString, not getString
	public String toString() {
		double average = getAverage();
		String data = Arrays.toString(this.array);
		//substring
		data = data.substring(1, data.length()-1);
		String result = "The values are between " + getMin() + " and " + getMax(); 
		result += String.format("\nThe average is %.1f",average);
		result += "\nData: " + data ;
		return result;
	}
}

