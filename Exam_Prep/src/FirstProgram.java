
public class FirstProgram {

	public static void main(String[] args) {
		int[] a1 = {5, 3, 7, 1};
		int[] a2 = {2, 7, 1, 8, -5, 3};
		
		Statistics stats_1 = new Statistics(a1);
		Statistics stats_2 = new Statistics(a2);
		
		System.out.println(stats_1);
		System.out.println();
		System.out.println(stats_2);
	}

}
