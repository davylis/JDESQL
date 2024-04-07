import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ObjectsCityNames {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> cities = new ArrayList<String>();
		String city = "";
		while (true) {
			System.out.print("Enter city name: ");
			city = input.nextLine();
			if(city.equalsIgnoreCase("quit")) {
				break;
			}
			cities.add(city.toUpperCase());
		}
		Collections.sort(cities);
		System.out.println();
		for (String s : cities) {
			System.out.println(s);
		}
	}
}
