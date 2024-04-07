import java.util.Scanner;

public class SecondProgramV2 {
	// again, why we need statics?
	public static void checkScore(int max, int score) {
		double percentage = (double) score / max * 100;
		if (percentage >= 80) {
			System.out.println("=> Excellent\n");
		} else if (percentage < 80 && percentage >= 60) {
			System.out.println("=> Good\n");
		} else
			System.out.println("=> Needs improvement\n");
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Enter maximum: ");
				String maxS = input.nextLine();
				if (maxS.isEmpty()) {
					System.out.println("Bye!");
					break;
				}
				System.out.print("Enter game score: ");
				int max = Integer.parseInt(maxS);
				int score = Integer.parseInt(input.nextLine());
				if (max < score || max < 0 || score < 0) {
					System.out.println("=>Invalid Integer\n");
				} 
				checkScore(max, score);
				
			} catch (NumberFormatException e) {
				System.out.println("=> The score should be an integer\n");
				
			}

		}
		input.close();
	}

}
