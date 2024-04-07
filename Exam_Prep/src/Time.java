import java.util.Scanner;

class Time {
	private int hours;
	private int minutes;

	public Time() {
		;
		this.minutes = 0;
		this.hours = 0;
	}

	public void setTime(int hours, int minutes) {
		this.minutes = minutes;
		this.hours = hours;
	}

	public void read(String message, Scanner scanner) {
		System.out.print(message + " : ");
		String time = scanner.nextLine();
		//match regex
		this.hours = Integer.parseInt(time.substring(0, 2));
		this.minutes = Integer.parseInt(time.substring(3, 5));
		System.out.println(this.hours + ":" + this.minutes);
	}

	public boolean lessThan(Time other) {
		if (this.hours < other.hours || (this.hours == other.hours && this.minutes < other.minutes)) {
			return true;
		}
		return false;
	}

	public Time subtract(Time other) {
		return this;
	}

	public void display() {

	}

}

//todo
//regex to get right time
//		Pattern pattern = pattern.compile();
//Matcher matcher = pattern.matcher(time);
